package br.com.plataformat.shoppingcart.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformat.shoppingcart.exception.EntityNotFoundException;
import br.com.plataformat.shoppingcart.model.Cart;
import br.com.plataformat.shoppingcart.model.Coupon;
import br.com.plataformat.shoppingcart.model.Item;
import br.com.plataformat.shoppingcart.model.Product;
import br.com.plataformat.shoppingcart.request.ProductRequest;

@Service
public class CartService {
    
    private static Cart cart = Cart.builder().id(1L).build();
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CouponService couponService;
    
    public Cart findCart() {
	return cart;
    }
    
    public Cart addProduct(ProductRequest request) throws EntityNotFoundException {
	Product product = this.productService.findById(request.getIdProduct());
	int qtd = request.getQtd() > 0 ? request.getQtd() : 1; 
	Item item = Item.builder().product(product).qtd(qtd).build();
	cart.addItem(item);
	return cart;
    }

    public Cart clearCart() {
	return cart.clearItem();
    }

    public Cart removeProduct(Long id) {
	Iterator<Item> i = cart.getItens().iterator();
	while(i.hasNext()){
	    if(i.next().getProduct().getId().equals(id)){
	        i.remove();
	    }
	}
	return cart;
    }

    public Cart addDiscountCoupon(Long idCoupon) throws EntityNotFoundException {
	Coupon coupon = this.couponService.findById(idCoupon);
	cart.addCoupon(coupon);
	return cart;
    }

}
