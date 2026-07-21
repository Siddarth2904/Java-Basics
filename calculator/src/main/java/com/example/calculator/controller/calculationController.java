package com.example.calculator.controller;

import com.example.calculator.model.calculationResult;
import com.example.calculator.service.calculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calculationController {

    @Autowired
    private calculationService calculatorService;

    @GetMapping("/")
    public String showCalculator(Model model) {
        model.addAttribute("calculation", new calculationResult());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation,
            Model model) {

        calculationResult result = calculatorService.calculate(num1, num2, operation);
        model.addAttribute("calculation", result);
        return "calculator";
    }
}