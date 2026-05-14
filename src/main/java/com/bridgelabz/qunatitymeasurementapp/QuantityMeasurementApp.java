package com.bridgelabz.qunatitymeasurementapp;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        boolean result =
                length1.equals(length2);

        if (result) {

            System.out.println(
                    "The two length measurements are equal."
            );

        } else {

            System.out.println(
                    "The two length measurements are not equal."
            );
        }

        return result;
    }

    public static boolean demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

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
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        Length length =
                new Length(value, fromUnit);

        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            LengthUnit targetUnit) {

        return length1.add(
                length2,
                targetUnit
        );
    }

    public static boolean demonstrateWeightEquality(
            Weight weight1,
            Weight weight2) {

        return weight1.equals(weight2);
    }

    public static boolean demonstrateWeightComparison(
            double value1,
            WeightUnit unit1,
            double value2,
            WeightUnit unit2) {

        Weight weight1 = new Weight(value1, unit1);

        Weight weight2 = new Weight(value2, unit2);

        return weight1.equals(weight2);
    }

    public static Weight demonstrateWeightConversion(
            double value,
            WeightUnit fromUnit,
            WeightUnit toUnit) {

        Weight weight = new Weight(value, fromUnit);

        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightConversion(
            Weight weight,
            WeightUnit toUnit) {

        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2) {

        return weight1.add(weight2);
    }

    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2,
            WeightUnit targetUnit) {

        return weight1.add(weight2, targetUnit);
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

        demonstrateLengthEquality(
                feet,
                inches
        );

        Length converted =
                demonstrateLengthConversion(
                        feet,
                        LengthUnit.INCHES
                );

        System.out.println(converted);

        Length added =
                demonstrateLengthAddition(
                        feet,
                        inches,
                        LengthUnit.FEET
                );

        System.out.println(added);
    }
}