/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
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
    RegistrosDadoClimaPresenterObserver registrosDadoClimaPresenter;
            
    DadoClimaCollection dadosClima;
    
    public PrincipalPresenter(){
       configurar();
       dadosClima = new DadoClimaCollection();
        
        LocalDate data = LocalDate.now();
        DadoClima novoDado = new DadoClima(25f, 1.5f, 2f, data);
        dadosClima.add(novoDado);
        
        atualizar(dadosClima);
        
        
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
        registrosDadoClimaPresenter = new RegistrosDadoClimaPresenterObserver();
        
        SwingUtilities.invokeLater(() -> {            
            JDesktopPane desktopPane = view.getDesktopPane();
            
            maximasMinimasPresenter.getView().setLocation(10, 500);
            estatisticaClimaPresenter.getView().setLocation(maximasMinimasPresenter.getView().getWidth() + 50, 500);
            painelClimaPresenter.getView().setLocation(maximasMinimasPresenter.getView().getWidth() + estatisticaClimaPresenter.getView().getWidth() +50 +50, 500);

            inserirDadoClimaPresenter.getView().setLocation(10, 10);
            registrosDadoClimaPresenter.getView().setLocation(inserirDadoClimaPresenter.getView().getWidth()+50, 10);
            
            //fazer um vetor de views pra adicionar aqui e no atualizar 
            desktopPane.add(maximasMinimasPresenter.getView());
            desktopPane.add(estatisticaClimaPresenter.getView());
            desktopPane.add(painelClimaPresenter.getView());
            
            
            desktopPane.add(inserirDadoClimaPresenter.getView());
            desktopPane.add(registrosDadoClimaPresenter.getView());
            
            
            view.add(desktopPane, BorderLayout.CENTER);
            view.setMinimumSize(new Dimension(300, 300));
            view.pack();
            view.setVisible(true);
            view.setExtendedState(view.MAXIMIZED_BOTH);
            
            inserirDadoClimaPresenter.getView().getButtonIncluir().addActionListener((e) -> {
                DadoClima dadoClima = inserirDadoClimaPresenter.incluir();
                dadosClima.add(dadoClima);
                atualizar(dadosClima);
            });
            
//            registrosDadoClimaPresenter.getView().getButtonRemover().addActionListener((e)->{
//                
//                dadosClima.remove()
//            
//            })
            
        });
    }
    
    @Override
    public void atualizar(DadoClimaCollection dadosClima){
        maximasMinimasPresenter.atualizar(dadosClima);
        painelClimaPresenter.atualizar(dadosClima);
        estatisticaClimaPresenter.atualizar(dadosClima);
        
        registrosDadoClimaPresenter.atualizar(dadosClima);
    }
    
//    public void adicionarDado(float temp,float umidade, float pressao){
//                atualizar(new DadoClima(temp,pressao,umidade,LocalDate.now()));
//    }
    
    
    
}
