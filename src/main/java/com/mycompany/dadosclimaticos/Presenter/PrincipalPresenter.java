/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.View.PrincipalView;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author chris
 */
public class PrincipalPresenter {
    MaximasMinimasPresenterObserver maximasMinimas;
    PainelClimaPresenterObserver painelClima;
    EstatisticaClimaPresenterObserver estatisticaClima;
            
    public PrincipalPresenter(){
        //PrincipalView view = new PrincipalView();
        JDesktopPane  view = new JDesktopPane();
        
        
        JInternalFrame maximasMinimas = new JInternalFrame("Maximas e Minimas", true, false, true, true);
        
        
        maximasMinimas.pack();
        maximasMinimas.setVisible(true);
        

        view.add(maximasMinimas);        
        view.setVisible(true);
        
        
        
        
         
        LocalDate data = LocalDate.now();
        DadoClima novoDado = new DadoClima(25f, 1.5f, 2f, data);
        DadoClima dadoClima2 = new DadoClima(30f, 5f, 1f, data);
        
        //maximasMinimas= new MaximasMinimasPresenterObserver();
        painelClima = new PainelClimaPresenterObserver();
        estatisticaClima = new EstatisticaClimaPresenterObserver();
        
        atualizar(novoDado);
        atualizar(dadoClima2);
        
        
        
        //view.add(view)
    }
    
    
    public void atualizar(DadoClima novoDado){
        //maximasMinimas.atualizar(novoDado);
        painelClima.atualizar(novoDado);
        estatisticaClima.atualizar(novoDado);
    }
    
    public void adicionarDado(float temp,float umidade, float pressao){
                atualizar(new DadoClima(temp,pressao,umidade,LocalDate.now()));
    }
    
    
    
}
