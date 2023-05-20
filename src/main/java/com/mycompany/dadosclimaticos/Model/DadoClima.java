/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Model;


import java.time.LocalDate;
//import java.util.Date;

/**
 *
 * @author chris
 */
public class DadoClima {
    private Float temperatura;
    private Float umidade;
    private Float pressao;
    private LocalDate data;
    
    public DadoClima(float temperatura, float umidade, float pressao, LocalDate data){
        this.data = data;
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.umidade = umidade;
    }
    
    public LocalDate getData() {
        return data;
    }
     
    public float getTemperatura(){
        return temperatura;
    }

    public float getPressao() {
        return pressao;
    }

    public float getUmidade() {
        return umidade;
    }
    
    
}
