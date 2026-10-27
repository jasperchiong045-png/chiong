package com.example.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {

    @GetMapping("/calculate")
    public Map<String, Object> calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operator) {
        
        Map<String, Object> response = new HashMap<>();
        
        switch (operator) {
            case "add":
                response.put("result", num1 + num2);
                break;
            case "subtract":
                response.put("result", num1 - num2);
                break;
            case "multiply":
                response.put("result", num1 * num2);
                break;
            case "divide":
                if (num2 == 0) {
                    response.put("error", "Division by zero is not allowed.");
                } else {
                    response.put("result", num1 / num2);
                }
                break;
            default:
                response.put("error", "Invalid operator provided.");
        }
        
        return response;
    }
}
