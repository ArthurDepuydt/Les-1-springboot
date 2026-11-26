package nl.novi.les_1_springboot.services;

import nl.novi.les_1_springboot.dto.PublisherRequestDTO;
import nl.novi.les_1_springboot.dto.PublisherResponseDTO;
import nl.novi.les_1_springboot.entities.GenreEntity;
import nl.novi.les_1_springboot.entities.PublisherEntity;
import nl.novi.les_1_springboot.exceptions.RecordNotFoundException;
import nl.novi.les_1_springboot.mappers.GenreDTOMapper;
import nl.novi.les_1_springboot.mappers.PublisherDTOMapper;
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
    public final PublisherDTOMapper publisherDTOMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherDTOMapper publisherDTOMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherDTOMapper = publisherDTOMapper;
    }

    public Optional<PublisherEntity> getPublisherById(Long id) {
        return publisherRepository.findById(id);
    };

    public List<PublisherResponseDTO> findAllPublishers(){
        return publisherDTOMapper.mapToDto(publisherRepository.findAll());
    }

    public PublisherResponseDTO findPublisherById(Long id) {
        if (getPublisherById(id).isPresent()){
            return publisherDTOMapper.mapToDto(publisherRepository.findById(id).get());
        }
        else{
            throw new RecordNotFoundException("Publisher with id " + id + " not found");
        }
    }

    public PublisherResponseDTO createPublisher(PublisherRequestDTO input){
        return publisherDTOMapper.mapToDto(publisherRepository.save(publisherDTOMapper.mapToEntity(input)));
    }


    public PublisherResponseDTO updatePublisher(Long id, PublisherRequestDTO input){
        Optional<PublisherEntity> pub = publisherRepository.findById(id);
        if (pub.isEmpty()){
            throw new RecordNotFoundException("Publisher with id " + id + " not found");
        }
        PublisherEntity pe = pub.get();

        pe.setName(input.name());
        pe.setAddress(input.address());
        pe.setContactDetails(input.contactDetails());

        return publisherDTOMapper.mapToDto(publisherRepository.save(pe));
    }

    public void deletePublisher(Long id){
        if (getPublisherById(id).isPresent()){
            publisherRepository.deleteById(id);
        }
    }

}
