package com.bridgelabz.quantitymeasurementapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void lengthFeetEqualsInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void lengthYardsEqualsFeet() {

        Quantity<LengthUnit> yards =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertTrue(yards.equals(feet));
    }

    @Test
    public void weightKilogramEqualsGrams() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kilogram.equals(grams));
    }

    @Test
    public void weightPoundEqualsGrams() {

        Quantity<WeightUnit> pound =
                new Quantity<>(1.0, WeightUnit.POUND);

        Quantity<WeightUnit> grams =
                new Quantity<>(453.592, WeightUnit.GRAM);

        assertTrue(pound.equals(grams));
    }


    @Test
    public void convertLengthFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue());
    }

    @Test
    public void addLengthFeetAndInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches, LengthUnit.FEET);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void addWeightKilogramsAndGrams() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kilogram.add(grams, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue());
    }


    @Test
    public void testGenericTypeSafetyWithWeight() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertEquals(WeightUnit.KILOGRAM,
                kilogram.getUnit());
    }

    @Test
    public void convertWeightKilogramsToGrams() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kilogram.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    public void addWeightKilogramsAndPounds() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> pound =
                new Quantity<>(2.20462, WeightUnit.POUND);

        Quantity<WeightUnit> result =
                kilogram.add(pound, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void convertLengthYardsToInches() {

        Quantity<LengthUnit> yards =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> result =
                yards.convertTo(LengthUnit.INCHES);

        assertEquals(36.0, result.getValue());
    }

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(feet.equals(kilogram));
    }

    @Test
    public void preventCrossTypeAdditionLengthVsWeight() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(ClassCastException.class, () -> {

            @SuppressWarnings("unchecked")
            Quantity raw =
                    new Quantity<>(1.0,
                            WeightUnit.KILOGRAM);

            feet.add(raw);
        });
    }

    @Test
    public void preventCrossTypeConversionLengthToWeight() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(ClassCastException.class, () -> {

            @SuppressWarnings("unchecked")
            WeightUnit invalidTarget =
                    WeightUnit.KILOGRAM;

            feet.convertTo((LengthUnit) (Object) invalidTarget);
        });
    }

    @Test
    public void addLengthYardsAndFeet() {

        Quantity<LengthUnit> yards =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                yards.add(feet, LengthUnit.YARDS);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void addWeightTonnesAndKilograms() {

        Quantity<WeightUnit> tonne =
                new Quantity<>(1.0, WeightUnit.TONNE);

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1000.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                tonne.add(kilogram, WeightUnit.TONNE);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void backwardCompatibilityLengthFeetEqualsInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void backwardCompatibilityWeightKilogramEqualsGrams() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kilogram.equals(grams));
    }

    @Test
    public void backwardCompatibilityConvertLengthFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue());
    }

    @Test
    public void backwardCompatibilityConvertWeightKilogramsToGrams() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kilogram.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    public void backwardCompatibilityAddLengthInSameUnit() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet1.add(feet2);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void backwardCompatibilityAddWeightInSameUnit() {

        Quantity<WeightUnit> kilogram1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> kilogram2 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kilogram1.add(kilogram2);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void backwardCompatibilityLengthYardsEqualsFeet() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    @Test
    public void backwardCompatibilityWeightPoundEqualsGrams() {

        Quantity<WeightUnit> pound =
                new Quantity<>(1.0, WeightUnit.POUND);

        Quantity<WeightUnit> grams =
                new Quantity<>(453.592, WeightUnit.GRAM);

        assertTrue(pound.equals(grams));
    }

    @Test
    public void backwardCompatibilityChainedAdditionsLength() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches)
                        .add(inches);

        assertEquals(3.0, result.getValue());
    }
}