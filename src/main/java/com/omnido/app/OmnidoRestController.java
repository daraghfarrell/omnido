package com.omnido.app;

import com.omnido.model.Anytodo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OmnidoRestController {

    @RequestMapping("/anytodo")
    public Anytodo anytodo() {
        return new Anytodo(1l, UUID.randomUUID(), "anytodo", "this is any to do");
    }
}
