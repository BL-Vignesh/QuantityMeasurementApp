package com.bridgelabz.quantitymeasurementapp;

import com.bridgelabz.quantitymeasurementapp.Quantity;
import com.bridgelabz.quantitymeasurementapp.TemperatureUnit;

public class QuantityMeasurementAppTest {

    public static void main(String[] args) {

        System.out.println("=== Temperature Demonstration ===");

        Quantity<TemperatureUnit> temp1 =
                new Quantity<>(0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> temp2 =
                new Quantity<>(32.0,
                        TemperatureUnit.FAHRENHEIT);

        System.out.println(
                "0°C equals 32°F : "
                        + temp1.equals(temp2));

        Quantity<TemperatureUnit> boiling =
                new Quantity<>(100.0,
                        TemperatureUnit.CELSIUS);

        double converted =
                boiling.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        System.out.println(
                "100°C = "
                        + converted
                        + "°F");

        try {

            boiling.add(
                    new Quantity<>(
                            50.0,
                            TemperatureUnit.CELSIUS));

        } catch (UnsupportedOperationException e) {

            System.out.println(e.getMessage());
        }
    }
}