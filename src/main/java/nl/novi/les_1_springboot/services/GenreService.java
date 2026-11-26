package nl.novi.les_1_springboot.services;

import nl.novi.les_1_springboot.dto.GenreRequestDTO;
import nl.novi.les_1_springboot.dto.GenreResponseDTO;
import nl.novi.les_1_springboot.entities.GenreEntity;
import nl.novi.les_1_springboot.entities.PublisherEntity;
import nl.novi.les_1_springboot.exceptions.RecordNotFoundException;
import nl.novi.les_1_springboot.mappers.GenreDTOMapper;
import nl.novi.les_1_springboot.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    public final GenreRepository genreRepository;
    public final GenreDTOMapper genreDTOMapper;

    GenreService(GenreRepository genreRepository, GenreDTOMapper genreDTOMapper) {
        this.genreRepository = genreRepository;
        this.genreDTOMapper = genreDTOMapper;
    }

    public Optional<GenreEntity> getGenreById(Long id) {
        return genreRepository.findById(id);
    };

    public List<GenreResponseDTO> findAllGenres(){
        return genreDTOMapper.mapToDto(genreRepository.findAll());
    };

    public GenreResponseDTO findGenreById(Long id){
        Optional <GenreEntity> genre = getGenreById(id);
        if (genre.isEmpty()){
            throw new RecordNotFoundException("Genre with id " + id + " not found");
        }

        return genreDTOMapper.mapToDto(genre.get());
    };

    public GenreResponseDTO createGenre(GenreRequestDTO genreDTO) {
        GenreEntity genreEntity = genreDTOMapper.mapToEntity(genreDTO);
        genreEntity = genreRepository.save(genreEntity);
        return genreDTOMapper.mapToDto(genreEntity);
    }


    public GenreResponseDTO updateGenre(Long id, GenreRequestDTO input){
        Optional<GenreEntity> gen = getGenreById(id);
        if (gen.isEmpty()){
            throw new RecordNotFoundException("Genre with id " + id + " not found");
        }
        GenreEntity ge = gen.get();

        ge.setName(input.name());
        ge.setDescription(input.description());

        return genreDTOMapper.mapToDto(genreRepository.save(ge));
    };

    public void deleteGenre(Long id){
        if (getGenreById(id).isPresent()){
            genreRepository.deleteById(id);
        }
    };


}
