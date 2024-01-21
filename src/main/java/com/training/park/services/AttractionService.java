package com.training.park.services;

import com.training.park.models.Attraction;
import com.training.park.repositories.AttractionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionService implements BaseService<Attraction>{

    @Autowired
    private AttractionRepository attractionRepository;

    @Override
    @Transactional
    public List<Attraction> findAll() throws Exception {
        try {
            List<Attraction> entities = attractionRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Attraction findById(Long id) throws Exception {
        try {
            Optional<Attraction> entityOptional = attractionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Attraction save(Attraction entity) throws Exception {
        try {
            entity = attractionRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Attraction update(Long id, Attraction entity) throws Exception {
        try {
            Optional<Attraction> optionalEntity = attractionRepository.findById(id);
            Attraction attraction = optionalEntity.get();
            attraction = attractionRepository.save(attraction);
            return attraction;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        try{
            if (attractionRepository.existsById(id)){
                attractionRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
