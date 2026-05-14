package com.bridgelabz.quantitymeasurementapp;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(false),
    FAHRENHEIT(true),
    KELVIN(false);

    private final boolean isFahrenheit;

    final Function<Double, Double> conversionValue;

    SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(boolean isFahrenheit) {

        this.isFahrenheit = isFahrenheit;

        if (isFahrenheit) {

            conversionValue =
                    fahrenheit ->
                            (fahrenheit - 32) * 5 / 9;

        } else {

            conversionValue =
                    value -> value;
        }
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public double convertToBaseUnit(double value) {

        switch (this) {

            case CELSIUS:
                return value;

            case FAHRENHEIT:
                return (value - 32) * 5 / 9;

            case KELVIN:
                return value - 273.15;

            default:
                throw new IllegalArgumentException("Invalid temperature unit");
        }
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {

        switch (this) {

            case CELSIUS:
                return baseValue;

            case FAHRENHEIT:
                return (baseValue * 9 / 5) + 32;

            case KELVIN:
                return baseValue + 273.15;

            default:
                throw new IllegalArgumentException("Invalid temperature unit");
        }
    }

    public double convertTo(double value,
                            TemperatureUnit targetUnit) {

        double celsiusValue = convertToBaseUnit(value);

        return targetUnit.convertFromBaseUnit(celsiusValue);
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {

        if (!supportsArithmetic()) {

            throw new UnsupportedOperationException(
                    this.name()
                            + " does not support "
                            + operation
                            + " operations.");
        }
    }
}