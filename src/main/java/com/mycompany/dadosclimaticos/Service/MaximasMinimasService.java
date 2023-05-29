/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Service;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.MaximasMinimasDadoClima;

/**
 *
 * @author chris
 */
public class MaximasMinimasService {
    
    public static MaximasMinimasDadoClima calcular(DadoClimaCollection dadosClima){
        float minimaTemperatura = dadosClima.get(0).getTemperatura();
        float maximaTemperatura = dadosClima.get(0).getTemperatura();
        
        float minimaPressao = dadosClima.get(0).getPressao();
        float maximaPressao = dadosClima.get(0).getPressao();
        
        float minimaUmidade = dadosClima.get(0).getUmidade();
        float maximaUmidade = dadosClima.get(0).getUmidade();
        
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
        
        return new MaximasMinimasDadoClima(minimaTemperatura, maximaTemperatura, minimaPressao, maximaPressao, minimaUmidade, maximaUmidade);
    }    
}
