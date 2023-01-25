package com.grupo_4.Proyecto_Inte_Grupo.repository;

import java.util.List;

import com.grupo_4.Proyecto_Inte_Grupo.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
    @Autowired
    List<Cliente> findAll();
    
}
