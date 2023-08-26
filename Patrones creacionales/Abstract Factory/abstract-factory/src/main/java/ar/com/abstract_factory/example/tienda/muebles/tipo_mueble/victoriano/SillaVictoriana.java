package ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.victoriano;

import ar.com.abstract_factory.example.tienda.muebles.Silla;

public class SillaVictoriana implements Silla {
    @Override
    public void sentarse() {
        System.out.println("Sentándose en una silla victoriana.");
    }
}