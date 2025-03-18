package com.aleksandrmakarov.springbootteamspirit.controller;

import com.aleksandrmakarov.springbootteamspirit.model.response.ProjectResponse;
import com.aleksandrmakarov.springbootteamspirit.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Validated
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        throw  new RuntimeException("Method not implemented.");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        throw  new RuntimeException("Method not implemented.");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProjectResponse body){
        throw  new RuntimeException("Method not implemented.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        throw  new RuntimeException("Method not implemented.");
    }
}
