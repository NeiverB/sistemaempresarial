package com.grupo.sistemaempresarial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    private Producto buscarPorId(int id) {

        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    @GetMapping("/productos/editar/{id}")
    public String editarProducto(
            @PathVariable int id,
            Model model) {

        Producto producto = buscarPorId(id);

        model.addAttribute("producto", producto);

        return "editar-producto";
    }

    @PostMapping("/productos/actualizar")
    public String actualizarProducto(
            @ModelAttribute Producto producto,
            RedirectAttributes redirectAttributes) {

        Producto existente = buscarPorId(producto.getId());

        if (existente != null) {

            existente.setNombre(producto.getNombre());
            existente.setCategoria(producto.getCategoria());
            existente.setPrecio(producto.getPrecio());

            redirectAttributes.addFlashAttribute(
                    "mensaje",
                    "Producto actualizado correctamente");
        }

        return "redirect:/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(
            @PathVariable int id,
            RedirectAttributes redirectAttributes) {

        Producto producto = buscarPorId(id);

        if (producto != null) {

            listaProductos.remove(producto);

            redirectAttributes.addFlashAttribute(
                    "mensaje",
                    "Producto eliminado correctamente");
        }

        return "redirect:/productos";
    }
}