/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.carpinteria.entity;

import com.jofrantoba.carpinteria.repository.ObjetoConexion;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JOFRANTOBA
 */
@Log4j2
public class TestObjetoConexion extends TestBaseEntity {

    @Test
    void Test1() {
        ObjetoConexion.conectarMYSQL();        
    }     
    
    
}
