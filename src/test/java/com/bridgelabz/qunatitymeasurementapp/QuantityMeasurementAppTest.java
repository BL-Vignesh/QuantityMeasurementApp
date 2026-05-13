package com.bridgelabz.qunatitymeasurementapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    @Test
    public void convertFeetToInches() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                3.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void convertInchesToFeet() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                24.0,
                                Length.LengthUnit.INCHES,
                                Length.LengthUnit.FEET
                        );

        Length expected =
                new Length(
                        2.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void convertYardsToInches() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                1.0,
                                Length.LengthUnit.YARDS,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void convertInchesToYards() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                72.0,
                                Length.LengthUnit.INCHES,
                                Length.LengthUnit.YARDS
                        );

        Length expected =
                new Length(
                        2.0,
                        Length.LengthUnit.YARDS
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void convertCentimetersToInches() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                2.54,
                                Length.LengthUnit.CENTIMETERS,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void convertFeetToYards() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                6.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.YARDS
                        );

        Length expected =
                new Length(
                        2.0,
                        Length.LengthUnit.YARDS
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void conversionRoundTripPreservesValue() {

        Length original =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET
                );

        Length inches =
                original.convertTo(
                        Length.LengthUnit.INCHES
                );

        Length convertedBack =
                inches.convertTo(
                        Length.LengthUnit.FEET
                );

        assertTrue(
                original.equals(convertedBack)
        );
    }

    @Test
    public void conversionZeroValue() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                0.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        0.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void conversionNegativeValue() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                -1.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        -12.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void invalidUnitThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        1.0,
                        null
                )
        );
    }

    @Test
    public void nanOrInfiniteThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.NaN,
                        Length.LengthUnit.FEET
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.POSITIVE_INFINITY,
                        Length.LengthUnit.FEET
                )
        );
    }

    @Test
    public void sameUnitConversion() {

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                5.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.FEET
                        );

        Length expected =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(actual.equals(expected));
    }

    @Test
    public void overloadedMethodConversion() {

        Length yards =
                new Length(
                        2.0,
                        Length.LengthUnit.YARDS
                );

        Length actual =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                yards,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        72.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(actual.equals(expected));
    }
}