package nl.novi.les_1_springboot.controllers;


import nl.novi.les_1_springboot.entities.PublisherEntity;
import nl.novi.les_1_springboot.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("")
    public List<PublisherEntity> getAllPublishers(){
        return publisherService.findAllPublishers();
    }

    @GetMapping("/{id}")
    public Optional<PublisherEntity> getPublisherById(@PathVariable Long id){
        Optional<PublisherEntity> p = publisherService.findPublisherById(id);
        return p;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherEntity createPublisher(@RequestBody PublisherEntity pe){
        return publisherService.createPublisher(pe);
    }

    @PutMapping("/{id}")
    public PublisherEntity updatePublisher(@PathVariable Long id, @RequestBody PublisherEntity pe){
        return publisherService.updatePublisher(id, pe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Long id){
        publisherService.deletePublisher(id);
    }

}
