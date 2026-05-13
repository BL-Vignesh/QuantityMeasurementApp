package com.bridgelabz.qunatitymeasurementapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class QuantityMeasurementApp {

    // Generic method to demonstrate equality check
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    // Demonstrate Feet equality
    public static void demonstrateFeetEquality() {

        Length feet1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length feet2 =
                new Length(1.0, Length.LengthUnit.FEET);

        System.out.println(
                "Feet Equality: "
                        + demonstrateLengthEquality(feet1, feet2)
        );
    }

    // Demonstrate Inches equality
    public static void demonstrateInchesEquality() {

        Length inch1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length inch2 =
                new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println(
                "Inches Equality: "
                        + demonstrateLengthEquality(inch1, inch2)
        );
    }

    // Demonstrate Feet and Inches comparison
    public static void demonstrateFeetInchesComparison() {

        Length feet =
                new Length(1.0, Length.LengthUnit.FEET);

        Length inches =
                new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println(
                "Feet and Inches Comparison: "
                        + demonstrateLengthEquality(feet, inches)
        );
    }

    public static void main(String[] args) {

        demonstrateFeetEquality();

        demonstrateInchesEquality();

        demonstrateFeetInchesComparison();
    }
}