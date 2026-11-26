package nl.novi.les_1_springboot.controllers;


import jakarta.validation.Valid;
import nl.novi.les_1_springboot.dto.PublisherRequestDTO;
import nl.novi.les_1_springboot.dto.PublisherResponseDTO;
import nl.novi.les_1_springboot.mappers.PublisherDTOMapper;
import nl.novi.les_1_springboot.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;
    private final PublisherDTOMapper publisherDTOMapper;

    public PublisherController(PublisherService publisherService, PublisherDTOMapper publisherDTOMapper) {
        this.publisherService = publisherService;
        this.publisherDTOMapper = publisherDTOMapper;
    }

    @GetMapping("")
    public List<PublisherResponseDTO> getAllPublishers(){
        return publisherService.findAllPublishers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDTO> getPublisherById(@PathVariable Long id){
        PublisherResponseDTO publisher = publisherService.findPublisherById(id);
        if (publisher == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @PostMapping
    public ResponseEntity<PublisherResponseDTO> createPublisher(@RequestBody @Valid PublisherRequestDTO pe){
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.createPublisher(pe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDTO> updatePublisher(@PathVariable Long id, @RequestBody @Valid PublisherRequestDTO pe){
        PublisherResponseDTO publisher = publisherService.updatePublisher(id, pe);
        if (publisher == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Long id){
        publisherService.deletePublisher(id);
    }

}
