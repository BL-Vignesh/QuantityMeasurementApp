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

    @Test
    public void addFeetAndInchesWithTargetUnitFeet() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.FEET
                );

        Length expected =
                new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addFeetAndInchesWithTargetUnitYards() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.YARDS
                );

        Length expected =
                new Length(0.67, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addInchesWithTargetUnitCentimeters() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.CENTIMETERS
                );

        Length expected =
                new Length(5.08, Length.LengthUnit.CENTIMETERS);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addYardsAndFeetWithTargetUnitYards() {

        Length length1 =
                new Length(2.0, Length.LengthUnit.YARDS);

        Length length2 =
                new Length(3.0, Length.LengthUnit.FEET);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.YARDS
                );

        Length expected =
                new Length(3.0, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addYardsAndFeetWithTargetUnitFeet() {

        Length length1 =
                new Length(2.0, Length.LengthUnit.YARDS);

        Length length2 =
                new Length(3.0, Length.LengthUnit.FEET);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.FEET
                );

        Length expected =
                new Length(9.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void additionCommutativityWithTargetUnit() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length result1 =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.YARDS
                );

        Length result2 =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length2,
                        length1,
                        Length.LengthUnit.YARDS
                );

        assertTrue(result1.equals(result2));
    }

    @Test
    public void additionWithZeroAndTargetUnit() {

        Length length1 =
                new Length(5.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(0.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.YARDS
                );

        Length expected =
                new Length(1.67, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }

    @Test
    public void additionWithNegativeValuesAndTargetUnit() {

        Length length1 =
                new Length(5.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(-2.0, Length.LengthUnit.FEET);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.INCHES
                );

        Length expected =
                new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    public void additionWithNullTargetUnit() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        null
                )
        );
    }

    @Test
    public void additionLargeToSmallScale() {

        Length length1 =
                new Length(1000.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(500.0, Length.LengthUnit.FEET);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.INCHES
                );

        Length expected =
                new Length(18000.0, Length.LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    public void additionSmallToLargeScale() {

        Length length1 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                QuantityMeasurementApp.demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.YARDS
                );

        Length expected =
                new Length(0.67, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }
}