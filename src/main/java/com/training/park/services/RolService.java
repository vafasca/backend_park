package com.training.park.services;

import com.training.park.models.Client;
import com.training.park.models.Rol;
import com.training.park.repositories.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements BaseService<Rol>{

    @Autowired
    private RolRepository rolRepository;

    @Override
    @Transactional
    public List<Rol> findAll() throws Exception {
        try{
            List<Rol> entities = rolRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rol findById(Long id) throws Exception {
        try{
            Optional<Rol> entityOptional = rolRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rol save(Rol entity) throws Exception {
        try{
            entity = rolRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rol update(Long id, Rol entity) throws Exception {
        try{
            Optional<Rol> entityOptional = rolRepository.findById(id);
            Rol rol = entityOptional.get();
            rol = rolRepository.save(rol);
            return rol;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        try{
            if (rolRepository.existsById(id)){
                rolRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
