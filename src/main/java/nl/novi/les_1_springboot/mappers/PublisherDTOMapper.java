package nl.novi.les_1_springboot.mappers;

import nl.novi.les_1_springboot.dto.PublisherRequestDTO;
import nl.novi.les_1_springboot.dto.PublisherResponseDTO;
import nl.novi.les_1_springboot.entities.PublisherEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherDTOMapper implements DTOMapper<PublisherResponseDTO,
        PublisherRequestDTO, PublisherEntity>{

    @Override
    public PublisherResponseDTO mapToDto(PublisherEntity model) {
        return new PublisherResponseDTO(model.getId(), model.getName(),
                model.getAddress(), model.getContactDetails());
    }

    @Override
    public List<PublisherResponseDTO> mapToDto(List<PublisherEntity> models) {
        List<PublisherResponseDTO> dtoList = new ArrayList<>();
        for (PublisherEntity model : models){
            PublisherResponseDTO newResponseDTO = mapToDto(model);
            dtoList.add(newResponseDTO);
        }
        return dtoList;
    }

    @Override
    public PublisherEntity mapToEntity(PublisherRequestDTO publisherModel) {
        PublisherEntity publisherEntity = new PublisherEntity();

        publisherEntity.setName(publisherModel.name());
        publisherEntity.setAddress(publisherModel.address());
        publisherEntity.setContactDetails(publisherModel.contactDetails());

        return publisherEntity;
    }
}
