package com.grupo.sistemaempresarial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupo.sistemaempresarial.modelo.Producto;

@Controller
public class ProductoController {

    private final List<Producto> listaProductos = new ArrayList<>();

    private int contadorId = 1;

    @GetMapping("/productos")
    public String listarProductos(Model model) {

        model.addAttribute("productos", listaProductos);

        return "listado-productos";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("producto", new Producto());

        return "formulario-producto";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(
            @ModelAttribute Producto producto,
            RedirectAttributes redirectAttributes) {

        producto.setId(contadorId++);

        listaProductos.add(producto);

        redirectAttributes.addFlashAttribute(
                "mensaje",
                "Producto registrado correctamente");

        return "redirect:/productos";
    }
}