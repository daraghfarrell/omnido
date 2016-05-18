package com.omnido.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmnidoWebController {


    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false) String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/graph")
    public String graph () {
        return "graph";
    }
}
