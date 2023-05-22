/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import java.time.LocalDate;

/**
 *
 * @author chris
 */
public class PainelClimaPresenterObserver implements IPainel{
    private DadoClima dadoClima;
    
    @Override
    public void atualizar(DadoClima dadoClima){
        if (dadoClima.getData().isEqual(LocalDate.now())) {
            this.dadoClima = dadoClima;
        }
        exibir();
    }
    
    public void exibir(){
        System.out.println("--Ultimo dado--"
            +   "\nTemp= " + dadoClima.getTemperatura()
            + "\nUmidade= " + dadoClima.getUmidade()
            + "\nPressao= " + dadoClima.getPressao()
        );
    }
    
    
    
    
}
