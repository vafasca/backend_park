package com.training.park.services;

import com.training.park.models.Employee;
import com.training.park.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements BaseService<Employee>{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> findAll() throws Exception {
        try {
            List<Employee> entities = employeeRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee findById(Long id) throws Exception {
        try {
            Optional<Employee> entityOptional = employeeRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee save(Employee entity) throws Exception {
        try {
            entity = employeeRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee update(Long id, Employee entity) throws Exception {
        try {
            Optional<Employee> entityOptional = employeeRepository.findById(id);
            Employee employee = entityOptional.get();
            employee = employeeRepository.save(employee);
            return employee;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        try {
            if (employeeRepository.existsById(id)){
                employeeRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
