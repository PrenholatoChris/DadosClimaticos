/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Model;

/**
 *
 * @author chris
 */
public class MaximasMinimasDadoClima {
    private final Float minimaTemperatura;
    private final Float maximaTemperatura;
    private final Float minimaPressao;
    private final Float maximaPressao;
    private final Float minimaUmidade;
    private final Float maximaUmidade;
    
    public MaximasMinimasDadoClima(float minimaTemperatura, float maximaTemperatura, float minimaPressao, float maximaPressao, float minimaUmidade, float maximaUmidade){
        this.minimaTemperatura = minimaTemperatura;
        this.maximaTemperatura = maximaTemperatura;
        this.minimaPressao = minimaPressao;
        this.maximaPressao = maximaPressao;
        this.minimaUmidade = minimaUmidade;
        this.maximaUmidade = maximaUmidade;
    }

    public Float getMaximaPressao() {
        return maximaPressao;
    }

    public Float getMaximaTemperatura() {
        return maximaTemperatura;
    }

    public Float getMaximaUmidade() {
        return maximaUmidade;
    }

    public Float getMinimaPressao() {
        return minimaPressao;
    }

    public Float getMinimaTemperatura() {
        return minimaTemperatura;
    }

    public Float getMinimaUmidade() {
        return minimaUmidade;
    }
    
}
