package com.bridgelabz.quantitymeasurementapp;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable>
    boolean demonstrateEquality(
            Quantity<U> quantity1,
            Quantity<U> quantity2) {

        return quantity1.equals(quantity2);
    }

    public static <U extends IMeasurable>
    Quantity<U> demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        return quantity.convertTo(targetUnit);
    }

    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2) {

        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit) {

        return quantity1.add(quantity2, targetUnit);
    }

    public static void main(String[] args) {

        Quantity<WeightUnit> weightInGrams =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> weightInKilograms =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        boolean areEqual =
                demonstrateEquality(
                        weightInGrams,
                        weightInKilograms);

        System.out.println(
                "Are weights equal? " + areEqual);



        Quantity<WeightUnit> convertedWeight =
                demonstrateConversion(
                        weightInGrams,
                        WeightUnit.KILOGRAM);

        System.out.println(
                "Converted Weight: "
                        + convertedWeight.getValue()
                        + " "
                        + convertedWeight.getUnit());



        Quantity<WeightUnit> weightInPounds =
                new Quantity<>(2.20462,
                        WeightUnit.POUND);

        Quantity<WeightUnit> sumWeight =
                demonstrateAddition(
                        weightInKilograms,
                        weightInPounds);

        System.out.println(
                "Sum Weight: "
                        + sumWeight.getValue()
                        + " "
                        + sumWeight.getUnit());



        Quantity<WeightUnit> sumWeightInGrams =
                demonstrateAddition(
                        weightInKilograms,
                        weightInPounds,
                        WeightUnit.GRAM);

        System.out.println(
                "Sum Weight in Grams: "
                        + sumWeightInGrams.getValue()
                        + " "
                        + sumWeightInGrams.getUnit());

        System.out.println("===== VOLUME TESTS =====");

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        System.out.println(
                "1 L == 1000 mL : "
                        + litre.equals(millilitre));

        System.out.println(
                "1 Gallon in Litres : "
                        + gallon.convertTo(VolumeUnit.LITRE));

        System.out.println(
                "1 L + 1000 mL : "
                        + litre.add(millilitre));

        System.out.println(
                "1 Gallon + 1 L in Gallons : "
                        + gallon.add(litre, VolumeUnit.GALLON));
    }


}