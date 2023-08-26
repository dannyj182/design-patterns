package ar.com.abstract_factory.example.tienda.fabricas;

import ar.com.abstract_factory.example.tienda.muebles.*;

public interface FabricaMuebles {
    Silla crearSilla();
    Sofa crearSofa();
    Mesa crearMesa();
}