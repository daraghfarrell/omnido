package com.omnido.app;

import com.omnido.model.Anytodo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OmnidoRestController {

    @RequestMapping("/anytodo")
    public Anytodo[] anytodo() {
        return new Anytodo[]{
                new Anytodo(10L, UUID.randomUUID(), "anytodo", "this is any to do", 10),
                new Anytodo(100L, UUID.randomUUID(), "anytodo", "this is any to do", 100),
                new Anytodo(1000L, UUID.randomUUID(), "anytodo", "this is any to do", 1000)
        };
    }
}
