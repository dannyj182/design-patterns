# Singleton

Es un patrón de diseño creacional que se utiliza para garantizar que una clase tenga una única instancia y proporciona un punto de acceso global a esa instancia. Esto es útil cuando quieres controlar el acceso a una única instancia compartida de una clase en toda tu aplicación, por ejemplo el acceso a la base de datos.

## Estructura

![Estructura del patrón](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Singleton/assets/mdImages/s1.png?raw=true)

1. La clase **`Singleton`** declara el método estático **`obtenerInstancia`** que devuelve la misma instancia de su propia clase.

El constructor del Singleton debe ocultarse del código cliente. La llamada al método **`obtenerInstancia`** debe ser la única manera de obtener el objeto de Singleton.

### Uso del Patrón Singleton

La clase **`Singleton`** la podemos escribir de la siguiente manera:

```java
public class Singleton {
    // La instancia única se almacena como una variable privada y estática.
    private static Singleton instancia;

    // El constructor se hace privado para evitar la creación de instancias desde fuera de la clase.
    private Singleton() {
        // Constructor privado.
    }

    // El método público estático para obtener la instancia única.
    public static Singleton getInstancia() {
        // Si la instancia aún no existe, la creamos.
        if (instancia == null) {
            instancia = new Singleton();
        }
        // Devolvemos la instancia existente o recién creada.
        return instancia;
    }
}
```

Nuestro código principal lo podemos escribir de la siguiente manera:

```java
public class Main {
    public static void main(String[] args) {
        // Obtener la instancia única de Singleton.
        Singleton instancia1 = Singleton.getInstancia();

        // Intentar crear una nueva instancia, lo que no es posible debido al constructor privado.
        // Singleton instancia2 = new Singleton(); // Esto dará un error de compilación.

        // Obtener la misma instancia nuevamente.
        Singleton instancia3 = Singleton.getInstancia();

        // Todas las instancias son iguales.
        System.out.println("Las instancias son iguales? " + (instancia1 == instancia3)); // Devuelve true

        // También puedes usar el método toString() para comprobar que ambas variables apuntan a la misma referencia
        System.out.println("Instancia 1: " + instancia1.toString());
        System.out.println("Instancia 3: " + instancia3.toString());
    }
}
```

Resultados de la ejecución debe dar algo así:

```
Las instancias son iguales? true
Instancia 1: paquete.Singleton@32aab886
Instancia 3: paquete.Singleton@32aab886
```

## Ventajas del Patrón Singleton

- Puedes tener la certeza de que una clase tiene una única instancia.

- Obtienes un punto de acceso global a dicha instancia.

- El objeto Singleton solo se inicializa cuando se requiere por primera vez.

## Créditos

La información e imágenes que ven en este repositorio es gracias a mi formación autodidacta usando como referencia el libro **`Sumérgete en los PATRONES de DISEÑO`** del autor Alexander Shvets.