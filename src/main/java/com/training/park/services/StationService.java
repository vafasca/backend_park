package com.training.park.services;

import com.training.park.models.Station;
import com.training.park.repositories.StationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService implements BaseService<Station>{

    @Autowired
    private StationRepository stationRepository;

    @Override
    @Transactional
    public List<Station> findAll() throws Exception {
        try{
            List<Station> entities = stationRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Station findById(Long id) throws Exception {
        try{
            Optional<Station> entityOptional = stationRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Station save(Station entity) throws Exception {
        try{
            entity = stationRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Station update(Long id, Station entity) throws Exception {
        try{
            Optional<Station> entityOptional = stationRepository.findById(id);
            Station station = entityOptional.get();
            station = stationRepository.save(station);
            return station;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        try{
            if (stationRepository.existsById(id)){
                stationRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
