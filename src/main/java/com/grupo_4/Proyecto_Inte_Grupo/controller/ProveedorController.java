package com.grupo_4.Proyecto_Inte_Grupo.controller;

import com.grupo_4.Proyecto_Inte_Grupo.model.Proveedor;
import com.grupo_4.Proyecto_Inte_Grupo.service.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping({"/","/lista",""})
    public String lista(Model model){
        model.addAttribute("proveedores",proveedorService.listaProveedores());
        return "/proveedor/lista";
    }
    
    @GetMapping("/formulario")
    public String formulario(Model model){
        Proveedor proveedor = new Proveedor();
        model.addAttribute("proveedor", proveedor);
        return "producto/formulario";
    }

    @PostMapping("/procesoFormulario")
    public String procesoFormulario(Proveedor proveedor, Model model){
        proveedorService.saveProveedor(proveedor);
        model.addAttribute("listadoproductos",proveedorService.listaProveedores());
        return "producto/lista";
    }

    @GetMapping("/formulario/{id}")
    public String formulario(@PathVariable long id, Model model){
        Proveedor proveedor = proveedorService.findById(id);
        model.addAttribute("proveedor", proveedor);
        return "producto/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id)
    {
        proveedorService.delete(id);
        return "redirect:lista";
    }

}
