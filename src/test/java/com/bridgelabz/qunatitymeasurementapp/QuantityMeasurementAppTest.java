package com.bridgelabz.qunatitymeasurementapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void testInchesEquality() {

        Length length1 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void testFeetInchesComparison() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void testFeetInequality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void testInchesInequality() {

        Length length1 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(24.0, Length.LengthUnit.INCHES);

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void testCrossUnitInequality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(10.0, Length.LengthUnit.INCHES);

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void testMultipleFeetComparison() {

        Length length1 =
                new Length(3.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void yardEquals36Inches() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.YARDS);

        Length length2 =
                new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void centimeterEquals39Point3701Inches() {

        Length length1 =
                new Length(100.0, Length.LengthUnit.CENTIMETERS);

        Length length2 =
                new Length(39.37, Length.LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void threeFeetEqualsOneYard() {

        Length length1 =
                new Length(3.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {

        Length length1 =
                new Length(30.48, Length.LengthUnit.CENTIMETERS);

        Length length2 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void yardNotEqualToInches() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.YARDS);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(length1, length2)
        );
    }

    @Test
    public void referenceEqualitySameObject() {

        Length length =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length.equals(length));
    }

    @Test
    public void equalsReturnsFalseForNull() {

        Length length =
                new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(length.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length length3 =
                new Length(30.48, Length.LengthUnit.CENTIMETERS);

        assertTrue(length1.equals(length2));
        assertTrue(length2.equals(length3));
        assertTrue(length1.equals(length3));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {

        Length length1 =
                new Length(5.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(6.0, Length.LengthUnit.FEET);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {

        assertTrue(
                QuantityMeasurementApp.demonstrateLengthComparison(
                        1.0,
                        Length.LengthUnit.FEET,
                        12.0,
                        Length.LengthUnit.INCHES
                )
        );
    }

    @Test
    public void convertFeetToInches() {

        Length result =
                QuantityMeasurementApp.demonstrateLengthConversion(
                        3.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES
                );

        Length expected =
                new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        Length length =
                new Length(2.0, Length.LengthUnit.YARDS);

        Length result =
                QuantityMeasurementApp.demonstrateLengthConversion(
                        length,
                        Length.LengthUnit.INCHES
                );

        Length expected =
                new Length(72.0, Length.LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addFeetAndInches() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2
                );

        Length expected =
                new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }
}