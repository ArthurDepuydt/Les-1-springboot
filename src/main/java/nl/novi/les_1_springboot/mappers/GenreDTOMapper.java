package nl.novi.les_1_springboot.mappers;

import nl.novi.les_1_springboot.dto.GenreRequestDTO;
import nl.novi.les_1_springboot.dto.GenreResponseDTO;
import nl.novi.les_1_springboot.entities.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class GenreDTOMapper implements DTOMapper<GenreResponseDTO,
        GenreRequestDTO, GenreEntity>{

    @Override
    public GenreResponseDTO mapToDto(GenreEntity model) {
        return new GenreResponseDTO(model.getId(), model.getName(), model.getDescription());
    }

    @Override
    public List<GenreResponseDTO> mapToDto(List<GenreEntity> models) {
        List<GenreResponseDTO> dtoList = new ArrayList<>();
        for (GenreEntity model : models){
            GenreResponseDTO newResponseDTO = mapToDto(model);
            dtoList.add(newResponseDTO);
        }
        return dtoList;
    }

    @Override
    public GenreEntity mapToEntity(GenreRequestDTO genreModel) {
        GenreEntity genreEntity = new GenreEntity();

        genreEntity.setName(genreModel.name());
        genreEntity.setDescription(genreModel.description());

        return genreEntity;
    }
}
