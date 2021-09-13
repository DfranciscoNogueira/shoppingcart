package br.com.plataformat.shoppingcart.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.plataformat.shoppingcart.exception.EntityNotFoundException;
import br.com.plataformat.shoppingcart.model.Product;
import br.com.plataformat.shoppingcart.request.ProductCreateRequest;

@Service
public class ProductService {
    
    private static List<Product> products = new ArrayList<Product>();
    
    public ProductService() {
	products.add(Product.builder().id(1L).name("Fone de Ouvido").value(200.00).build());
	products.add(Product.builder().id(2L).name("Pen Drive").value(150.00).build());
	products.add(Product.builder().id(3L).name("Mouse").value(80.00).build());
	products.add(Product.builder().id(4L).name("Monitor Led - 32pl").value(1000.00).build());
	products.add(Product.builder().id(5L).name("Cabo HDMI").value(50.00).build());
	products.add(Product.builder().id(6L).name("Teclado Mecanico").value(230.00).build());
	products.add(Product.builder().id(7L).name("Cadeira De Escritório").value(849.00).build());
	products.add(Product.builder().id(8L).name("Caixa de Tomada 7 Blocos para Mesa").value(99.00).build());
	products.add(Product.builder().id(9L).name("Suporte Notebook Laptop").value(500.00).build());
	products.add(Product.builder().id(10L).name("Quadros decorativos").value(360.00).build());
    }

    public List<Product> findAll() {
	return products;
    }

    public Product findById(Long id) throws EntityNotFoundException {

	Product product = products.stream().filter(p -> p.getId().equals(id)).collect(Collectors.toList()).get(0);

	if (Objects.nonNull(product)) {
	    return product;
	} else {
	    throw new EntityNotFoundException("Produto não encotrado", null);
	}

    }

    public Product saveProduct(ProductCreateRequest product) {
	Long newID = products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
	Product p = Product.builder().id(newID).name(product.getName()).value(product.getValue()).build();
	products.add(p);
	return p;
    }

}
