/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api_rest.apiRest.Services.Impl;

import com.api_rest.apiRest.Dto.ProductoDTO;
import java.util.List;

/**
 *
 * @author Usuario UTP
 */
public interface IntrProductoService {
    
    public ProductoDTO save(ProductoDTO dto);
    
    public ProductoDTO getOne(Long id);
    
    public List<ProductoDTO> getAll();
    
    public boolean delete(Long id);
    
    
}
