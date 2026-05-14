package com.bridgelabz.quantitymeasurementapp;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }

        if (Double.isNaN(value) ||
                Double.isInfinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid length value"
            );
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Length)) {
            return false;
        }

        Length thatLength = (Length) o;

        return compare(thatLength);
    }

    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        double baseValue =
                convertToBaseUnit();

        double convertedValue =
                convertFromBaseToTargetUnit(
                        baseValue,
                        targetUnit
                );

        return new Length(
                convertedValue,
                targetUnit
        );
    }

    public Length add(Length thatLength) {

        if (thatLength == null) {
            throw new IllegalArgumentException(
                    "Length cannot be null"
            );
        }

        return addAndConvert(
                thatLength,
                this.unit
        );
    }

    public Length add(
            Length length,
            LengthUnit targetUnit) {

        if (length == null || targetUnit == null) {

            throw new IllegalArgumentException(
                    "Length and target unit cannot be null"
            );
        }

        return addAndConvert(length, targetUnit);
    }

    private boolean compare(Length thatLength) {

        double thisValue =
                this.convertToBaseUnit();

        double thatValue =
                thatLength.convertToBaseUnit();

        return Math.abs(thisValue - thatValue)
                < 0.01;
    }

    private Length addAndConvert(
            Length length,
            LengthUnit targetUnit) {

        double thisLengthInInches =
                this.convertToBaseUnit();

        double thatLengthInInches =
                length.convertToBaseUnit();

        double totalInInches =
                thisLengthInInches
                        + thatLengthInInches;

        double convertedValue =
                convertFromBaseToTargetUnit(
                        totalInInches,
                        targetUnit
                );

        return new Length(
                convertedValue,
                targetUnit
        );
    }

    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    private double convertFromBaseToTargetUnit(
            double lengthInInches,
            LengthUnit targetUnit) {

        return targetUnit.convertFromBaseUnit(
                lengthInInches
        );
    }

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit
        );
    }

    public static void main(String[] args) {

        Length feet =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        System.out.println(
                feet.equals(inches)
        );

        Length converted =
                feet.convertTo(
                        LengthUnit.INCHES
                );

        System.out.println(converted);

        Length added =
                feet.add(
                        inches,
                        LengthUnit.FEET
                );

        System.out.println(added);
    }
}