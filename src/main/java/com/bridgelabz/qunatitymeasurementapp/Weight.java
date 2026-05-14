package com.bridgelabz.qunatitymeasurementapp;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {

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

    public WeightUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Weight thatWeight = (Weight) o;

        return compare(thatWeight);
    }

    public Weight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double weightInGrams = convertToBaseUnit();

        double convertedValue =
                convertFromBaseToTargetUnit(weightInGrams, targetUnit);

        return new Weight(convertedValue, targetUnit);
    }

    public Weight add(Weight thatWeight) {

        return addAndConvert(thatWeight, this.unit);
    }

    public Weight add(Weight weight, WeightUnit targetUnit) {

        return addAndConvert(weight, targetUnit);
    }

    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    private boolean compare(Weight thatWeight) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatWeight.convertToBaseUnit()) == 0;
    }

    private Weight addAndConvert(Weight weight,
                                 WeightUnit targetUnit) {

        double totalWeightInGrams =
                this.convertToBaseUnit()
                        + weight.convertToBaseUnit();

        double convertedWeight =
                convertFromBaseToTargetUnit(
                        totalWeightInGrams,
                        targetUnit);

        return new Weight(convertedWeight, targetUnit);
    }

    private double convertFromBaseToTargetUnit(
            double weightInGrams,
            WeightUnit targetUnit) {

        return targetUnit.convertFromBaseUnit(weightInGrams);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}