/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Model;

/**
 *
 * @author chris
 */
public class MediaDadoClima {
    private final Float temperatura;
    private final Float umidade;
    private final Float pressao;
    
    public MediaDadoClima(float temperatura, float umidade, float pressao){
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
    }

    public Float getPressao() {
        return pressao;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public Float getUmidade() {
        return umidade;
    }
}
