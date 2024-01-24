package com.training.park.services;

import com.training.park.models.Client;
import com.training.park.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements BaseService<Client>{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public List<Client> findAll() throws Exception {
        try{
            List<Client> entities = clientRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Client findById(Long id) throws Exception {
        try{
            Optional<Client> entityOptional = clientRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Client save(Client entity) throws Exception {
        try{
            entity = clientRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Client update(Long id, Client entity) throws Exception {
        try{
            Optional<Client> entityOptional = clientRepository.findById(id);
            Client client = entityOptional.get();
            entity.setId(id);
            client = clientRepository.save(entity);
            return client;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        try{
            if (clientRepository.existsById(id)){
                clientRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
