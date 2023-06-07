package com.tele2.tele2codingtest.controller;

import com.tele2.tele2codingtest.model.Calculation;
import com.tele2.tele2codingtest.repo.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @Autowired
    private CalculationRepository calculationRepository;

    @PostMapping("/add")
    public Calculation add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        Calculation calculation = new Calculation();
        calculation.setOperation(num1 + " + " + num2);
        calculation.setResult(num1 + num2);
        return calculationRepository.save(calculation);
    }

    @PostMapping("/subtract")
    public Calculation subtract(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        Calculation calculation = new Calculation();
        calculation.setOperation(num1 + " - " + num2);
        calculation.setResult(num1 - num2);
        return calculationRepository.save(calculation);
    }

    @PostMapping("/multiply")
    public Calculation multiply(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        Calculation calculation = new Calculation();
        calculation.setOperation(num1 + " * " + num2);
        calculation.setResult(num1 * num2);
        return calculationRepository.save(calculation);
    }

    @PostMapping("/divide")
    public Calculation divide(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Dela inte med 0");
        }
        Calculation calculation = new Calculation();
        calculation.setOperation(num1 + " / " + num2);
        calculation.setResult(num1 / num2);
        return calculationRepository.save(calculation);
    }

    @GetMapping("/calculations")
    public Iterable<Calculation> getCalculations() {
        return calculationRepository.findAll();
    }
}