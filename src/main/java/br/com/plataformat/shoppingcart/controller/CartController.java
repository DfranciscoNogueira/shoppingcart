package br.com.plataformat.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.plataformat.shoppingcart.dto.CartDTO;
import br.com.plataformat.shoppingcart.exception.EntityNotFoundException;
import br.com.plataformat.shoppingcart.mapper.CartMapper;
import br.com.plataformat.shoppingcart.model.Cart;
import br.com.plataformat.shoppingcart.request.ProductRequest;
import br.com.plataformat.shoppingcart.service.CartService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o carrinho de compras na situação atual"),
	    		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @GetMapping(value = "/cart/{applyCoupon}", produces = "application/json")
    public ResponseEntity<CartDTO> viewCart(@PathVariable boolean applyCoupon) {
	Cart cart = this.cartService.findCart();
	return new ResponseEntity<>(CartMapper.fromDto(cart, applyCoupon), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Adiciona um produto ao carrinho de compras"),
	    		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @PostMapping(value = "/cart/product", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CartDTO> addProduct(@RequestBody ProductRequest product) throws EntityNotFoundException {
	Cart cart = this.cartService.addProduct(product);
	return new ResponseEntity<>(CartMapper.fromDto(cart, false), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Limpar o carrinho (remove todos os produtos)"),
	    		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @GetMapping(value = "/cart/clear", produces = "application/json")
    public ResponseEntity<CartDTO> clearCart() {
	Cart cart = this.cartService.clearCart();
	return new ResponseEntity<>(CartMapper.fromDto(cart, false), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Remove um produto do carrinho"),
	    		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @DeleteMapping(value = "/cart/remove/{id}", produces = "application/json")
    public ResponseEntity<CartDTO> removeProduct(@PathVariable Long id) {
	Cart cart = this.cartService.removeProduct(id);
	return new ResponseEntity<>(CartMapper.fromDto(cart, false), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Adiciona um cupom ao carrinho de compras"),
		    	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @PostMapping(value = "/cart/coupon/{idCoupon}", produces = "application/json")
    public ResponseEntity<CartDTO> addDiscountCoupon(@PathVariable Integer idCoupon) throws EntityNotFoundException {
	Cart cart = this.cartService.addDiscountCoupon(idCoupon.longValue());
	return new ResponseEntity<>(CartMapper.fromDto(cart, false), HttpStatus.OK);
    }
    
}
