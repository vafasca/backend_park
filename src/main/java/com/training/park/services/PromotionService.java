package com.training.park.services;

import com.training.park.models.Client;
import com.training.park.models.Promotion;
import com.training.park.repositories.PromotionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService implements BaseService<Promotion>{

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    @Transactional
    public List<Promotion> findAll() throws Exception {
        try{
            List<Promotion> entities = promotionRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Promotion findById(Long id) throws Exception {
        try{
            Optional<Promotion> entityOptional = promotionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Promotion save(Promotion entity) throws Exception {
        try{
            entity = promotionRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Promotion update(Long id, Promotion entity) throws Exception {
        try{
            Optional<Promotion> entityOptional = promotionRepository.findById(id);
            Promotion promotion = entityOptional.get();
            promotion = promotionRepository.save(promotion);
            return promotion;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        try{
            if (promotionRepository.existsById(id)){
                promotionRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
