/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.AgendaController;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author chelo
 */
public class VentanaAgregar extends JFrame{
    public ButtonGroup buttonGroup1;
    public JButton jButton1;
    public JButton jButton2;
    public JComboBox<String> jComboBox1;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JLabel jLabel4;
    public JLabel jLabel5;
    public JLabel jLabel6;
    public JLabel jLabel7;
    public JLabel jLabel8;
    public JRadioButton jRadioButton1;
    public JRadioButton jRadioButton2;
    public JTextField tfNombre;
    public JTextField tfApellido;
    public JTextField tfTelefono;
    public JTextField tfRut;
    public JTextField tfMail;
    public VentanaTabla v;

    public VentanaAgregar( VentanaTabla v) {
        super("Ingresar Usuario");
        this.v = v; //Guardamos la referencia de la tabla que instanció la VentanaAgregar
        
        
        jLabel1 = new JLabel("Nombre");
        jLabel2 = new JLabel("Apellido");
        jLabel3 = new JLabel("Telefono");
        jLabel4 = new JLabel("Rut");
        jLabel5 = new JLabel("Email");
        jLabel6 = new JLabel("Genero");
        jLabel7 = new JLabel("Estado Civil");
        jLabel8 = new JLabel("Ingrese información del contacto nuevo:");
        
        jButton1 = new JButton("Agregar");
        //jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            //accionAgregar(evt);
         //});
         
         AgendaController c = new AgendaController(v.tablaContactos,this);
        jButton1.addActionListener(c);
        jButton1.setActionCommand("insertarContacto");
                
        jButton2 = new JButton("Cancelar"); 
        jButton2.addActionListener(c);
        jButton2.setActionCommand("Cancelar");
//jButton2.addActionListener((java.awt.event.ActionEvent evt) -> {
        //    accionCancelar(evt);
        //});
        
        tfNombre = new JTextField();
        tfApellido = new JTextField();
        tfTelefono = new JTextField();
        tfRut = new JTextField();
        tfMail = new JTextField();
        
        buttonGroup1 = new ButtonGroup();
        jRadioButton1 = new JRadioButton("Masculino");
        jRadioButton1.setActionCommand("Masculino");
        jRadioButton2 = new JRadioButton("Femenino");
        jRadioButton2.setActionCommand("Femenino");
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        
        jComboBox1 = new JComboBox<>();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Soltero(a)", "Casado(a)." }));
        
        definirPosiciones(); //Metodo propio para añadir cada elemento al layout de la ventana
        //Lo hice aparte para no contaminar tanto el constructor con mucho codigo.
        pack();
  
    }
    
    //ESto ya no se llama
    public void accionAgregar(ActionEvent e){
        
        String nombre=tfNombre.getText();
        String apellido=tfApellido.getText();
        String rut=tfRut.getText();
        String telefono =tfTelefono.getText();
        String mail = tfMail.getText();
        String genero = buttonGroup1.getSelection().getActionCommand();
        String estado = jComboBox1.getSelectedItem().toString();
                
        String[] arreglo= {nombre,apellido,rut,telefono,mail,genero,estado};
        
        v.añadirRegistro(arreglo);
        this.dispose();
    }
    //Esto tampoco se llama
    public void accionCancelar(ActionEvent e){
        this.dispose();
    }
    
    public void definirPosiciones(){
        //Lo unico que hace este metodo es setear cada componente en una posicion especifica de la ventana
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton2)
                .addGap(101, 101, 101)
                .addComponent(jButton1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfMail)
                            .addComponent(tfRut)
                            .addComponent(tfTelefono, GroupLayout.Alignment.TRAILING)
                            .addComponent(tfApellido, GroupLayout.Alignment.TRAILING)
                            .addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(45, 45, 45)
                                .addComponent(jRadioButton2)))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfRut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }
}
