package com.ademozalp.bileton.dto.location;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateLocationRequest {
    @NotNull(message = "id cannot be null")
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    private Integer parentId;
}
