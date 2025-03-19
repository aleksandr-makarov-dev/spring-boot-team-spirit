package com.aleksandrmakarov.springbootteamspirit.model.request;

import com.aleksandrmakarov.springbootteamspirit.entity.TaskStatus;
import com.aleksandrmakarov.springbootteamspirit.validation.ValueOfEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record TaskRequest(
        @NotBlank(message = "Title is required and cannot be empty.")
        @Size(min = 5, max = 150, message = "Title must be between {min} and {max} characters long.")
        String title,

        @Size(max = 500, message = "Description must be maximum {max} characters long.")
        String description,

        @NotNull(message = "Status is required and cannot be empty.")
        @ValueOfEnum(enumClass = TaskStatus.class, message = "Invalid status. Allowed values: PENDING, ACTIVE, COMPLETED, FAILED, ARCHIVED")
        TaskStatus status,

        @FutureOrPresent(message = "Due date must be in the present or future.")
        LocalDateTime dueDate,

        @NotNull(message = "Project ID is required and cannot be empty.")
        @Positive(message = "Project ID must be a positive number.")
        Long projectId
) {
}
