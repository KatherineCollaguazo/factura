package com.grupo_4.Proyecto_Inte_Grupo.controller;

import com.grupo_4.Proyecto_Inte_Grupo.model.Cliente;
import com.grupo_4.Proyecto_Inte_Grupo.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping("/lista")
    public String listado(Model model){
        model.addAttribute("listadoClientes", clienteService.listadoClientes());
        return "cliente/lista";
    }

    @GetMapping("/formulario")
    public String formulario(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "cliente/formulario";
    }

    @PostMapping("/procesaFormulario")
    public String procesaFormulario(Cliente cliente, Model model){
        clienteService.saveCliente(cliente);
        model.addAttribute("listadoclientes", clienteService.listadoClientes());
        return "redirect:lista";
    }

    @GetMapping("/formulario/{id}")
    public String formulario(@PathVariable long id, Model model){
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id)
    {
        clienteService.delete(id);
        return "redirect:lista";
    }
}
