/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Log;

import com.mycompany.dadosclimaticos.externalLogLibrary.LogXmlExterna;
import com.mycompany.dadosclimaticos.Model.DadoClima;

/**
 *
 * @author chris
 */
public class LogXmlAdapter implements ILog{
    //    Biblioteca de log
    private LogXmlExterna logLibrary;
    
    public LogXmlAdapter(){
        this.logLibrary = new LogXmlExterna();
    }

    @Override
    public String getLogMessage(DadoClima dadoClima, boolean added) {
        return logLibrary.getExternalMessageLog(dadoClima, added);
    }
    
}
