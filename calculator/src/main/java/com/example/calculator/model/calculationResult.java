package com.example.calculator.model;

public class calculationResult {
    private double num1;
    private double num2;
    private String operation;
    private double result;
    private String error;

    public calculationResult() {}

    public calculationResult(double num1, double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }

    // Getters and Setters
    public double getNum1() { return num1; }
    public void setNum1(double num1) { this.num1 = num1; }

    public double getNum2() { return num2; }
    public void setNum2(double num2) { this.num2 = num2; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public boolean hasError() { return error != null && !error.isEmpty(); }

    public String getOperationSymbol() {
        return switch (operation) {
            case "add" -> "+";
            case "subtract" -> "-";
            case "multiply" -> "×";
            case "divide" -> "÷";
            default -> operation;
        };
    }
}