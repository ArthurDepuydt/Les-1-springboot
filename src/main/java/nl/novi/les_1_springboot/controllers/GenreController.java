package nl.novi.les_1_springboot.controllers;

import jakarta.validation.Valid;
import nl.novi.les_1_springboot.dto.GenreRequestDTO;
import nl.novi.les_1_springboot.dto.GenreResponseDTO;
import nl.novi.les_1_springboot.entities.GenreEntity;
import nl.novi.les_1_springboot.mappers.GenreDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.novi.les_1_springboot.services.GenreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;
    private final GenreDTOMapper genreDTOMapper;

    public GenreController(GenreService genreService, GenreDTOMapper genreDTOMapper) {
        this.genreService = genreService;
        this.genreDTOMapper = genreDTOMapper;
    }

    @GetMapping("")
    public List<GenreResponseDTO> getAllGenres() {
        return genreService.findAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDTO> getGenreById(@PathVariable Long id) {
        GenreResponseDTO genreModel = genreService.findGenreById(id);
        if (genreModel == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genreModel);
    }

    @PostMapping
    public ResponseEntity<GenreResponseDTO> createGenre(@RequestBody @Valid GenreRequestDTO g){
        GenreResponseDTO createdGenre = genreService.createGenre(g);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGenre);
    }

    @PutMapping("/{id}")
    public GenreResponseDTO updateGenre(@PathVariable Long id, @RequestBody @Valid GenreRequestDTO g){
        GenreResponseDTO updatedGenre = genreService.updateGenre(id, g);
        return updatedGenre;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
    }

}
