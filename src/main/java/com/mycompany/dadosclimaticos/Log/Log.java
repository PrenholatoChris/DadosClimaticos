/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Log;

//import com.google.gson.Gson;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import java.io.*;


/**
 *
 * @author chris
 */
public class Log{
    private static File file;
    private String type;
    
    private LogJson logJson;
    private LogXmlAdapter logXml;
    
    
    public Log(){
        logJson = new LogJson();
        logXml = new LogXmlAdapter();
        
        setLogType("xml");
    }
    
    public void setLogType(String type){
        this.type = type;
    }
    
    
    public void makeLog(DadoClima dadoClima, boolean added){
        String content;
        if(type.equals("xml")){
            content = logXml.getLogMessage(dadoClima, added);
        }else{
            content = logJson.getLogMessage(dadoClima, added);
        }
            
        try{
            appendToFile(content);
        }catch (IOException e){
            System.out.println(e);
        }
    }
    
    private void appendToFile(String text) throws IOException{
        file = new File("C:\\log\\DadosClimaLog." + type);
        BufferedWriter bw;
        if(!file.exists()){
            file.createNewFile();
        }
        bw = new BufferedWriter(new FileWriter(file, true));

        bw.write(text);
        bw.newLine();

        bw.close();
    }

    
    
    

}
