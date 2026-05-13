package com.bridgelabz.qunatitymeasurementapp;

public class QuantityMeasurementApp {


    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }


    public static boolean demonstrateLengthComparison(
            double value1,
            Length.LengthUnit unit1,
            double value2,
            Length.LengthUnit unit2) {

        Length length1 =
                new Length(value1, unit1);

        Length length2 =
                new Length(value2, unit2);

        return demonstrateLengthEquality(
                length1,
                length2
        );
    }


    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length =
                new Length(value, fromUnit);

        return length.convertTo(toUnit);
    }


    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

        Length result1 =
                demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES
                );

        System.out.println(result1);

        Length result2 =
                demonstrateLengthConversion(
                        3.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.FEET
                );

        System.out.println(result2);

        Length result3 =
                demonstrateLengthConversion(
                        36.0,
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.YARDS
                );

        System.out.println(result3);

        Length result4 =
                demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.CENTIMETERS,
                        Length.LengthUnit.INCHES
                );

        System.out.println(result4);
    }
}