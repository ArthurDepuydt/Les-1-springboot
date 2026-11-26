package nl.novi.les_1_springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record GenreRequestDTO(
        @NotEmpty(message = "Name can not be empty.")
        @Size(min=2, max=100, message = "Name must be between 2 and 100 characters long.")
        String name,

        @Size(max=255, message = "Description must nog be longer than 255 characters.")
        String description
)
{ }
