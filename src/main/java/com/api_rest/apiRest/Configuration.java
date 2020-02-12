/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api_rest.apiRest;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Usuario UTP
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    
    @Bean
    public ModelMapper ModelMapper(){
        return new ModelMapper();
    }
}
