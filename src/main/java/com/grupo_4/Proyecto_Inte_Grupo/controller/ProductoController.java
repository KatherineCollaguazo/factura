package com.grupo_4.Proyecto_Inte_Grupo.controller;

import com.grupo_4.Proyecto_Inte_Grupo.model.Producto;
import com.grupo_4.Proyecto_Inte_Grupo.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @GetMapping("/lista")
    public String listado(Model model){
        model.addAttribute("listadoProductos", productoService.listadoProductos());
        return "producto/lista";
    }

    @GetMapping("/formulario")
    public String formulario(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "producto/formulario";
    }

    @PostMapping("/procesaFormulario")
    public String procesaFormulario(Producto producto, Model model){
        productoService.saveProducto(producto);
        model.addAttribute("listadoproductos",productoService.listadoProductos());
        return  "redirect:lista";
    }

    @GetMapping("/formulario/{id}")
    public String formulario(@PathVariable long id, Model model){
        Producto producto = productoService.findById(id);
        model.addAttribute("producto", producto);
        return "producto/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id)
    {
        productoService.delete(id);
        return "redirect:lista";
    }
}
