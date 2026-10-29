package com.cem.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record CreateEventRequest(
        @NotBlank @Size(max = 120) String title,
        @NotBlank @Size(max = 80) String category,
        @NotBlank @Size(max = 160) String venue,
        @NotNull @Future LocalDateTime startsAt,
        @Min(1) @Max(100000) int capacity,
        @NotBlank @Size(max = 1000) String description,
        @Size(max=120) String organizerName,
        @Email @Size(max=180) String organizerEmail
) {}
