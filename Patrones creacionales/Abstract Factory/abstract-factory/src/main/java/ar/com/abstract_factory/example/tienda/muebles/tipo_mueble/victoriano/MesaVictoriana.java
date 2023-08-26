package ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.victoriano;

import ar.com.abstract_factory.example.tienda.muebles.Mesa;

public class MesaVictoriana implements Mesa {
    @Override
    public void colocarObjetos() {
        System.out.println("Colocando objetos en una mesa victoriana.");
    }
}