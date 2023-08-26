package ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.moderno;

import ar.com.abstract_factory.example.tienda.muebles.Sofa;

public class SofaModerno implements Sofa {
    @Override
    public void recostarse() {
        System.out.println("Recostándose en un sofá moderno.");
    }
}