/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;

import com.mycompany.dadosclimaticos.View.PrincipalView;
import java.awt.BorderLayout;

import java.awt.Dimension;

//import com.mycompany.dadosclimaticos.View.PrincipalView;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author chris
 */
public final class PrincipalPresenter implements IPainel{
    PrincipalView view;
    MaximasMinimasPresenterObserver maximasMinimasPresenter;
    PainelClimaPresenterObserver painelClimaPresenter;
    EstatisticaClimaPresenterObserver estatisticaClimaPresenter;
    InserirDadoClimaPresenter inserirDadoClimaPresenter;
            
    public PrincipalPresenter(){
       configurar();
        
        LocalDate data = LocalDate.now();
        DadoClima novoDado = new DadoClima(25f, 1.5f, 2f, data);
        atualizar(novoDado);

        
        atualizar(new DadoClima(30f, 5f, 1f, data));
        

    }
    
    private void configurar(){
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          } catch (Exception e) {
            e.printStackTrace();
          }
        view = new PrincipalView();
        
        //Presenters e Observers
        maximasMinimasPresenter = new MaximasMinimasPresenterObserver();
        estatisticaClimaPresenter = new EstatisticaClimaPresenterObserver();
        painelClimaPresenter = new PainelClimaPresenterObserver();
        
        
        inserirDadoClimaPresenter = new InserirDadoClimaPresenter();
        
        SwingUtilities.invokeLater(() -> {            
            JDesktopPane desktopPane = view.getDesktopPane();
            
            maximasMinimasPresenter.getView().setLocation(10, 500);
            estatisticaClimaPresenter.getView().setLocation(maximasMinimasPresenter.getView().getWidth() + 50, 500);
            painelClimaPresenter.getView().setLocation(maximasMinimasPresenter.getView().getWidth() + estatisticaClimaPresenter.getView().getWidth() +50 +50, 500);

            inserirDadoClimaPresenter.getView().setLocation(10, 10);
            
            
            //fazer um vetor de views pra adicionar aqui e no atualizar 
            desktopPane.add(maximasMinimasPresenter.getView());
            desktopPane.add(estatisticaClimaPresenter.getView());
            desktopPane.add(painelClimaPresenter.getView());
            
            
            desktopPane.add(inserirDadoClimaPresenter.getView());
            
            
            view.add(desktopPane, BorderLayout.CENTER);
            view.setMinimumSize(new Dimension(300, 300));
            view.pack();
            view.setVisible(true);
            view.setExtendedState(view.MAXIMIZED_BOTH);
            
            inserirDadoClimaPresenter.getView().getButtonIncluir().addActionListener((e) -> {
                atualizar(inserirDadoClimaPresenter.incluir());
            });
            
        });
    }
    
    @Override
    public void atualizar(DadoClima novoDado){
        maximasMinimasPresenter.atualizar(novoDado);
        painelClimaPresenter.atualizar(novoDado);
        estatisticaClimaPresenter.atualizar(novoDado);
    }
    
//    public void adicionarDado(float temp,float umidade, float pressao){
//                atualizar(new DadoClima(temp,pressao,umidade,LocalDate.now()));
//    }
    
    
    
}
