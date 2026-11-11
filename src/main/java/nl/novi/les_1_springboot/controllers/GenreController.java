package nl.novi.les_1_springboot.controllers;

import nl.novi.les_1_springboot.entities.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import nl.novi.les_1_springboot.services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("")
    public List<Genre> getAllGenres() {
        return genreService.findAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        Genre g = genreService.findGenreById(id);
        return g;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre createGenre(@RequestBody Genre g){
        Genre createdGenre = genreService.createGenre(g);
        return createdGenre;
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre g){
        Genre updatedGenre = genreService.updateGenre(id, g);
        return updatedGenre;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deteleGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
    }

}
