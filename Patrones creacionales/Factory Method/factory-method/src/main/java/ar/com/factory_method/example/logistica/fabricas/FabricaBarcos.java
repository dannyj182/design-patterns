package ar.com.factory_method.example.logistica.fabricas;

import ar.com.factory_method.example.logistica.transportes.Barco;
import ar.com.factory_method.example.logistica.transportes.Transporte;

public class FabricaBarcos implements FabricaTransportes {
    @Override
    public Transporte crearTransporte() {
        return new Barco();
    }
}
