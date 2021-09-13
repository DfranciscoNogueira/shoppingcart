package br.com.plataformat.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.plataformat.shoppingcart.dto.ProductDTO;
import br.com.plataformat.shoppingcart.exception.EntityNotFoundException;
import br.com.plataformat.shoppingcart.mapper.ProductMapper;
import br.com.plataformat.shoppingcart.model.Product;
import br.com.plataformat.shoppingcart.request.ProductCreateRequest;
import br.com.plataformat.shoppingcart.service.ProductService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o lista de produtos"),
	    	            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    	            @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @GetMapping(value = "/product", produces = "application/json")
    public ResponseEntity<List<ProductDTO>> getProduct() {
	List<Product> products = this.productService.findAll();
	return new ResponseEntity<>(ProductMapper.fromDto(products), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o produto pelo id informado"),
	            	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	            	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @GetMapping(value = "/product/{id}", produces = "application/json")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) throws EntityNotFoundException {
	Product product = this.productService.findById(id);
	return new ResponseEntity<>(ProductMapper.fromDto(product), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Cria um novo produto"),
		    	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @PostMapping(value = "/product", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductCreateRequest product) {
	Product p = this.productService.saveProduct(product);
	return new ResponseEntity<>(ProductMapper.fromDto(p), HttpStatus.OK);
    }

}
