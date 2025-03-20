package com.aleksandrmakarov.springbootteamspirit.model.response;

import com.aleksandrmakarov.springbootteamspirit.entity.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime dueDate,
        LocalDateTime completedAt
) {
}
