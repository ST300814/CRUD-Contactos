package com.gestion.contactos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.contactos.service.ContactoServicio;
import com.gestion.contactos.modelo.Contacto;

@RestController
@RequestMapping("/contactos")
public class ContactoControlador {

	private final ContactoServicio contactoServicio;

    public ContactoControlador(ContactoServicio contactoServicio) {
        this.contactoServicio = contactoServicio;
    }

    @GetMapping
    public List<Contacto> obtenerTodosLosContactos() {
        return contactoServicio.obtenerTodosLosContactos();
    }
    
    @GetMapping("/{id}")
    public Contacto obtenerContactoPorId(@PathVariable Long id) {
        return contactoServicio.obtenerContactoPorId(id);
    }
    
    @PostMapping
    public Contacto crearContacto(@RequestBody Contacto contacto) {
        return contactoServicio.crearContacto(contacto);
    }
    
    @PutMapping("/{id}")
    public Contacto actualizarContacto(@PathVariable Long id, @RequestBody Contacto contacto) {
        return contactoServicio.actualizarContacto(id, contacto);
    }
    
    @DeleteMapping("/{id}")
    public boolean eliminarContacto(@PathVariable Long id) {
        return contactoServicio.eliminarContacto(id);
    }

	
}
