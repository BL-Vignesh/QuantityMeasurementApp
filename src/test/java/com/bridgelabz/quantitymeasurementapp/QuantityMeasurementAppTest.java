package com.bridgelabz.quantitymeasurementapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // =========================================================
    // SUBTRACTION TESTS
    // =========================================================

    @Test
    public void testSubtraction_SameUnit_FeetMinusFeet() {

        Quantity<LengthUnit> first =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                first.subtract(second);

        assertEquals(
                5.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_SameUnit_LitreMinusLitre() {

        Quantity<VolumeUnit> first =
                new Quantity<>(10.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> second =
                new Quantity<>(3.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                first.subtract(second);

        assertEquals(
                7.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_CrossUnit_FeetMinusInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(inches);

        assertEquals(
                9.5,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_CrossUnit_InchesMinusFeet() {

        Quantity<LengthUnit> inches =
                new Quantity<>(120.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                inches.subtract(feet);

        assertEquals(
                60.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_ExplicitTargetUnit_Feet() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(
                        inches,
                        LengthUnit.FEET);

        assertEquals(
                9.5,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_ExplicitTargetUnit_Inches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(
                        inches,
                        LengthUnit.INCHES);

        assertEquals(
                114.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_ExplicitTargetUnit_Millilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(5.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> litre2 =
                new Quantity<>(2.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.subtract(
                        litre2,
                        VolumeUnit.MILLILITRE);

        assertEquals(
                3000.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_ResultingInNegative() {

        Quantity<LengthUnit> first =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                first.subtract(second);

        assertEquals(
                -5.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_ResultingInZero() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(120.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(inches);

        assertEquals(
                0.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_WithZeroOperand() {

        Quantity<LengthUnit> feet =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> zero =
                new Quantity<>(0.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(zero);

        assertEquals(
                5.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_WithNegativeValues() {

        Quantity<LengthUnit> first =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(-2.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                first.subtract(second);

        assertEquals(
                7.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testSubtraction_NonCommutative() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result1 =
                a.subtract(b);

        Quantity<LengthUnit> result2 =
                b.subtract(a);

        assertNotEquals(
                result1.getValue(),
                result2.getValue());
    }

    @Test
    public void testSubtraction_NullOperand() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.subtract(null));
    }

    @Test
    public void testSubtraction_NullTargetUnit() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> other =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.subtract(other,
                        null));
    }

    @Test
    public void testSubtraction_ChainedOperations() {

        Quantity<LengthUnit> result =
                new Quantity<>(10.0,
                        LengthUnit.FEET)
                        .subtract(
                                new Quantity<>(2.0,
                                        LengthUnit.FEET))
                        .subtract(
                                new Quantity<>(1.0,
                                        LengthUnit.FEET));

        assertEquals(
                7.0,
                result.getValue(),
                0.01);
    }

    // =========================================================
    // DIVISION TESTS
    // =========================================================

    @Test
    public void testDivision_SameUnit_FeetDividedByFeet() {

        Quantity<LengthUnit> first =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(2.0,
                        LengthUnit.FEET);

        assertEquals(
                5.0,
                first.divide(second),
                0.01);
    }

    @Test
    public void testDivision_SameUnit_LitreDividedByLitre() {

        Quantity<VolumeUnit> first =
                new Quantity<>(10.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> second =
                new Quantity<>(5.0,
                        VolumeUnit.LITRE);

        assertEquals(
                2.0,
                first.divide(second),
                0.01);
    }

    @Test
    public void testDivision_CrossUnit_FeetDividedByInches() {

        Quantity<LengthUnit> inches =
                new Quantity<>(24.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(2.0,
                        LengthUnit.FEET);

        assertEquals(
                1.0,
                inches.divide(feet),
                0.01);
    }

    @Test
    public void testDivision_CrossUnit_KilogramDividedByGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(2.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(2000.0,
                        WeightUnit.GRAM);

        assertEquals(
                1.0,
                kg.divide(gram),
                0.01);
    }

    @Test
    public void testDivision_RatioGreaterThanOne() {

        Quantity<LengthUnit> first =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(2.0,
                        LengthUnit.FEET);

        assertEquals(
                5.0,
                first.divide(second),
                0.01);
    }

    @Test
    public void testDivision_RatioLessThanOne() {

        Quantity<LengthUnit> first =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        assertEquals(
                0.5,
                first.divide(second),
                0.01);
    }

    @Test
    public void testDivision_RatioEqualToOne() {

        Quantity<LengthUnit> first =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        assertEquals(
                1.0,
                first.divide(second),
                0.01);
    }

    @Test
    public void testDivision_NonCommutative() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        double result1 =
                a.divide(b);

        double result2 =
                b.divide(a);

        assertNotEquals(
                result1,
                result2);
    }

    @Test
    public void testDivision_ByZero() {

        Quantity<LengthUnit> first =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> zero =
                new Quantity<>(0.0,
                        LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> first.divide(zero));
    }

    @Test
    public void testDivision_WithLargeRatio() {

        Quantity<WeightUnit> big =
                new Quantity<>(1000000.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> small =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertEquals(
                1000000.0,
                big.divide(small),
                0.01);
    }

    @Test
    public void testDivision_WithSmallRatio() {

        Quantity<WeightUnit> small =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> big =
                new Quantity<>(1000000.0,
                        WeightUnit.KILOGRAM);

        assertEquals(
                0.000001,
                small.divide(big),
                0.000001);
    }

    @Test
    public void testDivision_NullOperand() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.divide(null));
    }

    @Test
    public void testSubtraction_Immutability() {

        Quantity<LengthUnit> first =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        first.subtract(second);

        assertEquals(
                10.0,
                first.getValue(),
                0.01);

        assertEquals(
                5.0,
                second.getValue(),
                0.01);
    }

    @Test
    public void testDivision_Immutability() {

        Quantity<LengthUnit> first =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        first.divide(second);

        assertEquals(
                10.0,
                first.getValue(),
                0.01);

        assertEquals(
                5.0,
                second.getValue(),
                0.01);
    }

    @Test
    public void testSubtractionAddition_Inverse() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                a.add(b)
                        .subtract(b);

        assertEquals(
                a.getValue(),
                result.getValue(),
                0.01);
    }
}