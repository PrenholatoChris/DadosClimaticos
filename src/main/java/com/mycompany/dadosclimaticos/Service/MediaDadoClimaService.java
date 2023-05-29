/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Service;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.MediaDadoClima;

/**
 *
 * @author chris
 */
public class MediaDadoClimaService {
    
    public static MediaDadoClima calcular(DadoClimaCollection dadosClima){
       Float somaTemperaturas = 0f;
       Float somaUmidades = 0f;
       Float somaPressoes = 0f;

       for (DadoClima dadoClima : dadosClima.getDados()) {
           somaTemperaturas += dadoClima.getTemperatura();
           somaUmidades += dadoClima.getUmidade();
           somaPressoes += dadoClima.getPressao();
       }

        int tamanho = dadosClima.size();
        
        return new MediaDadoClima(somaTemperaturas/tamanho, somaUmidades/tamanho, somaPressoes/tamanho);
    }
}
