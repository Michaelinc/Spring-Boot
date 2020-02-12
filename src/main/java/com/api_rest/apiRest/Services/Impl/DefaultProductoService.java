/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api_rest.apiRest.Services.Impl;

import com.api_rest.apiRest.Dto.ProductoDTO;
import com.api_rest.apiRest.Entity.Producto;
import com.api_rest.apiRest.Repository.IntrProductoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario UTP
 */
@Service
public class DefaultProductoService implements IntrProductoService{
    
    @Autowired
    IntrProductoRepository productoRepository;
    
    @Autowired
    ModelMapper mapper;
    

    @Override
    public ProductoDTO save(ProductoDTO dto) {
        Producto producto = productoRepository.save(mapper.map(dto, Producto.class));
        
        if(producto == null){
            return null;
        }
        return mapper.map(producto, ProductoDTO.class);
    }

    @Override
    public ProductoDTO getOne(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        
        if(producto.isPresent()){
            return mapper.map(producto, ProductoDTO.class);
        }
        
        return null;
    }

    @Override
    public List<ProductoDTO> getAll() {
        List<Producto> lista = productoRepository.findAll();
        List<ProductoDTO> respuesta = new ArrayList<>();
        
        if(lista == null || lista.isEmpty()){
            return null;
        }
        
        for(Producto prod : lista){
            respuesta.add(mapper.map(prod, ProductoDTO.class));
        }
        return respuesta;
    }

    @Override
    public boolean delete(Long id) {
        Producto producto = productoRepository.getOne(id);
        
        if(producto == null){
            return false;
        }
        
        return true;
    }
    
}
