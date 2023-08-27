# Factory Method

Es un patrón de diseño creacional que se utiliza para crear objetos de un tipo determinado sin especificar la clase exacta del objeto que se creará. En el contexto de una empresa de logística, este patrón puede utilizarse para crear diferentes tipos de vehículos de transporte, como camiones y barcos, de manera flexible y encapsulada.

## Ejemplo

Supongamos que tenemos una empresa de logística que necesita gestionar el transporte de mercancías a través de camiones y barcos. Utilizamos el patrón Factory Method para crear instancias de estos transportes de la siguiente manera:

### Clases y Interfaces

El patrón Factory Method sugiere que, en lugar de llamar al operador `new` para construir objetos directamente, se invoque a un método fábrica especial. No te preocupes: los objetos se siguen creando a través del operador `new` , pero se invocan desde el método fábrica. Los objetos devueltos por el método fábrica a menudo se denominan productos.

![Diagrama UML sobre como quedaría FabricaTransportes y sus subclases](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Factory%20Method/assets/mdImages/fm1.png?raw=true "Las subclases pueden alterar la clase de los objetos devueltos por el método fábrica")

Las subclases pueden alterar la clase de los objetos devueltos por el método fábrica.

1. **`FabricaTransportes` (interfaz):** Define la interfaz para las fábricas de transporte.

2. **`FabricaCamiones` (clase concreta):** Implementa la interfaz `FabricaTransportes` para crear instancias de camiones.

3. **`FabricaBarcos` (clase concreta):** Implementa la interfaz `FabricaTransportes` para crear instancias de barcos.

Nota: La imagen hace referencia a `Logistics` como una clase abstracta, también puedes usar una interfaz.

![Diagrama UML sobre como quedaría la interfaz Transporte y las clases que la implementen](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Factory%20Method/assets/mdImages/fm2.png?raw=true "Todos los productos deben seguir la misma interfaz")

Todos los productos deben seguir la misma interfaz.

4. **`Transporte` (interfaz):** Define la interfaz común para todos los tipos de transporte.

5. **`Camion` (clase concreta):** Implementa la interfaz `Transporte` para representar un camión.

6. **`Barco` (clase concreta):** Implementa la interfaz `Transporte` para representar un barco.

Tanto la clase `Camion` como la clase `Barco` deben implementar la interfaz `Transporte`, que declara un método llamado `deliver`. Cada clase implementa este método de forma diferente: los camiones entregan su carga por tierra, mientras que los barcos lo hacen por mar. El método fábrica dentro de la clase `RoadLogistics` devuelve objetos de tipo camión, mientras que el método fábrica de la clase `SeaLogistics` devuelve barcos.

## Estructura

![Estructura del patrón](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Factory%20Method/assets/mdImages/fm3.png?raw=true)

1. El **`Producto`** declara la interfaz, que es común a todos los objetos que puede producir la clase creadora y sus subclases.

2. Los **`Productos Concretos`** son distintas implementaciones de la interfaz de producto.

3. La clase **`Creadora`** declara el método fábrica que devuelve nuevos objetos de producto. Es importante que el tipo de retorno de este método coincida con la interfaz de producto. La clase **`Creadora`** puede ser una clase abstracta o una interfaz.

4. Los **`Creadores Concretos`** sobrescriben el Factory Method base, de modo que devuelva un tipo diferente de producto.

### Uso del Patrón Factory Method

La interfaz **`Transporte`** y las clases (**`Camion`** y **`Barco`**) que la implementan las podemos escribir de la siguiente manera:

```java
public interface Transporte {
    void transportarCarga();
}

public class Camion implements Transporte {
    @Override
    public void transportarCarga() {
        System.out.println("El camión transporta carga por carretera.");
    }
}

public class Barco implements Transporte {
    @Override
    public void transportarCarga() {
        System.out.println("El barco transporta carga por mar.");
    }
}
```

La interfaz **`FabricaTransportes`** y las clases (**`FabricaCamiones`** y **`FabricaBarcos`**) que la implementan las podemos escribir de la siguiente manera:

```java
public interface FabricaTransportes {
    Transporte crearTransporte();
}

public class FabricaCamiones implements FabricaTransportes {
    @Override
    public Transporte crearTransporte() {
        return new Camion();
    }
}

public class FabricaBarcos implements FabricaTransportes {
    @Override
    public Transporte crearTransporte() {
        return new Barco();
    }
}
```

En nuestro código principal, podemos utilizar las fábricas de transporte para crear instancias de camiones y barcos de la siguiente manera:

```java
public class Main {
    public static void main(String[] args) {
        // Usar la fábrica de camiones para crear un camión
        FabricaTransportes fabricaCamiones = new FabricaCamiones();
        Transporte camion = fabricaCamiones.crearTransporte();

        // Usar la fábrica de barcos para crear un barco
        FabricaTransportes fabricaBarcos = new FabricaBarcos();
        Transporte barco = fabricaBarcos.crearTransporte();

        camion.transportarCarga();
        barco.transportarCarga();
    }
}
```

## Ventajas del Patrón Factory Method

- **Flexibilidad:** Permite agregar nuevos tipos de transporte (por ejemplo, trenes) sin modificar el código existente.

- **Encapsulación:** Oculta los detalles de creación de objetos, lo que facilita el mantenimiento y la extensión del sistema.

- **Reutilización:** Promueve la reutilización del código de creación de objetos a través de las fábricas.

## Créditos

La información e imágenes que ven en este repositorio es gracias a mi formación autodidacta usando como referencia el libro **`Sumérgete en los PATRONES de DISEÑO`** del autor Alexander Shvets.