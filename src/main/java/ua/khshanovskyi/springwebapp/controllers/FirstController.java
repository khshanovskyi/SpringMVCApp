package ua.khshanovskyi.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
//@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
//        System.out.println(name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "first_operand", required = false, defaultValue = "0") int firstOperand,
                             @RequestParam(value = "second_operand", required = false,defaultValue = "0") int secondOperand,
                             @RequestParam(value = "operator", required = false,defaultValue = "0") String operator,
                             Model model) {
        if (firstOperand != 0 && secondOperand != 0) {
            switch (operator) {
                case "+":
                    model.addAttribute("result",firstOperand + secondOperand);
                    break;
                case "-":
                    model.addAttribute("result",firstOperand - secondOperand);
                    break;
                case ":":
                    model.addAttribute("result",firstOperand / secondOperand);
                    break;
                case "*":
                    model.addAttribute("result",firstOperand * secondOperand);
                    break;
                default:
                    model.addAttribute("result",0);
            }
        }else {
            model.addAttribute("result",0);
        }

        return "first/calculator";
    }
}
