package com.bridgelabz.qunatitymeasurementapp;


public class Length {

    private double value;

    private LengthUnit unit;

    public enum LengthUnit {

        FEET(12.0),

        INCHES(1.0),

        YARDS(36.0),

        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Value must be finite"
            );
        }

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }

        this.value = value;

        this.unit = unit;
    }

    private double convertToBaseUnit() {

        double result =
                value * unit.getConversionFactor();

        return Math.round(result * 100.0) / 100.0;
    }

    private boolean compare(Length thatLength) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Length length = (Length) o;

        return compare(length);
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
                baseValue /
                        targetUnit.getConversionFactor();

        convertedValue =
                Math.round(convertedValue * 100.0)
                        / 100.0;

        return new Length(
                convertedValue,
                targetUnit
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
                new Length(1.0,
                        LengthUnit.FEET);

        Length inches =
                feet.convertTo(
                        LengthUnit.INCHES);

        System.out.println(inches);

        Length yards =
                new Length(2.0,
                        LengthUnit.YARDS);

        System.out.println(
                yards.convertTo(
                        LengthUnit.INCHES
                )
        );
    }
}