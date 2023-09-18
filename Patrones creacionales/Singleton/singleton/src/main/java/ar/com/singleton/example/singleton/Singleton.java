package ar.com.singleton.example.singleton;

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