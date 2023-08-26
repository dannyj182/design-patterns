package ar.com.abstract_factory.example.tienda.fabricas;

import ar.com.abstract_factory.example.tienda.muebles.*;
import ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.victoriano.*;

public class FabricaMueblesVictorianos implements FabricaMuebles {
    @Override
    public Silla crearSilla() {
        return new SillaVictoriana();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaVictoriano();
    }

    @Override
    public Mesa crearMesa() {
        return new MesaVictoriana();
    }
}