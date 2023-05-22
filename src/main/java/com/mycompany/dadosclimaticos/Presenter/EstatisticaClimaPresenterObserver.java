/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.View.EstatisticaClimaView;

/**
 *
 * @author chris
 */
public class EstatisticaClimaPresenterObserver implements IPainel{
    private DadoClimaCollection dadosClima;
    
    EstatisticaClimaPresenterObserver(){
        dadosClima = new DadoClimaCollection();
        EstatisticaClimaView view = new EstatisticaClimaView();
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

       for (DadoClima dadoClima : dadosClima.getDados()) {
           somaTemperaturas += dadoClima.getTemperatura();
           somaUmidades += dadoClima.getUmidade();
           somaPressoes += dadoClima.getPressao();
       }

       int tamanho = dadosClima.size();

       System.out.println("--Estatísticas Clima--\nMédia Temperatura: " + (somaTemperaturas / tamanho) 
        + "\nMédia Umidade: " + (somaUmidades / tamanho) 
        + "\nMédia Pressão: " + (somaPressoes / tamanho)
       );
    }
}
