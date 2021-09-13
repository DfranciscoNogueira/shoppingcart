package br.com.plataformat.shoppingcart.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {
    
    private Product product;
    private int qtd;
    
    public double getTotalValue() {
	return this.product.getValue() * this.qtd;
    }

}
