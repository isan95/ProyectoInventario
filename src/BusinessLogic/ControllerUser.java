/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.User;
import GUI.Principal;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author POLANCO
 */
public class ControllerUser {
    private User usr;
    private QueryUser qu;
    Principal frm;
    
    public ControllerUser(User usr, QueryUser qu, Principal frm){
        this.usr = usr;
        this.qu = qu;
        this.frm = frm;
        this.frm.jButtonStartSesion.addActionListener((ActionListener) this);
        
    }
    public void start(){
        frm.setTitle("Iniciar sesion");
        frm.setLocationRelativeTo(null);
    }
    public void ActionPerformanced(ActionEvent e){
        if(e.getSource() == frm.jButtonStartSesion){
            if(qu.login(usr)){
               frm.removeAll();
            }
            else{
            JOptionPane.showMessageDialog(frm, "Contraseña o usuario invalido");
            }
            
        }
    }
    
   
}
