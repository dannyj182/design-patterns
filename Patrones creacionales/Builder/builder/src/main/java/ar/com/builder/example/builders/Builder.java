package ar.com.builder.example.builders;

import ar.com.builder.example.cars.CarType;
import ar.com.builder.example.components.Engine;
import ar.com.builder.example.components.GPSNavigator;
import ar.com.builder.example.components.Transmission;
import ar.com.builder.example.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}