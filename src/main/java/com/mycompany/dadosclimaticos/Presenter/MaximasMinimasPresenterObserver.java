/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.Model.MaximasMinimasDadoClima;
import com.mycompany.dadosclimaticos.Service.MaximasMinimasService;
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
        exibir();
    }
    
    public MaximasMinimasView getView(){
        return view;
    }
    
    
    public void exibir(){
        var dataset = new DefaultCategoryDataset();

        if(dadosClima.size() == 0){
            JFreeChart chart = ChartFactory.createBarChart(
                "Máximas e Mínimas dos Dados Climáticos",
                "",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, true);
        
            view.getChartPanel().setChart(chart);
            return;
        }
        
        MaximasMinimasDadoClima maximasMinimas = MaximasMinimasService.calcular(dadosClima);
        float minimaTemperatura = maximasMinimas.getMinimaTemperatura();
        float maximaTemperatura = maximasMinimas.getMaximaTemperatura();
        
        float minimaPressao = maximasMinimas.getMinimaPressao();
        float maximaPressao = maximasMinimas.getMaximaPressao();
        
        float minimaUmidade = maximasMinimas.getMinimaUmidade();
        float maximaUmidade = maximasMinimas.getMaximaUmidade();

        
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
    }
}
