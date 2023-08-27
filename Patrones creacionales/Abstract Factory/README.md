# Abstract Factory

Es un patrón de diseño creacional que nos permite producir familias de objetos relacionados sin especificar sus clases concretas. Esto significa que puedes crear objetos que sigan un tema común, sin preocuparte por los detalles de implementación de cada tipo específico de objeto.

## Ejemplo

Exploremos cómo el patrón Abstract Factory se puede utilizar en un simulador de tienda de muebles. La tienda ofrece muebles en dos estilos diferentes: moderno y victoriano.

### Clases y Interfaces

Lo primero que sugiere el patrón Abstract Factory es que declaremos de forma explícita interfaces para cada producto diferente de la familia de productos (por ejemplo, silla, sofá o mesa). Después podemos hacer que todas las variantes de los productos sigan esas interfaces. Por ejemplo, todas las variantes de silla pueden implementar la interfaz Silla, así como todas las variantes de mesa pueden implementar la interfaz Mesa, y así sucesivamente.

![Diagrama UML sobre como quedarían los Productos y sus clases concretas](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Abstract%20Factory/assets/mdImages/af1.png?raw=true "Todas las variantes del mismo objeto deben moverse a una única jerarquía de clase.")

Todas las variantes del mismo objeto deben moverse a una única jerarquía de clase.

1. **`Chair` (interfaz):** Define la interfaz para las sillas.

2. **`VictorianChair` (clase concreta):** Implementa la interfaz `Chair` para crear instancias de sillas victorianas.

3. **`ModernChair` (clase concreta):** Implementa la interfaz `Chair` para crear instancias de sillas modernas.

El siguiente paso consiste en declarar la *Fábrica abstracta*: una interfaz con una lista de métodos de creación para todos los productos que son parte de la familia de productos (por ejemplo, crearSilla , crearSofá y crearMesa ). Estos métodos deben devolver productos abstractos representados por las interfaces que extrajimos previamente: Silla, Sofá, Mesa , etc.

![Diagrama UML sobre como quedaría la interfaz Fabrica y las clases que la implementen](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Abstract%20Factory/assets/mdImages/af2.png?raw=true "Cada fábrica concreta se corresponde con una variante específica del producto.")

Cada fábrica concreta se corresponde con una variante específica del producto.

4. **`FurnitureFactory` (interfaz):** Define la interfaz común para todos los tipos de fabricas de muebles.

5. **`VictorianFurnitureFactory` (clase concreta):** Implementa la interfaz `FurnitureFactory` para crear instancias de fabricas de muebles victorianos.

6. **`ModernFurnitureFactory` (clase concreta):** Implementa la interfaz `FurnitureFactory` para crear instancias de fabricas de muebles modernos.

## Estructura

![Estructura del patrón](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Abstract%20Factory/assets/mdImages/af3.png?raw=true)

1. Los **`Productos Abstractos`** declaran interfaces para un grupo de productos diferentes pero relacionados que forman una familia de productos.

2. Los **`Productos Concretos`** son implementaciones distintas de productos abstractos agrupados por variantes. Cada producto abstracto (silla/sofá) debe implementarse en todas las variantes dadas (victoriano/moderno).

3. La interfaz **`Fábrica Abstracta`** declara un grupo de métodos para crear cada uno de los productos abstractos.

4. Las **`Fábricas Concretas`** implementan métodos de creación de la fábrica abstracta. Cada fábrica concreta se corresponde con una variante específica de los productos y crea tan solo dichas variantes de los productos.

5. El **`Cliente`** puede funcionar con cualquier variante fábrica/producto concreta, siempre y cuando se comunique con sus objetos a través de interfaces abstractas.

### Uso del Patrón Abstract Factory

La interfaz **`Silla`** y las clases (**`SillaVictoriana`** y **`SillaModerna`**) que la implementan las podemos escribir de la siguiente manera:

```java
public interface Silla {
    void sentarse();
}

public class SillaVictoriana implements Silla {
    @Override
    public void sentarse() {
        System.out.println("Sentándose en una silla victoriana.");
    }
}

public class SillaModerna implements Silla {
    @Override
    public void sentarse() {
        System.out.println("Sentándose en una silla moderna.");
    }
}
```

La interfaz **`FabricaMuebles`** y las clases (**`FabricaMueblesVictorianos`** y **`FabricaMueblesModernos`**) que la implementan las podemos escribir de la siguiente manera:

```java
public interface FabricaMuebles {
    Silla crearSilla();
    Sofa crearSofa();
    Mesa crearMesa();
}

public class FabricaMueblesVictorianos implements FabricaMuebles {
    @Override
    public Silla crearSilla() {
        return new SillaVictoriana();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaVictoriano();
    }

    @Override
    public Mesa crearMesa() {
        return new MesaVictoriana();
    }
}

public class FabricaMueblesModernos implements FabricaMuebles {
    @Override
    public Silla crearSilla() {
        return new SillaModerna();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaModerno();
    }

    @Override
    public Mesa crearMesa() {
        return new MesaModerna();
    }
}
```

En nuestro código principal, podemos utilizar las fábricas de muebles para crear instancias de productos concretos de la siguiente manera:

```java
public class Main {
    public static void main(String[] args) {
        // Crear una fábrica de muebles modernos
        FabricaMuebles fabricaModernos = new FabricaMueblesModernos();

        // Crear muebles modernos
        Silla sillaModerna = fabricaModernos.crearSilla();
        Sofa sofaModerno = fabricaModernos.crearSofa();
        Mesa mesaModerna = fabricaModernos.crearMesa();

        // Utilizar los muebles modernos
        sillaModerna.sentarse();
        sofaModerno.recostarse();
        mesaModerna.colocarObjetos();

        // Crear una fábrica de muebles victorianos
        FabricaMuebles fabricaVictorianos = new FabricaMueblesVictorianos();

        // Crear muebles victorianos
        Silla sillaVictoriana = fabricaVictorianos.crearSilla();
        Sofa sofaVictoriano = fabricaVictorianos.crearSofa();
        Mesa mesaVictoriana = fabricaVictorianos.crearMesa();

        // Utilizar los muebles victorianos
        sillaVictoriana.sentarse();
        sofaVictoriano.recostarse();
        mesaVictoriana.colocarObjetos();
    }
}
```

## Ventajas del Patrón Factory Method

- **Flexibilidad:** Permite cambiar fácilmente el estilo de los muebles que se crean sin modificar el código existente.

- **Encapsulación:** Oculta los detalles de creación de objetos, lo que facilita el mantenimiento y la extensión del sistema.

- **Reutilización:** Promueve la reutilización del código de creación de objetos a través de las fábricas.

## Créditos

La información e imágenes que ven en este repositorio es gracias a mi formación autodidacta usando como referencia el libro **`Sumérgete en los PATRONES de DISEÑO`** del autor Alexander Shvets.