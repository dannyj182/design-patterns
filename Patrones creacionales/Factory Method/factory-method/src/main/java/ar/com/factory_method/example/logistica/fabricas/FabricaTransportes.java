package ar.com.factory_method.example.logistica.fabricas;

import ar.com.factory_method.example.logistica.transportes.Transporte;

public interface FabricaTransportes {
    Transporte crearTransporte();
}
