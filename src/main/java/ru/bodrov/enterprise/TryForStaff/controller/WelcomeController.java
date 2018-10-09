package ru.bodrov.enterprise.TryForStaff.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WelcomeController {

    private String message;

    @GetMapping("/")
    public String welcome(Map<String, Object> model){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("Welcome The Application");
        this.message = (String) exp.getValue();
        model.put("message", this.message);
        return "welcome";
    }
}
