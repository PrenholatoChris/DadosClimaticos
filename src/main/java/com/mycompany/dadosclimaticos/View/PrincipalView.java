/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.View;

//import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author chris
 */
public class PrincipalView extends JFrame{
    private final JDesktopPane desktopPane = new JDesktopPane();
            
    public PrincipalView() {

  }
    
    public JDesktopPane getDesktopPane(){
        return desktopPane;
    }
    
}
