# Prototype

Es un patrón de diseño creacional que se utiliza para crear nuevos objetos duplicando un objeto existente, que actúa como prototipo. En otras palabras, el patrón Prototype permite la creación de nuevos objetos basados en objetos ya existentes, conocidos como prototipos, en lugar de crearlos desde cero.

## Estructura

![Estructura del patrón](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Prototype/assets/mdImages/p1.png?raw=true)

1. La interfaz **`Prototipo`** declara los métodos de clonación. En la mayoría de los casos, se trata de un único método **`clonar`**.

2. La clase **`Prototipo Concreto`** implementa el método de clonación. Además de copiar la información del objeto original al clon, este método también puede gestionar algunos casos extremos del proceso de clonación, como, por ejemplo, clonar objetos vinculados, deshacer dependencias recursivas, etc.

3. El **`Cliente`** puede producir una copia de cualquier objeto que siga la interfaz del prototipo.

### Uso del Patrón Prototype

En este ejemplo, el patrón Prototype nos permite producir copias exactas de objetos geométricos sin acoplar el código a sus clases.

![Estructura del patrón](https://github.com/dannyj182/design-patterns/blob/main/Patrones%20creacionales/Prototype/assets/mdImages/p2.png?raw=true "Clonación de un grupo de objetos que pertenece a una jerarquía de clase.")

Clonación de un grupo de objetos que pertenece a una jerarquía de clase.

La clase abstracta **`Shape`** y las clases concretas (**`Circle`** y **`Rectangle`**) que la heredan las podemos escribir de la siguiente manera:

```java
public abstract class Shape {
    private int x;
    private int y;
    private String color;

    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }
}

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, String color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height, String color) {
        super(width, height, color);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}
```

Observe que las clases concretas (**`Circle`** y **`Rectangle`**) tienen dos constructores, el primero se usará para crear una nueva instancia y el segundo se utiliza para clonar el objeto. También se sobreescribe el método **`equals`** para comparar si dos objetos poseen el mismo estado interno (son clones).

En nuestro código principal, vamos a crear instancias de las clases **`Circle`** y **`Rectangle`**, las vamos a agregar a una lista, clonar los elementos de esa lista e incorporarlas en otra lista para comparar si las instancias originales y sus clones son iguales:

```java
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle(10, 20, "red", 15);
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle(10, 20, "blue");
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
```

Resultados de la ejecución debe dar algo así:

```
0: Shapes are different objects (yay!)
0: And they are identical (yay!)
1: Shapes are different objects (yay!)
1: And they are identical (yay!)
2: Shapes are different objects (yay!)
2: And they are identical (yay!)
```

## Ventajas del Patrón Prototype

- **Creación de objetos más eficiente:** En situaciones en las que la creación de un objeto es costosa en términos de recursos o tiempo de procesamiento, el patrón Prototype permite crear copias de objetos existentes en lugar de crear nuevos objetos desde cero. Esto mejora la eficiencia y el rendimiento de la aplicación.

- **Facilita la creación de objetos complejos:** Cuando un objeto tiene una estructura complicada o requiere una configuración especial, el patrón Prototype permite clonar un objeto existente y luego ajustar solo las partes necesarias para crear un nuevo objeto, evitando la complejidad de crearlo desde cero.

- **Mantiene la consistencia de los objetos:** Garantiza que los objetos clonados sean consistentes en términos de su estado y comportamiento, ya que se basan en un prototipo existente. Esto es especialmente útil en aplicaciones donde se necesita uniformidad.

- **Fomenta la flexibilidad en el diseño:** Permite agregar o modificar tipos de objetos en tiempo de ejecución. Esto proporciona flexibilidad en el diseño y facilita la extensión de la aplicación sin modificar el código existente.

- **Reducción de la complejidad del código cliente:** El código cliente puede crear nuevos objetos simplemente clonando prototipos existentes, sin preocuparse por la lógica detallada de construcción de objetos.

- **Aplicación en sistemas distribuidos:** En sistemas distribuidos, clonar objetos puede ser más eficiente que transferirlos a través de la red. El patrón Prototype facilita la creación de copias locales de objetos en sistemas distribuidos.

## Créditos

La información e imágenes que ven en este repositorio es gracias a mi formación autodidacta usando como referencia el libro **`Sumérgete en los PATRONES de DISEÑO`** del autor Alexander Shvets.