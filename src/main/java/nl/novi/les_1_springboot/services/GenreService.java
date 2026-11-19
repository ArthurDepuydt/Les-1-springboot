package nl.novi.les_1_springboot.services;

import nl.novi.les_1_springboot.entities.GenreEntity;
import nl.novi.les_1_springboot.entities.PublisherEntity;
import nl.novi.les_1_springboot.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    public final GenreRepository genreRepository;

    public Optional<GenreEntity> getGenreById(Long id) {
        if (genreRepository.findById(id).isPresent()){
            return genreRepository.findById(id);
        }
        else{
            return null;
        }
    };

    public List<GenreEntity> findAllGenres(){
        return genreRepository.findAll();
    };

    public Optional<GenreEntity> findGenreById(Long id){
        if (getGenreById(id).isPresent()) {
            return genreRepository.findById(id);
        }
        else {
            return null;
        }
    };

    public GenreEntity createGenre(GenreEntity input){
        return genreRepository.save(input);
    };

    public GenreEntity updateGenre(Long id, GenreEntity input){
        Optional<GenreEntity> gen = genreRepository.findById(id);
        if (gen.isEmpty()){
            return null;
        }
        GenreEntity ge = gen.get();

        ge.setName(input.getName());
        ge.setDescription(input.getDescription());

        return genreRepository.save(ge);
    };

    public void deleteGenre(Long id){
        if (getGenreById(id).isPresent()){
            genreRepository.deleteById(id);
        }
    };

    GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
}
