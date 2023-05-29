/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.Model.MediaDadoClima;
import com.mycompany.dadosclimaticos.Service.MediaDadoClimaService;
import com.mycompany.dadosclimaticos.View.MediaClimaView;
import java.awt.Dimension;

/**
 *
 * @author chris
 */
public class MediaClimaPresenterObserver implements IPainel{
    private DadoClimaCollection dadosClima;
    private MediaClimaView view;
    
    MediaClimaPresenterObserver(){
        dadosClima = new DadoClimaCollection();
        view = new MediaClimaView("Dados médios", true, false, true, true);
        
        view.setVisible(true);
        
        view.setLocation(300, 300);
        view.setMinimumSize( new Dimension(373, 208));
        view.setSize(380,220);
    }
    
    public MediaClimaView getView(){
        return view;
    }
    
    @Override 
    public void atualizar(DadoClimaCollection dadosClima){
        this.dadosClima = dadosClima;
        exibir();
    }
    
    public void exibir(){
        if(dadosClima.size() == 0){
            view.getFieldTemp().setText("sem dados");
            view.getFieldPressao().setText("sem dados");
            view.getFieldUmidade().setText("sem dados");
            view.getFieldQtdRegistro().setText("sem dados");
            return;
        }
        
        MediaDadoClima medias = MediaDadoClimaService.calcular(dadosClima);
        float tempMedia =medias.getTemperatura();
        float pressaoMedia = medias.getPressao();
        float umidadeMedia = medias.getUmidade();
       
        view.getFieldTemp().setText("" +  (tempMedia));
        view.getFieldPressao().setText("" + (pressaoMedia));
        
        view.getFieldUmidade().setText("" + (umidadeMedia));
        view.getFieldQtdRegistro().setText("" + dadosClima.size());
    }
}
