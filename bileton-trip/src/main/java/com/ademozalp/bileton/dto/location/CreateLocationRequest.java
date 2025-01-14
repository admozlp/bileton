package com.ademozalp.bileton.dto.location;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateLocationRequest(@NotNull(message = "id cannot be null") Integer id,
                                    @NotEmpty(message = "name cannot be empty") String name,
                                    Integer parentId) {
}
