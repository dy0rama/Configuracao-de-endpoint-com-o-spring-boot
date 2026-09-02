package com.exercicio.modulo50.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeguroController {
    @GetMapping("/api/seguro")
    public ResponseEntity<String> endpointSeguro() {
        return ResponseEntity.ok("Você está autenticado e pode acessar este endpoint.");
    }
}
