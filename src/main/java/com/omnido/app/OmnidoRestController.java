package com.omnido.app;

import com.omnido.model.Anytodo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;

@RestController
public class OmnidoRestController {

    @RequestMapping("/anytodo")
    public Anytodo anytodo() {
        return new Anytodo(1, "anytodo");
    }

    @RequestMapping(value = "/static/test.json", method = RequestMethod.GET, produces = "application/json")
    public String test() throws FileNotFoundException {
        return new FileReader("static/test.json").toString();
    }
}
