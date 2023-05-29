/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Log;

import com.mycompany.dadosclimaticos.Model.DadoClima;
import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author chris
 */
public class LogXmlExterna {        
        public LogXmlExterna(){
        }
        
        public String getExternalMessageLog(DadoClima dadoClima, boolean added){
            return createXML(dadoClima, added);
        }
            
        private String createXML(DadoClima dadoClima, boolean added){
        XStream xstream = new XStream();
        xstream.alias("DadoClima", DadoClima.class);
        String xml = xstream.toXML(dadoClima);
        if(added){
            xml = xml.replace("<DadoClima", "<DadoClima action=\"added\"");
        }
        else{
            xml = xml.replace("<DadoClima", "<DadoClima action=\"removed\"");
        }
        return xml;
    }
        
}