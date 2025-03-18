package com.aleksandrmakarov.springbootteamspirit.model.response;

import lombok.*;

import java.time.LocalDateTime;

public record ProjectResponse(Long id, String name, LocalDateTime createdAt) {
}
