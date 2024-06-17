package org.alfa.listando.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDTO(@NotBlank String title,
                      @NotNull String author
) {
}