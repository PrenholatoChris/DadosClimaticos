/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mycompany.dadosclimaticos.Model.DadoClima;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author chris
 */
public class LogJson implements ILog{
    
    public LogJson(){
    }
    
    
        @Override
        public String getLogMessage(DadoClima dadoClima, boolean added){
            DadoClimaJson dadoJson = new DadoClimaJson(dadoClima, added);
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                    .create();
            
//                    new Gson();
                    

            String json = gson.toJson(dadoJson);

            return json;        
        }
}

 

class LocalDateSerializer implements JsonSerializer<LocalDate> {
    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        String formattedDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return new JsonPrimitive(formattedDate);
    }
}

class DadoClimaJson extends DadoClima{
    private String action;
    
    public DadoClimaJson(DadoClima dadoClima, boolean added){
        super(dadoClima.getTemperatura(), dadoClima.getUmidade(), dadoClima.getPressao(), dadoClima.getData());
        if(added == true)
            action = "added";
        else
            this.action = "removed";
    }
}