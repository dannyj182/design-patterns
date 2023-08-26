package ar.com.abstract_factory.example.tienda;

import ar.com.abstract_factory.example.tienda.fabricas.*;
import ar.com.abstract_factory.example.tienda.muebles.*;

public class Main {
    public static void main(String[] args) {
        // Crear una fábrica de muebles modernos
        FabricaMuebles fabricaModernos = new FabricaMueblesModernos();

        // Crear muebles modernos
        Silla sillaModerna = fabricaModernos.crearSilla();
        Sofa sofaModerno = fabricaModernos.crearSofa();
        Mesa mesaModerna = fabricaModernos.crearMesa();

        // Utilizar los muebles modernos
        sillaModerna.sentarse();
        sofaModerno.recostarse();
        mesaModerna.colocarObjetos();

        // Crear una fábrica de muebles victorianos
        FabricaMuebles fabricaVictorianos = new FabricaMueblesVictorianos();

        // Crear muebles victorianos
        Silla sillaVictoriana = fabricaVictorianos.crearSilla();
        Sofa sofaVictoriano = fabricaVictorianos.crearSofa();
        Mesa mesaVictoriana = fabricaVictorianos.crearMesa();

        // Utilizar los muebles victorianos
        sillaVictoriana.sentarse();
        sofaVictoriano.recostarse();
        mesaVictoriana.colocarObjetos();
    }
}