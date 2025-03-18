package com.aleksandrmakarov.springbootteamspirit.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProjectRequest(
        @NotBlank(message = "Name cannot be empty.")
        @Size(min = 5, max = 100, message = "Name length must be between {min} and {max}.")
        String name
) {
}
