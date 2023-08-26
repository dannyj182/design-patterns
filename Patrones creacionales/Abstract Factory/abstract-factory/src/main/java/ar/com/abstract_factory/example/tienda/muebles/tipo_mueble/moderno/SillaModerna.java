package ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.moderno;

import ar.com.abstract_factory.example.tienda.muebles.Silla;

public class SillaModerna implements Silla {
    @Override
    public void sentarse() {
        System.out.println("Sentándose en una silla moderna.");
    }
}