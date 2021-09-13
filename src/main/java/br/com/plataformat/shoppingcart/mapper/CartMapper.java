package br.com.plataformat.shoppingcart.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.plataformat.shoppingcart.dto.CartDTO;
import br.com.plataformat.shoppingcart.dto.ItemDTO;
import br.com.plataformat.shoppingcart.model.Cart;
import br.com.plataformat.shoppingcart.model.Item;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CartMapper {
    
    public CartDTO fromDto(Cart cart, boolean applyCoupon) {
	return CartDTO.builder()
		.id(cart.getId())
		.value(cart.getValueTotal(applyCoupon))
		.itens(fromItemDto(cart.getItens()))
		.build();
    }
    
    public List<ItemDTO> fromItemDto(List<Item> itens) {
	
	List<ItemDTO> toReturn = new ArrayList<>();
	
	if (Objects.isNull(itens) || itens.isEmpty()) {
	    return toReturn;
	}
	
	itens.forEach(i -> toReturn.add(ItemDTO.builder().qtd(i.getQtd()).product(ProductMapper.fromDto(i.getProduct())).build()));
	
	return toReturn;
    }
    
}
