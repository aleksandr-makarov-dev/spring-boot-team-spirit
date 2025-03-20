package com.aleksandrmakarov.springbootteamspirit.controller;

import com.aleksandrmakarov.springbootteamspirit.model.request.ProjectRequest;
import com.aleksandrmakarov.springbootteamspirit.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProjectRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody ProjectRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(projectService.updateById(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        projectService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
