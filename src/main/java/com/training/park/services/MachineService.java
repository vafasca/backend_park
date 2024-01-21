package com.training.park.services;

import com.training.park.models.Machine;
import com.training.park.repositories.MachineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService implements BaseService<Machine>{

    @Autowired
    private MachineRepository machineRepository;

    @Override
    @Transactional
    public List<Machine> findAll() throws Exception {
        try {
            List<Machine> entities = machineRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Machine findById(Long id) throws Exception {
        try {
            Optional<Machine> entityOptional = machineRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Machine save(Machine entity) throws Exception {
        try {
            entity = machineRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Machine update(Long id, Machine entity) throws Exception {
        try {
            Optional<Machine> entityOptional = machineRepository.findById(id);
            Machine machine = entityOptional.get();
            machine = machineRepository.save(machine);
            return machine;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        return null;
    }
}
