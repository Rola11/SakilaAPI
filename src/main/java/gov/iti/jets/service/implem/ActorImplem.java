package gov.iti.jets.service.implem;

import gov.iti.jets.dao.imple.ActorDao;
import gov.iti.jets.entity.Actor;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.interfaces.ActorServic;
import gov.iti.jets.service.mapper.ActorMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ActorImplem implements ActorServic {


    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rsa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    ActorDao actorDao = new ActorDao(entityManager);
    ActorMapper actorMapper = ActorMapper.INSTANCE;
    @Override
    public List<ActorDto> getAll() {
       List<Actor> listOfActor = actorDao.getAll();
       List<ActorDto> listOfActorDto = new ArrayList<>();
       for (Actor actor : listOfActor){
           listOfActorDto.add(actorMapper.toDto(actor));
       }
       return listOfActorDto;
    }

    @Override
    public ActorDto getById(Integer id) {
        return  actorMapper.toDto(actorDao.getById(id));
    }

    @Override
    public void insert(ActorDto actorDto) {
        actorDto.setLastUpdate(Instant.now());
        actorDao.insert(actorMapper.toEntity(actorDto));
    }

    @Override
    public void update(ActorDto actorDto) {
        actorDto.setLastUpdate(Instant.now());
        actorDao.update(actorMapper.toEntity(actorDto));
    }

    @Override
    public void delete(ActorDto actorDto) {
        actorDao.delete(actorDao.getById(actorDto.getId()));
    }

}
