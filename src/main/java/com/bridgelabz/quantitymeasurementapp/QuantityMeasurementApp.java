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

        double convertedValue =
                quantity.convertTo(targetUnit);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    // ================= ADDITION =================

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

    // ================= SUBTRACTION =================

    public static
    <U extends IMeasurable>
    Quantity<U> demonstrateSubtraction(
            Quantity<U> quantity1,
            Quantity<U> quantity2) {

        return quantity1.subtract(
                quantity2);
    }

    public static
    <U extends IMeasurable>
    Quantity<U> demonstrateSubtraction(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit) {

        return quantity1.subtract(
                quantity2,
                targetUnit);
    }

    // ================= DIVISION =================

    public static
    <U extends IMeasurable>
    double demonstrateDivision(
            Quantity<U> quantity1,
            Quantity<U> quantity2) {

        return quantity1.divide(
                quantity2);
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        System.out.println("===== WEIGHT TESTS =====");

        Quantity<WeightUnit> weightInGrams =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> weightInKilograms =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        boolean areEqual =
                demonstrateEquality(
                        weightInGrams,
                        weightInKilograms);

        System.out.println(
                "Are weights equal? "
                        + areEqual);

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



        // ================= VOLUME =================

        System.out.println("\n===== VOLUME TESTS =====");

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON);

        System.out.println(
                "1 L == 1000 mL : "
                        + litre.equals(millilitre));

        System.out.println(
                "1 Gallon in Litres : "
                        + gallon.convertTo(
                        VolumeUnit.LITRE));

        System.out.println(
                "1 L + 1000 mL : "
                        + litre.add(millilitre));

        System.out.println(
                "1 Gallon + 1 L in Gallons : "
                        + gallon.add(
                        litre,
                        VolumeUnit.GALLON));



        // ================= LENGTH =================

        System.out.println(
                "\n===== SUBTRACT and DIVISION =====");

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0,
                        LengthUnit.INCHES);

        System.out.println(
                demonstrateSubtraction(
                        feet,
                        inches));

        System.out.println(
                demonstrateSubtraction(
                        feet,
                        inches,
                        LengthUnit.INCHES));

        System.out.println(
                demonstrateDivision(
                        feet,
                        inches));



        // ================= UC14 TEMPERATURE =================

        System.out.println(
                "\n===== TEMPERATURE TESTS =====");

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0,
                        TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(273.15,
                        TemperatureUnit.KELVIN);

        // Equality
        System.out.println(
                "0°C == 32°F : "
                        + celsius.equals(fahrenheit));

        System.out.println(
                "0°C == 273.15K : "
                        + celsius.equals(kelvin));



        // Conversion
        Quantity<TemperatureUnit> boilingPoint =
                new Quantity<>(100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> convertedFahrenheit =
                demonstrateConversion(
                        boilingPoint,
                        TemperatureUnit.FAHRENHEIT);

        System.out.println(
                "100°C in Fahrenheit : "
                        + convertedFahrenheit.getValue()
                        + " "
                        + convertedFahrenheit.getUnit());



        // Unsupported Arithmetic
        try {

            Quantity<TemperatureUnit> result =
                    demonstrateAddition(
                            celsius,
                            new Quantity<>(
                                    50.0,
                                    TemperatureUnit.CELSIUS));

            System.out.println(result);

        } catch (UnsupportedOperationException e) {

            System.out.println(
                    "Temperature Addition Unsupported : "
                            + e.getMessage());
        }



        try {

            Quantity<TemperatureUnit> result =
                    demonstrateSubtraction(
                            celsius,
                            new Quantity<>(
                                    10.0,
                                    TemperatureUnit.CELSIUS));

            System.out.println(result);

        } catch (UnsupportedOperationException e) {

            System.out.println(
                    "Temperature Subtraction Unsupported : "
                            + e.getMessage());
        }



        try {

            double result =
                    demonstrateDivision(
                            celsius,
                            new Quantity<>(
                                    2.0,
                                    TemperatureUnit.CELSIUS));

            System.out.println(result);

        } catch (UnsupportedOperationException e) {

            System.out.println(
                    "Temperature Division Unsupported : "
                            + e.getMessage());
        }
    }
}