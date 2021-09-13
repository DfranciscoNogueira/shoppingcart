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

import br.com.plataformat.shoppingcart.dto.CouponDTO;
import br.com.plataformat.shoppingcart.exception.EntityNotFoundException;
import br.com.plataformat.shoppingcart.mapper.CouponMapper;
import br.com.plataformat.shoppingcart.model.Coupon;
import br.com.plataformat.shoppingcart.request.CouponCreateRequest;
import br.com.plataformat.shoppingcart.service.CouponService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class CouponController {

    @Autowired
    private CouponService couponService;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o lista de cupons"),
	    	            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    	            @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @GetMapping(value = "/coupon", produces = "application/json")
    public ResponseEntity<List<CouponDTO>> getCoupon() {
	List<Coupon> coupons = this.couponService.findAll();
	return new ResponseEntity<>(CouponMapper.fromDto(coupons), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o cupom pelo id informado"),
	            	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	            	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @GetMapping(value = "/coupon/{id}", produces = "application/json")
    public ResponseEntity<CouponDTO> findById(@PathVariable Long id) throws EntityNotFoundException {
	Coupon coupon = this.couponService.findById(id);
	return new ResponseEntity<>(CouponMapper.fromDto(coupon), HttpStatus.OK);
    }
    
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Cria um novo cupom"),
		    	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
    @PostMapping(value = "/coupon", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CouponDTO> addCoupon(@RequestBody CouponCreateRequest coupon) {
	Coupon p = this.couponService.saveCoupon(coupon);
	return new ResponseEntity<>(CouponMapper.fromDto(p), HttpStatus.OK);
    }

}
