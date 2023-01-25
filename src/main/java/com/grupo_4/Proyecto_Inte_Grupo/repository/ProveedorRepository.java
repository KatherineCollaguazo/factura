package com.grupo_4.Proyecto_Inte_Grupo.repository;

import java.util.List;
import com.grupo_4.Proyecto_Inte_Grupo.model.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface ProveedorRepository extends CrudRepository <Proveedor, Long>{
    
    public List<Proveedor> findAll();
}
