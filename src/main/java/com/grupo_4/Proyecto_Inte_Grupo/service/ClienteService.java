package com.grupo_4.Proyecto_Inte_Grupo.service;

import java.util.List;

import com.grupo_4.Proyecto_Inte_Grupo.model.Cliente;
import com.grupo_4.Proyecto_Inte_Grupo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listadoClientes(){
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }

    public Cliente findById(long id) {
        return clienteRepository.findById(id).get();
    }

    public void delete(long id) {
        clienteRepository.deleteById(id);
    }
}
