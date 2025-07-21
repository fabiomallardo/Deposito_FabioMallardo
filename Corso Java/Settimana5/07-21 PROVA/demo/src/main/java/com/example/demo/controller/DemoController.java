package com.example.demo.controller;

import com.example.demo.service.MessaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

private final MessaggioService messaggioService;

// Constructor Injection (consigliata)
@Autowired
public DemoController(MessaggioService messaggioService) {
this.messaggioService = messaggioService;
}

@GetMapping("/saluta")
public String saluta() {
messaggioService.saluta();
return "Saluto inviato!";
}
}

