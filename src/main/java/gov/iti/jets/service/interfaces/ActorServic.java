package gov.iti.jets.service.interfaces;

import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.FilmDto;

import java.util.List;

public interface ActorServic {

    List<ActorDto> getAll();
    ActorDto getById(Integer id);

    void insert(ActorDto actorDto);

    void update(ActorDto actorDto);

    void delete(ActorDto actorDto);

    List<FilmDto> getfilmsForActor(ActorDto actorDto);
}
