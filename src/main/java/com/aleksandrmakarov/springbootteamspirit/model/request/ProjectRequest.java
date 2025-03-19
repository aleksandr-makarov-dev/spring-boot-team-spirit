package com.aleksandrmakarov.springbootteamspirit.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProjectRequest(
        @NotBlank(message = "Name is required and cannot be empty.")
        @Size(min = 5, max = 100, message = "Name must be between {min} and {max} characters long.")
        String name
) {
}
