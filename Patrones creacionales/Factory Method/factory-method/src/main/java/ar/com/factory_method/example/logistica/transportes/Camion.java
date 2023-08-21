package ar.com.factory_method.example.logistica.transportes;

public class Camion implements Transporte {
    @Override
    public void transportarCarga() {
        System.out.println("El camión transporta carga por carretera.");
    }
}
