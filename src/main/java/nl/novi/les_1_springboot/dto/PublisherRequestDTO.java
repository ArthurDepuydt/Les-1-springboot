package nl.novi.les_1_springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PublisherRequestDTO(
        @NotEmpty(message = "Name can not be empty.")
        @Size(max=50, message = "Name must not be longer than 50 characters.")
        String name,

        String address,
        String contactDetails
) {

}
