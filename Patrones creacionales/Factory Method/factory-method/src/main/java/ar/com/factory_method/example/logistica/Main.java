package ar.com.factory_method.example.logistica;

import ar.com.factory_method.example.logistica.fabricas.*;
import ar.com.factory_method.example.logistica.transportes.*;

public class Main {
    public static void main(String[] args) {
        // Usar la fábrica de camiones para crear un camión
        FabricaTransportes fabricaCamiones = new FabricaCamiones();
        Transporte camion = fabricaCamiones.crearTransporte();

        // Usar la fábrica de barcos para crear un barco
        FabricaTransportes fabricaBarcos = new FabricaBarcos();
        Transporte barco = fabricaBarcos.crearTransporte();

        camion.transportarCarga();
        barco.transportarCarga();
    }
}