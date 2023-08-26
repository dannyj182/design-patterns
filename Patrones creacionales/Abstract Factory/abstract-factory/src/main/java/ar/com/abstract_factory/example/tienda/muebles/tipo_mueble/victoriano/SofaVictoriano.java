package ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.victoriano;

import ar.com.abstract_factory.example.tienda.muebles.Sofa;

public class SofaVictoriano implements Sofa {
    @Override
    public void recostarse() {
        System.out.println("Recostándose en un sofá victoriano.");
    }
}