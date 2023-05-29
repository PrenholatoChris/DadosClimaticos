/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Collection;

import com.mycompany.dadosclimaticos.Model.DadoClima;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class DadoClimaCollection {
    private final ArrayList<DadoClima> dadosClima;
    
    public DadoClimaCollection(ArrayList<DadoClima> dados){
        this.dadosClima = dados;
    }
    
    public DadoClimaCollection(){
        dadosClima = new ArrayList();
    }
    
    public boolean add(DadoClima dadoClima){

        return dadosClima.add(dadoClima);
    }
    
    public ArrayList<DadoClima> getDados(){
        return this.dadosClima;
    }
    
    public boolean remove(DadoClima dadoClima){
        return dadosClima.remove(dadoClima);
    }
    
    public boolean remove(int index){
        if(dadosClima.size() > index){
            dadosClima.remove(index);
            return true;
        }
        else
            return false;
    }
    
    public DadoClima get(int index){
        int size = dadosClima.size();
        if(size >= index){
            return dadosClima.get(index);
        }
        else 
            return null;
    }
    
    public int size(){
        return dadosClima.size();
    }
    
}
