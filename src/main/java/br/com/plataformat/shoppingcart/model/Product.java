package br.com.plataformat.shoppingcart.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {

    private Long id;

    private String name;

    private Double value;

}
