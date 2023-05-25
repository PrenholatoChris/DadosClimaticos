/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.View.PainelClimaView;
import java.awt.Dimension;
import java.time.LocalDate;

/**
 *
 * @author chris
 */
public class PainelClimaPresenterObserver implements IPainel{
    private DadoClima dadoClima;
    private PainelClimaView view;
    
    public PainelClimaPresenterObserver(){
        view = new PainelClimaView("Ultima Atualização do tempo", true, false, true, true);
         view.setVisible(true);
        
        view.setLocation(300, 300);
        view.setMinimumSize( new Dimension(303, 204));
        view.setSize(380,220);
    }
    
    @Override
    public void atualizar(DadoClima dadoClima){
        this.dadoClima = dadoClima;
        exibir();
    }
    
    public PainelClimaView getView(){
        return view;
    }
    
    public void exibir(){
        view.getFieldData().setText(dadoClima.getData().toString());
        view.getFieldPressao().setText(""+dadoClima.getPressao());
        view.getFieldTemp().setText(""+dadoClima.getTemperatura());
        view.getFieldUmidade().setText(""+dadoClima.getUmidade());
    }
    
    
    
    
}
