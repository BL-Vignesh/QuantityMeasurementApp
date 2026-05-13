package com.bridgelabz.qunatitymeasurementapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
    @Test
    public void testEquality_FeetToFeet_SameValue() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_FeetToInches() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_FeetDifferentValues() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_NullComparison() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(length1.equals(null));
    }

    @Test
    public void testEquality_SameReference() {

        Length length =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length.equals(length));
    }
}