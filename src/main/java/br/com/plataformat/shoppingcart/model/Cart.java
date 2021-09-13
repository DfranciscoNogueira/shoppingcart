package br.com.plataformat.shoppingcart.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cart {

    private Long id;
    
    private List<Item> itens;
    
    private List<Coupon> coupons;

    private double value;
    
    public Double getValueTotal(boolean applyCoupon) {
	
	this.value = Double.valueOf(0.0);
	
	if (Objects.isNull(this.itens) || this.itens.isEmpty()) {
	    return this.value;
	}
	
	this.itens.forEach(i -> this.value = (this.value += i.getTotalValue()));
	
	if (applyCoupon && Objects.nonNull(this.coupons) && !this.coupons.isEmpty()) {
	    double percentual = getMaxCoupon() / 100.0;
	    return this.value + (percentual * this.value);    
	}

	return this.value;
    }
    
    public Integer getMaxCoupon() {
	
	if (Objects.isNull(this.coupons) || this.coupons.isEmpty() || this.coupons.size() < 0) {
	    return 0;
	}
	
	return this.coupons.stream().max(Comparator.comparing(Coupon::getPercentageDiscount)).get().getPercentageDiscount();
    }
    
    public void addItem(Item item) {
	
	if (Objects.isNull(itens)) {
	    this.itens = new ArrayList<>();
	}
	
	if (Objects.nonNull(item)) {
	    this.itens.add(item);
	}
	
    }
    
    public void addCoupon(Coupon coupon) {
	
	if (Objects.isNull(coupons)) {
	    this.coupons = new ArrayList<>();
	}
	
	if (Objects.nonNull(coupon)) {
	    this.coupons.add(coupon);
	}
	
    }

    public Cart clearItem() {
	this.itens.clear();
	return this;
    }

}
