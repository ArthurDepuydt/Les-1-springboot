package nl.novi.les_1_springboot.dto;

public record PublisherResponseDTO(
        Long id,
        String name,
        String address,
        String contactDetails) {
}
