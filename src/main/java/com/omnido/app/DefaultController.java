package com.omnido.app;

import com.omnido.model.Anytodo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DefaultController {
    
    @RequestMapping("/")
    public String index() {
        return "Welcome :-)";
    }

    @RequestMapping("/anytodo")
    public Anytodo anytodo() {
        return new Anytodo(1, "anytodo");
    }
}
