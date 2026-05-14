package com.bridgelabz.quantitymeasurementapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // =========================
    // LENGTH TESTS
    // =========================

    @Test
    public void lengthFeetEqualsInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    public void lengthYardsEqualsFeet() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    public void convertLengthFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(12.0,
                        LengthUnit.INCHES),
                result);
    }

    @Test
    public void addLengthFeetAndInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches);

        assertEquals(
                new Quantity<>(2.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    public void convertLengthYardsToInches() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> result =
                yard.convertTo(LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(36.0,
                        LengthUnit.INCHES),
                result);
    }

    @Test
    public void addLengthYardsAndFeet() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                yard.add(feet);

        assertEquals(
                new Quantity<>(2.0,
                        LengthUnit.YARDS),
                result);
    }

    // =========================
    // WEIGHT TESTS
    // =========================

    @Test
    public void weightKilogramEqualsGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        assertEquals(kg, grams);
    }

    @Test
    public void weightPoundEqualsGrams() {

        Quantity<WeightUnit> pound =
                new Quantity<>(1.0,
                        WeightUnit.POUND);

        Quantity<WeightUnit> grams =
                new Quantity<>(453.592,
                        WeightUnit.GRAM);

        assertEquals(pound, grams);
    }

    @Test
    public void convertWeightKilogramsToGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(
                new Quantity<>(1000.0,
                        WeightUnit.GRAM),
                result);
    }

    @Test
    public void addWeightKilogramsAndGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kg.add(grams);

        assertEquals(
                new Quantity<>(2.0,
                        WeightUnit.KILOGRAM),
                result);
    }

    @Test
    public void addWeightKilogramsAndPounds() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> pound =
                new Quantity<>(1.0,
                        WeightUnit.POUND);

        Quantity<WeightUnit> result =
                kg.add(pound);

        assertEquals(
                1.45,
                result.getValue(),
                0.0001);

        assertEquals(
                WeightUnit.KILOGRAM,
                result.getUnit());
    }

    @Test
    public void addWeightTonnesAndKilograms() {

        Quantity<WeightUnit> tonne =
                new Quantity<>(1.0,
                        WeightUnit.TONNE);

        Quantity<WeightUnit> kg =
                new Quantity<>(1000.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                tonne.add(kg);

        assertEquals(
                new Quantity<>(2.0,
                        WeightUnit.TONNE),
                result);
    }

    // =========================
    // VOLUME TESTS
    // =========================

    @Test
    public void volumeLiterEqualsMilliliters() {

        Quantity<VolumeUnit> liter =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> milli =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        assertEquals(liter, milli);
    }

    @Test
    public void volumeGallonEqualsLiters() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON);

        Quantity<VolumeUnit> liter =
                new Quantity<>(3.78541,
                        VolumeUnit.LITRE);

        assertEquals(gallon, liter);
    }

    @Test
    public void convertVolumeLitersToMilliliters() {

        Quantity<VolumeUnit> liter =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                liter.convertTo(
                        VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE),
                result);
    }

    @Test
    public void addVolumeLitersAndMilliliters() {

        Quantity<VolumeUnit> liter =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> milli =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                liter.add(milli);

        assertEquals(
                new Quantity<>(2.0,
                        VolumeUnit.LITRE),
                result);
    }

    @Test
    public void volumeLiterEqualsMillilitersSymmetric() {

        Quantity<VolumeUnit> liter =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> milli =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        assertEquals(milli, liter);
    }

    @Test
    public void convertVolumeMillilitersToGallon() {

        Quantity<VolumeUnit> milli =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                milli.convertTo(
                        VolumeUnit.GALLON);

        assertEquals(
                0.264172,
                result.getValue(),
                0.0001);

        assertEquals(
                VolumeUnit.GALLON,
                result.getUnit());
    }

    @Test
    public void addVolumeMillilitersAndLiters() {

        Quantity<VolumeUnit> milli =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> liter =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                milli.add(liter);

        assertEquals(
                new Quantity<>(2000.0,
                        VolumeUnit.MILLILITRE),
                result);
    }

    // =========================
    // GENERIC TYPE SAFETY TESTS
    // =========================

    @Test
    public void testGenericTypeSafetyWithWeight() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertNotNull(kg);
    }

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(feet, kg);
    }

    @Test
    public void preventCrossTypeAdditionLengthVsWeight() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(feet.equals(kg));
    }

    @Test
    public void preventCrossTypeConversionLengthToWeight() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(feet, kg);
    }

    @Test
    public void preventVolumeAndLengthComparison() {

        Quantity<VolumeUnit> liter =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        assertNotEquals(liter, feet);
    }

    @Test
    public void preventVolumeAndWeightComparison() {

        Quantity<VolumeUnit> liter =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(liter, kg);
    }

    // =========================
    // BACKWARD COMPATIBILITY TESTS
    // =========================

    @Test
    public void backwardCompatibilityLengthFeetEqualsInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0,
                        LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    public void backwardCompatibilityWeightKilogramEqualsGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        assertEquals(kg, grams);
    }

    @Test
    public void backwardCompatibilityConvertLengthFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(12.0,
                        LengthUnit.INCHES),
                result);
    }

    @Test
    public void backwardCompatibilityConvertWeightKilogramsToGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(
                new Quantity<>(1000.0,
                        WeightUnit.GRAM),
                result);
    }

    @Test
    public void backwardCompatibilityAddLengthInSameUnit() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet1.add(feet2);

        assertEquals(
                new Quantity<>(2.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    public void backwardCompatibilityAddWeightInSameUnit() {

        Quantity<WeightUnit> kg1 =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> kg2 =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kg1.add(kg2);

        assertEquals(
                new Quantity<>(2.0,
                        WeightUnit.KILOGRAM),
                result);
    }

    @Test
    public void backwardCompatibilityLengthYardsEqualsFeet() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0,
                        LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0,
                        LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    public void backwardCompatibilityWeightPoundEqualsGrams() {

        Quantity<WeightUnit> pound =
                new Quantity<>(1.0,
                        WeightUnit.POUND);

        Quantity<WeightUnit> grams =
                new Quantity<>(453.592,
                        WeightUnit.GRAM);

        assertEquals(pound, grams);
    }

    @Test
    public void backwardCompatibilityChainedAdditionsLength() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0,
                        LengthUnit.YARDS);

        Quantity<LengthUnit> result =
                feet.add(inches).add(yard);

        assertEquals(
                new Quantity<>(5.0,
                        LengthUnit.FEET),
                result);
    }
}