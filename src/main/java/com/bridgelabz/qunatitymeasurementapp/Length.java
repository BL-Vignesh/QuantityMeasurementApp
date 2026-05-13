package com.bridgelabz.qunatitymeasurementapp;

public class Length {

    private double value;

    private LengthUnit unit;

    // Enum for units and conversion factors
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

    // Constructor
    public Length(double value, LengthUnit unit) {

        this.value = value;

        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {

        return value * unit.getConversionFactor();
    }

    // Compare method
    public boolean compare(Length thatLength) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()
        ) == 0;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length length = (Length) obj;

        return compare(length);
    }

    // Standalone testing
    public static void main(String[] args) {

        Length length1 =
                new Length(1.0, LengthUnit.FEET);

        Length length2 =
                new Length(12.0, LengthUnit.INCHES);

        System.out.println(length1.equals(length2));

        Length length3 =
                new Length(1.0, LengthUnit.YARDS);

        Length length4 =
                new Length(36.0, LengthUnit.INCHES);

        System.out.println(length3.equals(length4));

        Length length5 =
                new Length(100.0, LengthUnit.CENTIMETERS);

        Length length6 =
                new Length(39.3701, LengthUnit.INCHES);

        System.out.println(length5.equals(length6));
    }
}