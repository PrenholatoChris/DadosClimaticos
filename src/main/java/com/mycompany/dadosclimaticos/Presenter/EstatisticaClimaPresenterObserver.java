/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.View.EstatisticaClimaView;
import java.awt.Dimension;

/**
 *
 * @author chris
 */
public class EstatisticaClimaPresenterObserver implements IPainel{
    private DadoClimaCollection dadosClima;
    private EstatisticaClimaView view;
    
    EstatisticaClimaPresenterObserver(){
        dadosClima = new DadoClimaCollection();
        view = new EstatisticaClimaView("Dados médios", true, false, true, true);
        
        view.setVisible(true);
        
        view.setLocation(300, 300);
        view.setMinimumSize( new Dimension(373, 208));
        view.setSize(380,220);
    }
    
    public EstatisticaClimaView getView(){
        return view;
    }
    
    @Override 
    public void atualizar(DadoClima dadoClima){
        dadosClima.add(dadoClima);
        exibir();
    }
    
    public void exibir(){
       Float somaTemperaturas = 0f;
       Float somaUmidades = 0f;
       Float somaPressoes = 0f;
       int qtd = 0;

       for (DadoClima dadoClima : dadosClima.getDados()) {
           qtd++;
           somaTemperaturas += dadoClima.getTemperatura();
           somaUmidades += dadoClima.getUmidade();
           somaPressoes += dadoClima.getPressao();
       }

        int tamanho = dadosClima.size();
       
        view.getFieldTemp().setText("" +  (somaTemperaturas / tamanho));
        view.getFieldPressao().setText("" + (somaPressoes / tamanho));
        
        view.getFieldUmidade().setText("" + (somaUmidades / tamanho));
        view.getFieldQtdRegistro().setText("" + qtd);

//
//       System.out.println("--Estatísticas Clima--\nMédia Temperatura: " + (somaTemperaturas / tamanho) 
//        + "\nMédia Umidade: " + (somaUmidades / tamanho) 
//        + "\nMédia Pressão: " + (somaPressoes / tamanho)
//       );
    }
}
