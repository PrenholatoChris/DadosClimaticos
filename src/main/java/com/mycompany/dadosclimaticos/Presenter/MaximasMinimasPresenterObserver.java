/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;

/**
 *
 * @author chris
 */
public class MaximasMinimasPresenterObserver implements IPainel {
    DadoClimaCollection dadosClima;
    
    
    
    public MaximasMinimasPresenterObserver(){
        dadosClima = new DadoClimaCollection();
    }
    
    @Override
    public void atualizar(DadoClima dadoClima){
        dadosClima.add(dadoClima);
        exibir();
    }
    
    
    public void exibir(){
        float minimaTemperatura = 9999;
        float minimaPressao = 9999;
        float minimaUmidade = 9999;
        
        float maximaTemperatura = -9999;
        float maximaPressao = -9999;
        float maximaUmidade = -9999;
               
        for (DadoClima dadoClima : dadosClima.getDados()) {
            float temp = dadoClima.getTemperatura();
            if(temp > maximaTemperatura)
                maximaTemperatura = temp;
            if(temp < minimaTemperatura)
                minimaTemperatura = temp;
            
            float pressao = dadoClima.getPressao();
            if(pressao > maximaPressao)
                maximaPressao = pressao;
            if(pressao < minimaPressao)
                minimaPressao = pressao;
            
            float umidade = dadoClima.getUmidade();
            if(umidade > maximaUmidade)
                maximaUmidade = umidade;
            if(umidade < minimaUmidade)
                minimaUmidade = umidade;
        }
        
        System.out.println(
            "--Maximas/Minimas--\n" +
            "Temp = " + maximaTemperatura + "/" + minimaTemperatura +
            "\nUmidade = " + maximaUmidade + "/" + minimaUmidade +
            "\nPressao = " + maximaPressao + "/" + minimaPressao
        );
    }
}
