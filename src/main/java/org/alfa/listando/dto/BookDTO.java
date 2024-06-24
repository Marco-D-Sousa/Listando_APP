package org.alfa.listando.dto;

import jakarta.validation.constraints.NotBlank;

public record BookDTO(@NotBlank String title,
                      @NotBlank String author) {
}
