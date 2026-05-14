package com.bridgelabz.quantitymeasurementapp;

public interface IMeasurable {

    // Default lambda
    SupportsArithmetic supportsArithmetic = () -> true;

    String getUnitName();

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) {
        // Default: all operations supported
    }
}