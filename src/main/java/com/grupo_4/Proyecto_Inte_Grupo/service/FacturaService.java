package com.grupo_4.Proyecto_Inte_Grupo.service;

import java.util.List;

import com.grupo_4.Proyecto_Inte_Grupo.model.Factura;
import com.grupo_4.Proyecto_Inte_Grupo.repository.FacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
    
    @Autowired
    FacturaRepository facturaRepository;

    public List<Factura> listadoFacturas()
    {
        return facturaRepository.findAll();        
    }

    public Factura obtenerPorId(long id)
    {
        return facturaRepository.findById(id).get();
    }

    public Factura guardarFactura(Factura factura)
    {
        return facturaRepository.save(factura);
    }
}
