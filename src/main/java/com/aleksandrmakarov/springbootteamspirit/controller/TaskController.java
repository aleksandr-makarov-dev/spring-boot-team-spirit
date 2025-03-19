package com.aleksandrmakarov.springbootteamspirit.controller;

import com.aleksandrmakarov.springbootteamspirit.model.request.TaskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@Validated
public class TaskController {

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(value = "projectId") Long projectId) {
        throw new RuntimeException("Method not implemented.");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        throw new RuntimeException("Method not implemented.");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskRequest request) {
        throw new RuntimeException("Method not implemented.");
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody TaskRequest request) {
        throw new RuntimeException("Method not implemented.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        throw new RuntimeException("Method not implemented.");
    }
}
