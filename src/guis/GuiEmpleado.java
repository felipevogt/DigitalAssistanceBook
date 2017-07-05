/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import gestorEmpleado.GestorEmpleado;
import gestorEmpleado.Registro;
import gestorEmpleado.Validacion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */
public class GuiEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form GuiEmpleado
     */
    DefaultListModel modeloLista = new DefaultListModel();
    
    
    GestorEmpleado gestorEmpleado;
    public GuiEmpleado(GestorEmpleado gestorEmpleado) {
        initComponents();
        this.gestorEmpleado = gestorEmpleado;
        this.listaEmpleados.setModel(modeloLista);
        for (int i = 0; i < gestorEmpleado.getEmpleados().size(); i++){
            modeloLista.addElement(gestorEmpleado.getEmpleados().get(i));
        }
        this.botonEntrada.setEnabled(false);
        this.botonSalida.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList<>();
        botonEntrada = new javax.swing.JButton();
        botonSalida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaEmpleados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaEmpleadosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaEmpleados);

        botonEntrada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonEntrada.setText("Marcar Entrada");
        botonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntradaActionPerformed(evt);
            }
        });

        botonSalida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSalida.setText("Marcar Salida");
        botonSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalidaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Rut");

        botonRegresar.setText("Back");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(botonSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                        .addComponent(botonRegresar))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntradaActionPerformed
        Registro reg = new Registro();
        String fecha[] = reg.capturarFecha().split("/");
        this.gestorEmpleado.guardarEntradaEmpleado(this.listaEmpleados.getSelectedIndex(), reg.capturaHora(), reg.capturarMinuto(), fecha[0], fecha[1], fecha[2]);
        this.botonEntrada.setEnabled(false);
        this.botonSalida.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Hora de entrada: " + reg.capturaHora() + ":" + reg.capturarMinuto());
    }//GEN-LAST:event_botonEntradaActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        GuiPrincipal guiPrincipal = new GuiPrincipal();
        guiPrincipal.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void listaEmpleadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaEmpleadosValueChanged
        Registro reg = new Registro();
        Validacion val = new Validacion();
        String fecha[] = reg.capturarFecha().split("/");
        
        
        if (val.validarRegistro(this.gestorEmpleado.getEmpleados().get(this.listaEmpleados.getSelectedIndex()).getRut(), fecha[0], fecha[1], fecha[2]) == true){
            this.botonEntrada.setEnabled(false);
            this.botonSalida.setEnabled(true);
        }else{
            this.botonEntrada.setEnabled(true);
            this.botonSalida.setEnabled(false);
        }
        if(val.validarSalida(this.gestorEmpleado.getEmpleados().get(this.listaEmpleados.getSelectedIndex()).getRut(), fecha[0], fecha[1], fecha[2]) == true){
            this.botonSalida.setEnabled(false);
        
        }

    }//GEN-LAST:event_listaEmpleadosValueChanged

    private void botonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalidaActionPerformed
        Registro reg = new Registro();
        String fecha[] = reg.capturarFecha().split("/");
        this.gestorEmpleado.guardarSalidaEmpleado(this.listaEmpleados.getSelectedIndex(),reg.capturaHora(),reg.capturarMinuto(), fecha[0], fecha[1], fecha[2]);
        this.botonSalida.setEnabled(false);
        JOptionPane.showMessageDialog(null,reg.capturarDate());
    }//GEN-LAST:event_botonSalidaActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEntrada;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaEmpleados;
    // End of variables declaration//GEN-END:variables
}
