/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Agenda;
import modelo.Contacto;
import vista.VentanaAgregar;

/**
 *
 * @author chelo
 */
public class AgendaController implements ActionListener{
    
    private JTable tabla;
    private Agenda agenda = new Agenda();
    private VentanaAgregar formulario;
    
    public AgendaController( JTable tabla, VentanaAgregar formulario) {
        this.formulario=formulario;
        this.tabla=tabla;
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando  = e.getActionCommand();
        if(comando=="insertarContacto"){           
            String nombre=formulario.tfNombre.getText();
            String apellido=formulario.tfApellido.getText();
            String rut=formulario.tfRut.getText();
            String telefono =formulario.tfTelefono.getText();
            String mail = formulario.tfMail.getText();
            String genero = formulario.buttonGroup1.getSelection().getActionCommand();
            String estado = formulario.jComboBox1.getSelectedItem().toString();

            agenda.addPersona(new Contacto(nombre, apellido, telefono, rut, mail, genero, estado));
            
            String[] arreglo= {nombre,apellido,rut,telefono,mail,genero,estado};
            
            DefaultTableModel d = (DefaultTableModel) tabla.getModel();
            d.addRow(arreglo);
            formulario.dispose();
        }
        if(comando=="Cancelar"){
            formulario.dispose();
        }
    }
    
    //Omitan este metodo
    public void cargarTabla(){
        
        ArrayList<Contacto> contactos=agenda.getContactos();
        DefaultTableModel d = (DefaultTableModel) tabla.getModel();
        
        for(int i=0; i<contactos.size(); i++){
            Contacto c= contactos.get(i);
            
            String nombre=c.getNombre();
            String apellido=c.getApellido();
            String rut=c.getRut();
            String telefono =c.getTelefono();
            String mail = c.getEmail();
            String genero = c.getGenero();
            String estado = c.getEstadoCivil();

            String[] registro= {nombre,apellido,rut,telefono,mail,genero,estado};

            d.addRow(registro);
        }
      
        
    }
}
