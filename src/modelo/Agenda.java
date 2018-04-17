/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author chelo
 */
public class Agenda {
    
    ArrayList<Contacto> contactos = new ArrayList<>();

    public Agenda() {
    }
    
    public void addPersona(Contacto p){
        contactos.add(p);
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    
    
    
}
