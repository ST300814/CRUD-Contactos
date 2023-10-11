package com.gestion.contactos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.contactos.repositorio.ContactoRepositorio;
import com.gestion.contactos.modelo.Contacto;

@Service
public class ContactoServicio {
	
	private final ContactoRepositorio contactoRepositorio;

    public ContactoServicio(ContactoRepositorio contactoRepositorio) {
        this.contactoRepositorio = contactoRepositorio;
    }

    public List<Contacto> obtenerTodosLosContactos() {
        return contactoRepositorio.findAll();
    }
    
    public Contacto obtenerContactoPorId(Long id) {
        return contactoRepositorio.findById(id).orElse(null);
    }
    
    public Contacto crearContacto(Contacto contacto) {
        return contactoRepositorio.save(contacto);
    }
    
    public Contacto actualizarContacto(Long id, Contacto contacto) {
        Contacto contactoExistente = contactoRepositorio.findById(id).orElse(null);
        if (contactoExistente != null) {
            contactoExistente.setNombre(contacto.getNombre());
            contactoExistente.setEmail(contacto.getEmail());
            // Actualiza otras propiedades
            return contactoRepositorio.save(contactoExistente);
        }
        return null;
    }
    
    public boolean eliminarContacto(Long id) {
        if (contactoRepositorio.existsById(id)) {
            contactoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }


}
