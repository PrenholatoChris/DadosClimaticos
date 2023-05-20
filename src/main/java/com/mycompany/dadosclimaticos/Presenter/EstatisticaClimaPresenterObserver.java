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
public class EstatisticaClimaPresenterObserver implements IPainel{
    private DadoClimaCollection dadosClima;
    
    EstatisticaClimaPresenterObserver(){
        dadosClima = new DadoClimaCollection();
    }
    
    @Override 
    public void atualizar(DadoClima dadoClima){
        dadosClima.add(dadoClima);
        exibir();
        
    }
    
    public void exibir(){
        
    }
}
