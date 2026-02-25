package com.example.calculator_test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CalculatorRunner implements CommandLineRunner {

    private final CalculatorService calculatorService;

    public CalculatorRunner(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Calculator Runner started. Press Ctrl+C to stop.");

        while (true) { 
            try {
                int a = (int) (Math.random() * 1000); 
                int b = (int) (Math.random() * 1000); 
                System.out.println("Adding " + a + " + " + b + " = " + calculatorService.add(a, b));
                System.out.println("Subtracting " + a + " - " + b + " = " + calculatorService.subt(a, b));
                System.out.println("Multiplying " + a + " * " + b + " = " + calculatorService.mul(a, b));
                if (b != 0) {
                    System.out.println("Dividing " + a + " / " + b + " = " + calculatorService.divide(a, b));
                }
                Thread.sleep(2000);
            } 
            
            catch (Exception e) {
                System.err.println("Error occurred: " + e.getMessage());
            }
        }
    }
}