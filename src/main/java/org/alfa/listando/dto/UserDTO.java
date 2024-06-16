package org.alfa.listando.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotBlank String name,
                      @NotNull String email,
                      @NotNull String password) {
}
