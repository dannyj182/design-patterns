package ar.com.builder.example;

import ar.com.builder.example.builders.CarBuilder;
import ar.com.builder.example.builders.CarManualBuilder;
import ar.com.builder.example.cars.Car;
import ar.com.builder.example.cars.Manual;
import ar.com.builder.example.director.Director;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();

        director.constructSportsCar(builder);
        Car sportsCar = builder.getResult();
        System.out.println("Car built: " + sportsCar.getCarType());

        director.constructSUV(builder);
        Car suvCar = builder.getResult();
        System.out.println("Car built: " + suvCar.getCarType());

        director.constructCityCar(builder);
        Car cityCar = builder.getResult();
        System.out.println("Car built: " + cityCar.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}