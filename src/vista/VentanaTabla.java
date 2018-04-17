/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author chelo
 */
public class VentanaTabla extends JFrame{
    
    private JButton botonAgregar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane2;
    public JTable jTable1; // Haciendolo public se puede omitir el getTable();

    public VentanaTabla(){
        super("Lista de usuarios");
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        botonAgregar = new JButton("Agregar Nuevo");
        jLabel1 = new JLabel("Lista de usuarios almacenados:");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
        String[][] datos = {};
        String [] header = { "Nombre", "Apellido", "Telefono", "Rut", "Email", "Genero", "Estado Civil"};
        DefaultTableModel modelo = new DefaultTableModel(datos, header);
        
        jTable1.setModel(modelo);
        jScrollPane2.setViewportView(jTable1);

        
        botonAgregar.addActionListener((java.awt.event.ActionEvent evt) -> {
            accionBotonAgregar(evt);
        });

        
        posicionarComponentes();
        
        pack();
    }
    
    public void accionBotonAgregar(ActionEvent e){
        VentanaAgregar v = new VentanaAgregar(this);
        
        v.setVisible(true);
    }
    
    public void añadirRegistro(String[] s){
        
        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        
        d.addRow(s);
    }

    private void posicionarComponentes() {

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(botonAgregar)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAgregar)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }
    
}
