/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dadosclimaticos.Log;

import com.mycompany.dadosclimaticos.Model.DadoClima;

/**
 *
 * @author chris
 */
public interface ILog {
    String getLogMessage(DadoClima dadoClima, boolean added);
}
