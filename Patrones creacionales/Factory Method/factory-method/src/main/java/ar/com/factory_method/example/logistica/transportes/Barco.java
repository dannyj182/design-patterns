package ar.com.factory_method.example.logistica.transportes;

public class Barco implements Transporte {
    @Override
    public void transportarCarga() {
        System.out.println("El barco transporta carga por mar.");
    }
}
