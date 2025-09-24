package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.entity.Historico;
import com.example.CrudAlunos.service.HistoricoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/historico")
@RequiredArgsConstructor
public class HistoricoController {
    public final HistoricoService service;

    @GetMapping
    public ResponseEntity<List <Historico>> getAllHistorico () {
        List <Historico> historico = service.listAllHistorico();
        return ResponseEntity.ok(historico);

    }
}
