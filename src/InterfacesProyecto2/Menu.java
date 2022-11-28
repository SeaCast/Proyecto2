/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesProyecto2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import proyecto2.*;


/**
 *
 * @author Martin
 */
public class Menu extends javax.swing.JFrame {

    //Variable global para el string de la expresion a escanear
    
    String stringexpresion = "";
    String stringintopost = "";
    String stringpretopost = "";
    Verifications veri = new Verifications();
    binaryTree expresionTree = new binaryTree();
    
   
    
    public Menu() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CargarExpresion = new javax.swing.JButton();
        graficar = new javax.swing.JButton();
        goOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CargarExpresion.setText("Cargar Expresion");
        CargarExpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarExpresionActionPerformed(evt);
            }
        });
        jPanel1.add(CargarExpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, -1));

        graficar.setText("Visualizar Arbol");
        graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarActionPerformed(evt);
            }
        });
        jPanel1.add(graficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 20, 150, -1));

        goOut.setText("Salir");
        goOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goOutActionPerformed(evt);
            }
        });
        jPanel1.add(goOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarExpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarExpresionActionPerformed
        
      
        //Se usa JFileChooser para cargar el txt
        JFileChooser fc = new JFileChooser();
        
        int seleccion = fc.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION){
            
            File fichero = fc.getSelectedFile();
            
           try (Scanner scanner = new Scanner(fichero))
        {
           //Se escanea la expresion del archivo txt 
           stringexpresion = scanner.nextLine();
           
           JOptionPane.showMessageDialog(null, "Se ha cargado la expresion exitosamente");
              
        } 
           catch (IOException e) {
            e.printStackTrace();
        }
           
           //Se crean la clase con las funciones de conversion
           InPreToPostMethods caller = new InPreToPostMethods();
           //Se separa el string en un arreglo para evaluar que tipo de expresion es
           String[] arrayExpresion = stringexpresion.split("");
           
           
           //Si el primer valor de la expresion es un operador, la expresion es prefija, se ejecuta la conversion a postfijo
           try {
           if(veri.isOperator(arrayExpresion[0])){
               stringpretopost = caller.prefixToPostFix(stringexpresion);
               stringexpresion = stringpretopost;
               JOptionPane.showMessageDialog(null, "Se ha cambiado la expresion prefija a posfija");
            
               
           //Si el ultimo valor de la expresion es un operador, la expresion es postfija y no se hace nada    
           }else if (veri.isOperator(arrayExpresion[arrayExpresion.length - 1])){
           
           //Si no se cumplen los casos anteriores, la expresion es infija, se ejecuta la conversion respectiva a postfijo
           }else{
               stringintopost = caller.infixToPostfix(stringexpresion);
               stringexpresion = stringintopost;
               JOptionPane.showMessageDialog(null, "Se ha cambiado la expresion infija a posfija");
               
           }
           
           //Con la expresion postfija se construye el arbol
           expresionTree = veri.buildTree(stringexpresion);
           
               }
           
           catch (Exception e){
           
             JOptionPane.showMessageDialog(null, "Hay un error con la expresion introducida, por favor verifique e intente de nuevo");
           }
        
        }
        
        
    }//GEN-LAST:event_CargarExpresionActionPerformed

    private void graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarActionPerformed
        
        if(!expresionTree.isEmpty()){
            Ventana1 ventana = new Ventana1(this.expresionTree, this);
            this.setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "El arbol esta vacio, por favor cargue una expresion antes de visualizar el arbol");
        }
    }//GEN-LAST:event_graficarActionPerformed

    private void goOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goOutActionPerformed
        this.dispose();
    }//GEN-LAST:event_goOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarExpresion;
    private javax.swing.JButton goOut;
    private javax.swing.JButton graficar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
