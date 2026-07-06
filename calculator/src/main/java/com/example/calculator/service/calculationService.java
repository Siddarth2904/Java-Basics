package com.example.calculator.service;

import com.example.calculator.model.calculationResult;
import org.springframework.stereotype.Service;

@Service
public class calculationService {

    public calculationResult calculate(double num1, double num2, String operation) {
        calculationResult result = new calculationResult();
        result.setNum1(num1);
        result.setNum2(num2);
        result.setOperation(operation);

        try {
            double calculatedResult = switch (operation) {
                case "add" -> num1 + num2;
                case "subtract" -> num1 - num2;
                case "multiply" -> num1 * num2;
                case "divide" -> {
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    yield num1 / num2;
                }
                default -> throw new IllegalArgumentException("Invalid operation");
            };
            result.setResult(calculatedResult);
        } catch (ArithmeticException | IllegalArgumentException e) {
            result.setError(e.getMessage());
        }

        return result;
    }
}