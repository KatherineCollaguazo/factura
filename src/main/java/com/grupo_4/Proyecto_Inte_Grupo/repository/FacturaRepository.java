package com.grupo_4.Proyecto_Inte_Grupo.repository;

import java.util.List;

import com.grupo_4.Proyecto_Inte_Grupo.model.Factura;

import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
    
    List<Factura> findAll();
}
