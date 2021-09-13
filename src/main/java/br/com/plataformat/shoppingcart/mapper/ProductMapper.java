package br.com.plataformat.shoppingcart.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.plataformat.shoppingcart.dto.ProductDTO;
import br.com.plataformat.shoppingcart.model.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {
    
    public ProductDTO fromDto(Product product) {
	return ProductDTO.builder()
		.id(product.getId())
		.name(product.getName())
		.value(product.getValue())
		.build();
    }
    
    public List<ProductDTO> fromDto(List<Product> products) {
	List<ProductDTO> toReturn = new ArrayList<>();
	products.forEach(p -> toReturn.add(fromDto(p)));
	return toReturn;
    }
    
}
