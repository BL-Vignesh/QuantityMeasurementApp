package com.bridgelabz.quantitymeasurementapp;

import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quantity<?> other)) {
            return false;
        }

        if (unit.getClass() != other.unit.getClass()) {
            return false;
        }

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < 0.0001;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public <T extends IMeasurable> double convertTo(T targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Incompatible unit types");
        }

        double baseValue = unit.convertToBaseUnit(value);

        return targetUnit.convertFromBaseUnit(baseValue);
    }

    // ================= ADD =================

    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double resultBase =
                performArithmetic(other, targetUnit, ArithmeticOperation.ADD);

        double converted =
                targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    // ================= SUBTRACT =================

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double resultBase =
                performArithmetic(other, targetUnit, ArithmeticOperation.SUBTRACT);

        double converted =
                targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    // ================= DIVIDE =================

    public double divide(Quantity<U> other) {

        validateArithmeticOperands(other, null, false);

        return performArithmetic(other, null, ArithmeticOperation.DIVIDE);
    }

    // ================= VALIDATION =================

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired
    ) {

        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        if (unit == null || other.unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible unit types");
        }

        if (!Double.isFinite(value) || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Values must be finite");
        }

        if (targetUnitRequired && targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
    }

    // ================= ENUM =================

    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {

            if (b == 0.0) {
                throw new ArithmeticException("Cannot divide by zero");
            }

            return a / b;
        });

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(DoubleBinaryOperator operation) {
            this.operation = operation;
        }

        public double compute(double a, double b) {
            return operation.applyAsDouble(a, b);
        }
    }

    // ================= CORE HELPER =================

    private double performArithmetic(
            Quantity<U> other,
            U targetUnit,
            ArithmeticOperation operation
    ) {

        // UC14 Runtime Validation
        unit.validateOperationSupport(operation.name());

        other.unit.validateOperationSupport(operation.name());

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        return operation.compute(thisBase, otherBase);
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}