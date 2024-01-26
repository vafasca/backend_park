package com.training.park.services;

import com.training.park.models.Ticket;
import com.training.park.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements BaseService<Ticket> {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    @Transactional
    public List<Ticket> findAll() throws Exception {
        try {
            List<Ticket> entities = ticketRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ticket findById(Long id) throws Exception {
        try {
            Optional<Ticket> entityOptional = ticketRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ticket save(Ticket entity) throws Exception {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String formattedDate = dateFormat.format(new Date());
            entity.setDate(dateFormat.parse(formattedDate));
            entity = ticketRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ticket update(Long id, Ticket entity) throws Exception {
        try {
            Optional<Ticket> entityOptional = ticketRepository.findById(id);
            Ticket ticket = entityOptional.get();
            ticket = ticketRepository.save(entity);
            return ticket;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        try {
            if (ticketRepository.existsById(id)){
                ticketRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Ticket> obtenerTicketsPorCliente(Long clientId) {
        return ticketRepository.findTicketsByClientId(clientId);
    }
}
