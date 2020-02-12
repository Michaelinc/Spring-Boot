/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api_rest.apiRest.Repository;

import com.api_rest.apiRest.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario UTP
 */
@Repository
public interface IntrProductoRepository extends JpaRepository<Producto, Long>{
    
}
