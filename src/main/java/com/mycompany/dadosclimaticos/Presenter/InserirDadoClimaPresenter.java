/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.View.InserirDadoClimaView;
import java.awt.Dimension;
import java.time.LocalDate;

/**
 *
 * @author chris
 */
public class InserirDadoClimaPresenter {
    InserirDadoClimaView view;
    public InserirDadoClimaPresenter(){
        view = new InserirDadoClimaView("Inserir Dados do tempo", true, false, true, true);
    
        view.setVisible(true);
        view.setLocation(300, 300);
        view.setMinimumSize( new Dimension(303, 239));
        view.setSize(380,240);
    
    
    
    }
    
    public InserirDadoClimaView getView(){
        return view;
    }
    
    
    
    public DadoClima incluir(){
        float temp = Float.valueOf(view.getFieldTemp().getText());
        float umidade = Float.valueOf(view.getFieldUmidade().getText());
        float pressao = Float.valueOf(view.getFieldPressao().getText());
        
        String[] vetor = view.getFieldData().getText().split("/");
        
        int dia = Integer.valueOf(vetor[0]);
        int mes = Integer.valueOf(vetor[1]);
        int ano = Integer.valueOf(vetor[2]);
        
        LocalDate data = LocalDate.of(ano, mes, dia);
                
        DadoClima dadoClima = new DadoClima(temp,umidade,pressao,data);
        view.getFieldData().setText("DD/MM/AAAA");
        view.getFieldPressao().setText("");
        view.getFieldTemp().setText("");
        view.getFieldUmidade().setText("");
        
        
        return dadoClima;       
    }

    
}
