package com.aleksandrmakarov.springbootteamspirit.controller;

import com.aleksandrmakarov.springbootteamspirit.model.request.TaskRequest;
import com.aleksandrmakarov.springbootteamspirit.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(value = "projectId") Long projectId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getByProjectId(projectId));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody TaskRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateById(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        taskService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
