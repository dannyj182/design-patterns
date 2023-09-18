package ar.com.singleton.example;

import ar.com.singleton.example.singleton.Singleton;

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

        // También puedes usar el método toString() para comprobar
        // que ambas variables apuntan a la misma referencia
        System.out.println("Instancia 1: " + instancia1.toString());
        System.out.println("Instancia 3: " + instancia3.toString());
    }
}