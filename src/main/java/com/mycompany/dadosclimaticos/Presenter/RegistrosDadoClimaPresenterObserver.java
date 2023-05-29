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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chris
 */
public class RegistrosDadoClimaPresenterObserver implements IPainel {
    RegistrosDadoClimaView view;
    DadoClimaCollection dadosClima;
    JTable tabela;
    
    public RegistrosDadoClimaPresenterObserver(){
        dadosClima = new DadoClimaCollection();
        view = new RegistrosDadoClimaView("Registros",true, false, true, true);
        view.setVisible(true);
        view.setMinimumSize( new Dimension(303, 260));
        view.setSize(380,260);
        
        
        dadosClima = new DadoClimaCollection();
        
//        view.pack();

        tabela = view.getTable();
        
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        
        dtm.addColumn("Data");
        dtm.addColumn("Temperatura");
        dtm.addColumn("Umidade");
        dtm.addColumn("Pressao");        
    }
    
    public RegistrosDadoClimaView getView(){
        return view;
    }
    
    @Override
     public void atualizar(DadoClimaCollection dadosClima){
        this.dadosClima = dadosClima;
         
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        dtm.setRowCount(0);
        
        if(dadosClima.getDados().isEmpty()){
            return;
        }
        
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
