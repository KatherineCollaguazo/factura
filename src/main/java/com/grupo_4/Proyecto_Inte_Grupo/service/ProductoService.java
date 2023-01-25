package com.grupo_4.Proyecto_Inte_Grupo.service;

import java.util.List;

import com.grupo_4.Proyecto_Inte_Grupo.model.Producto;
import com.grupo_4.Proyecto_Inte_Grupo.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> listadoProductos(){
        return productoRepository.findAll();
    }

    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProducto(Producto producto){
        productoRepository.delete(producto);
    }

    public Producto findById(long id) {
        return productoRepository.findById(id).get();
    }

    public void delete(long id) {
        productoRepository.deleteById(id);
    }
}
