package ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.moderno;

import ar.com.abstract_factory.example.tienda.muebles.Mesa;

public class MesaModerna implements Mesa {
    @Override
    public void colocarObjetos() {
        System.out.println("Colocando objetos en una mesa moderna.");
    }
}