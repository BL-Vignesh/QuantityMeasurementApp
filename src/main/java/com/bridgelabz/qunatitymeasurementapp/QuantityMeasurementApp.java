package com.bridgelabz.qunatitymeasurementapp;

public class QuantityMeasurementApp {


    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        if (length1.equals(length2)) {
            System.out.println("The two length measurements are equal.");
            return true;
        }

        System.out.println("The two length measurements are not equal.");
        return false;
    }


    public static boolean demonstrateLengthComparison(
            double value1,
            Length.LengthUnit unit1,
            double value2,
            Length.LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);

        Length length2 = new Length(value2, unit2);

        return demonstrateLengthEquality(length1, length2);
    }

    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);

        return length.convertTo(toUnit);
    }


    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }


    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }


    public static void main(String[] args) {

        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.FEET,
                12.0,
                Length.LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.YARDS,
                36.0,
                Length.LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                100.0,
                Length.LengthUnit.CENTIMETERS,
                39.37,
                Length.LengthUnit.INCHES
        );

        Length convertedLength =
                demonstrateLengthConversion(
                        3.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES
                );

        System.out.println(convertedLength);

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length sum =
                demonstrateLengthAddition(length1, length2);

        System.out.println(sum);
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            Length.LengthUnit targetUnit) {

        return length1.add(length2, targetUnit);
    }
}