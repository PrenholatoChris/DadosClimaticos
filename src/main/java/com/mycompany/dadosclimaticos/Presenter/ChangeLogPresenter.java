/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.View.ChangeLogView;
import java.awt.Dimension;

/**
 *
 * @author chris
 */
public class ChangeLogPresenter {
    ChangeLogView view;
    
    public ChangeLogPresenter(){
        view = new ChangeLogView("Configuração do log", true, false, true, true);
        
        view.setVisible(true);
        
        view.setMinimumSize( new Dimension(150, 110));
        view.setSize(150,110);
    }
    
    public ChangeLogView getView(){
        return view;
    }
    
}
