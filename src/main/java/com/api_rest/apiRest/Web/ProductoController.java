/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api_rest.apiRest.Web;

import com.api_rest.apiRest.Dto.ProductoDTO;
import com.api_rest.apiRest.Services.Impl.IntrProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario UTP
 */
@RestController
@RequestMapping("${api.base.url}/producto")
public class ProductoController {
    
    @Autowired
    IntrProductoService productoService;
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductoDTO producto){
     
        producto = productoService.save(producto);
        
        if(producto == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(producto);
        
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id){
        
        ProductoDTO producto = productoService.getOne(id);
        
        if(producto == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(producto);
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        List<ProductoDTO> lista = productoService.getAll();
        
        if(lista == null || lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(lista);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        
        ProductoDTO producto = productoService.getOne(id);
        
        if(producto == null){
            return ResponseEntity.ok(false);
        }
        
        productoService.delete(producto.getId());
        return ResponseEntity.ok(true);
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductoDTO producto){
        
        ProductoDTO consulta = productoService.getOne(producto.getId());
        
        if(consulta == null){
            return ResponseEntity.notFound().build();
        }
        consulta = productoService.save(producto);
        
        if(consulta == null){
            
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(consulta);
    }
    
}
