package com.bridgelabz.quantitymeasurementapp;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (!this.unit.getClass().equals(targetUnit.getClass())) {
            throw new ClassCastException(
                    "Cannot convert between different measurement types");
        }

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {

        // Prevent cross-type addition
        if (!this.unit.getClass().equals(other.unit.getClass())) {
            throw new ClassCastException(
                    "Cannot add different measurement types");
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double totalBase = thisBase + otherBase;

        double result =
                unit.convertFromBaseUnit(totalBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        // Prevent cross-type addition
        if (!this.unit.getClass().equals(other.unit.getClass())) {
            throw new ClassCastException(
                    "Cannot add different measurement types");
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double totalBase = thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(totalBase);

        return new Quantity<>(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quantity<?> other)) {
            return false;
        }

        if (this.unit.getClass() != other.unit.getClass()) {
            return false;
        }

        double thisBase =
                this.unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        return Double.compare(thisBase, otherBase) == 0;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        return Objects.hash(baseValue, unit.getClass());
    }

    @Override
    public String toString() {

        return "Quantity(" +
                value +
                ", " +
                unit +
                ")";
    }
}