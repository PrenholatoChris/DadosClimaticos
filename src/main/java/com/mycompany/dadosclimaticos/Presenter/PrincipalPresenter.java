/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Presenter;

import com.mycompany.dadosclimaticos.Collection.DadoClimaCollection;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.mycompany.dadosclimaticos.Model.IPainel;
import com.mycompany.dadosclimaticos.Log.Log;


import com.mycompany.dadosclimaticos.View.PrincipalView;
import java.awt.BorderLayout;

import java.awt.Dimension;

//import com.mycompany.dadosclimaticos.View.PrincipalView;
import java.time.LocalDate;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    MediaClimaPresenterObserver estatisticaClimaPresenter;
    
    InserirDadoClimaPresenter inserirDadoClimaPresenter;
    RegistrosDadoClimaPresenterObserver registrosDadoClimaPresenter;
    ChangeLogPresenter changeLogPresenter;
    
    DadoClimaCollection dadosClima;
    
    Log log;
    
    
    public PrincipalPresenter(){        
       configurarTela();
       log = new Log();       
       
       dadosClima = new DadoClimaCollection();
    }
   
    
    private void configurarTela(){
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          } catch (Exception e) {
            e.printStackTrace();
          }
        view = new PrincipalView();
        
        //Presenters e Observers
        maximasMinimasPresenter = new MaximasMinimasPresenterObserver();
        estatisticaClimaPresenter = new MediaClimaPresenterObserver();
        painelClimaPresenter = new PainelClimaPresenterObserver();
        
        
        inserirDadoClimaPresenter = new InserirDadoClimaPresenter();
        registrosDadoClimaPresenter = new RegistrosDadoClimaPresenterObserver();
        changeLogPresenter = new ChangeLogPresenter();
        
        SwingUtilities.invokeLater(() -> {            
            JDesktopPane desktopPane = view.getDesktopPane();
            
            maximasMinimasPresenter.getView().setLocation(10, 500);
            estatisticaClimaPresenter.getView().setLocation(maximasMinimasPresenter.getView().getWidth() + 50, 500);
            painelClimaPresenter.getView().setLocation(maximasMinimasPresenter.getView().getWidth() + estatisticaClimaPresenter.getView().getWidth() +50 +50, 500);

            inserirDadoClimaPresenter.getView().setLocation(10, 10);
            registrosDadoClimaPresenter.getView().setLocation(inserirDadoClimaPresenter.getView().getWidth()+50, 10);
            changeLogPresenter.getView().setLocation(inserirDadoClimaPresenter.getView().getWidth() + registrosDadoClimaPresenter.getView().getWidth() +50+50, 10);
            
            //fazer um vetor de views pra adicionar aqui e no atualizar 
            desktopPane.add(maximasMinimasPresenter.getView());
            desktopPane.add(estatisticaClimaPresenter.getView());
            desktopPane.add(painelClimaPresenter.getView());
            
            
            desktopPane.add(inserirDadoClimaPresenter.getView());
            desktopPane.add(registrosDadoClimaPresenter.getView());
            desktopPane.add(changeLogPresenter.getView());
            
            
            view.add(desktopPane, BorderLayout.CENTER);
            view.setMinimumSize(new Dimension(300, 300));
            view.pack();
            view.setVisible(true);
            view.setExtendedState(view.MAXIMIZED_BOTH);
            
            inserirDadoClimaPresenter.getView().getButtonIncluir().addActionListener((e) -> {
                try{
                    DadoClima dadoClima = inserirDadoClimaPresenter.incluir();
                    addDadoClima(dadoClima);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(view,"Erro na entrada dos dados: (Selecione um dado antes de remover clicando no botao) "+ ex);
                }
                
            });
            
            registrosDadoClimaPresenter.getView().getButtonRemover().addActionListener((e)->{
                try{
                    JTable tabela = registrosDadoClimaPresenter.getView().getTable();
                    removeDadoClima(tabela.getSelectedRow());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(view,"Erro ao excluir um Dado: " + ex);
                }
                
            });
            
            changeLogPresenter.getView().getButtonSalvar().addActionListener((e)->{
                log.setLogType(changeLogPresenter.getView().getComboBox().getSelectedItem().toString());
            });
            
        });
    }
    
    @Override
    public void atualizar(DadoClimaCollection dadosClima){
        maximasMinimasPresenter.atualizar(dadosClima);
        painelClimaPresenter.atualizar(dadosClima);
        estatisticaClimaPresenter.atualizar(dadosClima);
        
        registrosDadoClimaPresenter.atualizar(dadosClima);
    }
    
    private void addDadoClima(DadoClima dadoClima){
        dadosClima.add(dadoClima);
        log.makeLog(dadoClima, true);
        atualizar(dadosClima);
    }
    
    private void removeDadoClima(int id){        
        DadoClima dadoClima = dadosClima.get(id);
        dadosClima.remove(id);
        log.makeLog(dadoClima, false);
        atualizar(dadosClima);
    }
}
