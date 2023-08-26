package ar.com.abstract_factory.example.tienda.fabricas;

import ar.com.abstract_factory.example.tienda.muebles.*;
import ar.com.abstract_factory.example.tienda.muebles.tipo_mueble.moderno.*;

public class FabricaMueblesModernos implements FabricaMuebles {
    @Override
    public Silla crearSilla() {
        return new SillaModerna();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaModerno();
    }

    @Override
    public Mesa crearMesa() {
        return new MesaModerna();
    }
}