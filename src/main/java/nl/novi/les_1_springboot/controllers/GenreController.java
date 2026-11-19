package nl.novi.les_1_springboot.controllers;

import nl.novi.les_1_springboot.entities.GenreEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import nl.novi.les_1_springboot.services.GenreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("")
    public List<GenreEntity> getAllGenres() {
        return genreService.findAllGenres();
    }

    @GetMapping("/{id}")
    public Optional<GenreEntity> getGenreById(@PathVariable Long id) {
        Optional<GenreEntity> g = genreService.findGenreById(id);
        return g;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreEntity createGenre(@RequestBody GenreEntity g){
        GenreEntity createdGenre = genreService.createGenre(g);
        return createdGenre;
    }

    @PutMapping("/{id}")
    public GenreEntity updateGenre(@PathVariable Long id, @RequestBody GenreEntity g){
        GenreEntity updatedGenre = genreService.updateGenre(id, g);
        return updatedGenre;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deteleGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
    }

}
