/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.View.RegistrosDadoClimaView;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chris
 */
public class RegistrosDadoClimaPresenterObserver implements IPainel {
    RegistrosDadoClimaView view;
    DadoClimaCollection dadosClima;
    
    public RegistrosDadoClimaPresenterObserver(){
        dadosClima = new DadoClimaCollection();
        view = new RegistrosDadoClimaView("Registros",true, false, true, true);
        view.setVisible(true);
//        view.setLocation(300, 300);
        view.setMinimumSize( new Dimension(303, 260));
        view.setSize(380,260);
        
        
        dadosClima = new DadoClimaCollection();
        
//        view.pack();
    }
    
    public RegistrosDadoClimaView getView(){
        return view;
    }
    
    @Override
     public void atualizar(DadoClimaCollection dadosClima){
        this.dadosClima = dadosClima;
        
        JTable tabela = view.getTable();        
        
         Object[][] data = {};
         
        tabela = new JTable(new DefaultTableModel(data, new Object[]{"Column1", "Column2"}));
        
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
         
        
        for (DadoClima dadoClima : dadosClima.getDados()) {
              dtm.addRow(new Object[]{
                  dadoClima.getData().toString(),
                  String.valueOf( dadoClima.getTemperatura()),
                  String.valueOf(dadoClima.getUmidade()),
                  String.valueOf(dadoClima.getPressao())
              });
        }
    }
     
     
}
