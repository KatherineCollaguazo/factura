package com.grupo_4.Proyecto_Inte_Grupo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo_4.Proyecto_Inte_Grupo.model.Proveedor;
import com.grupo_4.Proyecto_Inte_Grupo.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public Proveedor saveProveedor(Proveedor proveedor)
    {
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> listaProveedores()
    {
        return proveedorRepository.findAll();
    }

    public Proveedor findById(long id)
    {
        return proveedorRepository.findById(id).get();
    }
    
    public void delete(long id)
    {
        proveedorRepository.deleteById(id);
    }
    
}
