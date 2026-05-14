package com.bridgelabz.qunatitymeasurementapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                length1,
                                length2
                        )
        );
    }

    @Test
    public void testInchesEquality() {

        Length length1 =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                length1,
                                length2
                        )
        );
    }

    @Test
    public void testFeetInchesComparison() {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                length1,
                                length2
                        )
        );
    }

    @Test
    public void testFeetInequality() {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        2.0,
                        LengthUnit.FEET
                );

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                length1,
                                length2
                        )
        );
    }

    @Test
    public void testInchesInequality() {

        Length length1 =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        24.0,
                        LengthUnit.INCHES
                );

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                length1,
                                length2
                        )
        );
    }

    @Test
    public void testCrossUnitInequality() {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        13.0,
                        LengthUnit.INCHES
                );

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                length1,
                                length2
                        )
        );
    }

    @Test
    public void testMultipleFeetComparison() {

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthComparison(
                                3.0,
                                LengthUnit.FEET,
                                36.0,
                                LengthUnit.INCHES
                        )
        );
    }

    @Test
    public void yardEquals36Inches() {

        Length yard =
                new Length(
                        1.0,
                        LengthUnit.YARDS
                );

        Length inches =
                new Length(
                        36.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                yard,
                                inches
                        )
        );
    }

    @Test
    public void centimeterEquals39Point3701Inches() {

        Length centimeter =
                new Length(
                        100.0,
                        LengthUnit.CENTIMETERS
                );

        Length inches =
                new Length(
                        39.3701,
                        LengthUnit.INCHES
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                centimeter,
                                inches
                        )
        );
    }

    @Test
    public void threeFeetEqualsOneYard() {

        Length feet =
                new Length(
                        3.0,
                        LengthUnit.FEET
                );

        Length yard =
                new Length(
                        1.0,
                        LengthUnit.YARDS
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                feet,
                                yard
                        )
        );
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {

        Length centimeter =
                new Length(
                        30.48,
                        LengthUnit.CENTIMETERS
                );

        Length foot =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                centimeter,
                                foot
                        )
        );
    }

    @Test
    public void yardNotEqualToInches() {

        Length yard =
                new Length(
                        1.0,
                        LengthUnit.YARDS
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        assertFalse(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                yard,
                                inches
                        )
        );
    }

    @Test
    public void referenceEqualitySameObject() {

        Length length =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(length.equals(length));
    }

    @Test
    public void equalsReturnsFalseForNull() {

        Length length =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        assertFalse(length.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length b =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length c =
                new Length(
                        0.3333,
                        LengthUnit.YARDS
                );

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {

        Length a =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length b =
                new Length(
                        5.0,
                        LengthUnit.FEET
                );

        assertFalse(a.equals(b));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthComparison(
                                1.0,
                                LengthUnit.YARDS,
                                3.0,
                                LengthUnit.FEET
                        )
        );
    }

    @Test
    public void convertFeetToInches() {

        Length converted =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                1.0,
                                LengthUnit.FEET,
                                LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                converted,
                                expected
                        )
        );
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        Length yard =
                new Length(
                        1.0,
                        LengthUnit.YARDS
                );

        Length converted =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                yard,
                                LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                converted,
                                expected
                        )
        );
    }

    @Test
    public void addFeetAndInches() {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length sumLength =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                length1,
                                length2
                        );

        Length expected =
                new Length(
                        2.0,
                        LengthUnit.FEET
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                sumLength,
                                expected
                        )
        );
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        24.0,
                        LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                length1,
                                length2,
                                LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                result,
                                expected
                        )
        );
    }

    @Test
    public void kilogramEquals1000Grams() {

        Weight kilogram =
                new Weight(1, WeightUnit.KILOGRAM);

        Weight gram =
                new Weight(1000, WeightUnit.GRAM);

        Assertions.assertEquals(kilogram, gram);
    }

    @Test
    public void poundEquals453Point592Grams() {

        Weight pound =
                new Weight(1, WeightUnit.POUND);

        Weight grams =
                new Weight(453.592, WeightUnit.GRAM);

        Assertions.assertEquals(pound, grams);
    }

    @Test
    public void tonneEquals1000000Grams() {

        Weight tonne =
                new Weight(1, WeightUnit.TONNE);

        Weight grams =
                new Weight(1000000, WeightUnit.GRAM);

        Assertions.assertEquals(tonne, grams);
    }

    @Test
    public void kilogramNotEqualToPound() {

        Weight kilogram =
                new Weight(1, WeightUnit.KILOGRAM);

        Weight pound =
                new Weight(1, WeightUnit.POUND);

        Assertions.assertNotEquals(kilogram, pound);
    }

    @Test
    public void additionOfWeightsEqualsExpected() {

        Weight kilogram =
                new Weight(1, WeightUnit.KILOGRAM);

        Weight gram =
                new Weight(1000, WeightUnit.GRAM);

        Weight expected =
                new Weight(2, WeightUnit.KILOGRAM);

        Assertions.assertEquals(
                expected,
                kilogram.add(gram));
    }
}