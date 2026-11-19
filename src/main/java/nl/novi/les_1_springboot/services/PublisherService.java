package nl.novi.les_1_springboot.services;

import nl.novi.les_1_springboot.entities.GenreEntity;
import nl.novi.les_1_springboot.entities.PublisherEntity;
import nl.novi.les_1_springboot.repositories.GenreRepository;
import nl.novi.les_1_springboot.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow;

@Service
public class PublisherService {

    public final PublisherRepository publisherRepository;

    public Optional<PublisherEntity> getPublisherById(Long id) {
        if (publisherRepository.findById(id).isPresent()){
            return publisherRepository.findById(id);
        }
        else{
            return null;
        }
    };

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherEntity> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Optional<PublisherEntity> findPublisherById(Long id) {
        if (getPublisherById(id).isPresent()){
            return publisherRepository.findById(id);
        }
        else{
            return null;
        }
    }

    public PublisherEntity createPublisher(PublisherEntity input){
        return publisherRepository.save(input);
    }


    public PublisherEntity updatePublisher(Long id, PublisherEntity input){
        Optional<PublisherEntity> pub = publisherRepository.findById(id);
        if (pub.isEmpty()){
            return null;
        }
        PublisherEntity pe = pub.get();

        pe.setName(input.getName());
        pe.setAddress(input.getAddress());
        pe.setContactDetails(input.getContactDetails());

        return publisherRepository.save(pe);
    }

    public void deletePublisher(Long id){
        if (getPublisherById(id).isPresent()){
            publisherRepository.deleteById(id);
        }
    }

}
