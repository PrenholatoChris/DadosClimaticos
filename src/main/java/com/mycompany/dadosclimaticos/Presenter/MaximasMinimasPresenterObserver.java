/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.View.MaximasMinimasView;
import java.awt.Dimension;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
/**
 *
 * @author chris
 */
public class MaximasMinimasPresenterObserver implements IPainel {
    DadoClimaCollection dadosClima;
    MaximasMinimasView view;
    
    public MaximasMinimasPresenterObserver(){
        dadosClima = new DadoClimaCollection();
        view = new MaximasMinimasView("Máximas e Mínimas", true, false, true, true);
//        view.pack();
        view.setVisible(true);
        
        view.setMinimumSize( new Dimension(315, 195));
        view.setSize(700,500);
        
       
    }
    
    @Override
    public void atualizar(DadoClimaCollection dadosClima){
        this.dadosClima = dadosClima;
//        dadosClima.add(dadoClima);
        exibir();
    }
    
    public MaximasMinimasView getView(){
        return view;
    }
    
    public boolean isNull(){
        if(this == null){
            return true;
        }
        else
            return false;
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
        
        var dataset = new DefaultCategoryDataset();
        dataset.setValue(maximaTemperatura, "Máxima", "Temperatura");
        dataset.setValue(minimaTemperatura, "Mínima", "Temperatura");
        
        dataset.setValue(maximaPressao, "Máxima", "Pressão");
        dataset.setValue(minimaPressao, "Mínima", "Pressão");
        
        dataset.setValue(maximaUmidade, "Máxima", "Umidade");
        dataset.setValue(minimaUmidade, "Mínima", "Umidade");
                
        JFreeChart chart = ChartFactory.createBarChart(
                "Máximas e Mínimas dos Dados Climáticos",
                "",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, true);
        
        view.getChartPanel().setChart(chart);
    
        
        
//        view.getFieldTemp().setText(""+ maximaTemperatura + "/" + minimaTemperatura);;
//        view.getFieldPressao().setText(""+ maximaPressao + "/" + minimaPressao);
//        view.getFieldUmidade().setText(""+ maximaUmidade + "/" + minimaUmidade);
        
    }
}
