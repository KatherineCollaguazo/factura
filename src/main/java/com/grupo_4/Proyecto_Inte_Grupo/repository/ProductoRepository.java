package com.grupo_4.Proyecto_Inte_Grupo.repository;

import java.util.List;

import com.grupo_4.Proyecto_Inte_Grupo.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    
    @Autowired
    List<Producto> findAll();
}
