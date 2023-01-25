package com.grupo_4.Proyecto_Inte_Grupo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grupo_4.Proyecto_Inte_Grupo.model.Cliente;
import com.grupo_4.Proyecto_Inte_Grupo.model.DetalleFactura;
import com.grupo_4.Proyecto_Inte_Grupo.model.Factura;
import com.grupo_4.Proyecto_Inte_Grupo.model.FacturaYDetalle;
import com.grupo_4.Proyecto_Inte_Grupo.model.Producto;
import com.grupo_4.Proyecto_Inte_Grupo.service.ClienteService;
import com.grupo_4.Proyecto_Inte_Grupo.service.FacturaService;
import com.grupo_4.Proyecto_Inte_Grupo.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/factura")
public class FacturaController {
    
    @Autowired
    ClienteService clienteService;
    @Autowired
    ProductoService productoService;
    @Autowired
    FacturaService facturaService;

    @ModelAttribute("clientes")
    public List<Cliente> clientes()
    {
        return clienteService.listadoClientes();
    }

    @ModelAttribute("productos")
    public List<Producto> productos()
    {
        return productoService.listadoProductos();
    }

    @GetMapping({"","/","lista"})
    public String lista(Model model)
    {
        model.addAttribute("listadoFacturas", facturaService.listadoFacturas());
        return "factura/lista";
    }
    @GetMapping("/formulario")
    public String formulario(FacturaYDetalle facturaydetalle, Model model)
    {
        if (facturaydetalle == null)
            facturaydetalle = new FacturaYDetalle();

        model.addAttribute("facturaydetalle", facturaydetalle);

        Map<Long,String[]> tablaFactura = new HashMap<>();
        model.addAttribute("tablaFactura",tablaFactura);

        return "factura/formulario";
    }

    @PostMapping("/procesaFormulario")
    public String procesaFormulario(FacturaYDetalle facturaydetalle, @RequestBody String request, Model model)
    {
        String vista="";
        Factura factura;
        if (facturaydetalle.getFacturaId()==0)
        {
            factura  = new Factura();
            factura.setEstado("En Proceso");
            factura.setFecha(facturaydetalle.getFecha());
            factura.setObservacion(facturaydetalle.getObservaciones());
        }
        else
        {
            factura = facturaService.obtenerPorId(facturaydetalle.getFacturaId());
        }
            

        
        if (request.contains("button=agregar"))
        {
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setClienteId(facturaydetalle.getClienteId());
            detalleFactura.setProductoId(facturaydetalle.getProductoId());
            detalleFactura.setCantidadProductosRecibidos(facturaydetalle.getCantidadProductosRecibidos());
            factura.getDetalleFactura().add(detalleFactura);
            factura = facturaService.guardarFactura(factura);
            facturaydetalle.setFacturaId(factura.getFacturaId());

            Map<Long,String[]> tablaFactura = new HashMap<>();
            for (DetalleFactura filaFactura : factura.getDetalleFactura())
            {
                Cliente cliente = clienteService.findById(filaFactura.getClienteId());
                Producto producto = productoService.findById(filaFactura.getProductoId());
                String[] filaTabla = new String[]{
                    cliente.getNombre(),
                    producto.getNombre(),
                    String.valueOf(producto.getCantidadProductosNecesarios()),
                    String.valueOf(filaFactura.getCantidadProductosRecibidos())
                };
               
                tablaFactura.put(filaFactura.getDetalleFacturaId()
                , filaTabla);
            }
            model.addAttribute("tablaFactura",tablaFactura);
            model.addAttribute("facturaydetalle", facturaydetalle);
            vista = "factura/formulario";

        }else if (request.contains("button=facturar"))
        {
            factura.setEstado("Facturado");
            facturaService.guardarFactura(factura);
            model.addAttribute("listadoFacturas",facturaService.listadoFacturas());
            vista = "factura/lista";
        }
        
        return vista;
    }
}
