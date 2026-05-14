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
        this.value = value;
        this.unit = unit;
    }


    private double convertToBaseUnit() {
        double result = value * unit.getConversionFactor();
        return Math.round(result * 100.0) / 100.0;
    }


    private boolean compare(Length thatLength) {
        return this.convertToBaseUnit() ==
                thatLength.convertToBaseUnit();
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Length thatLength = (Length) o;

        return compare(thatLength);
    }


    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = convertToBaseUnit();

        double convertedValue =
                baseValue / targetUnit.getConversionFactor();

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Length(convertedValue, targetUnit);
    }


    public Length add(Length thatLength) {

        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        double thisLengthInInches =
                this.convertToBaseUnit();

        double thatLengthInInches =
                thatLength.convertToBaseUnit();

        double totalInInches =
                thisLengthInInches + thatLengthInInches;

        double convertedResult =
                convertFromBaseToTargetUnit(totalInInches, this.unit);

        return new Length(convertedResult, this.unit);
    }


    private double convertFromBaseToTargetUnit(
            double lengthInInches,
            LengthUnit targetUnit) {

        double convertedValue =
                lengthInInches / targetUnit.getConversionFactor();

        return Math.round(convertedValue * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }


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
                new Length(39.37, LengthUnit.INCHES);

        System.out.println(length5.equals(length6));


        Length convertedFeet =
                length1.convertTo(LengthUnit.INCHES);

        System.out.println(convertedFeet);


        Length sum =
                length1.add(length2);

        System.out.println(sum);
    }
}