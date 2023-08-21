package ar.com.factory_method.example.logistica.fabricas;

import ar.com.factory_method.example.logistica.transportes.Camion;
import ar.com.factory_method.example.logistica.transportes.Transporte;

public class FabricaCamiones implements FabricaTransportes {
    @Override
    public Transporte crearTransporte() {
        return new Camion();
    }
}
