package br.com.plataformat.shoppingcart.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {

    @ApiModelProperty(value = "Id do Produto")
    private Long id;

    @ApiModelProperty(value = "Nome do Produto")
    private String name;

    @ApiModelProperty(value = "Valor do Produto")
    private Double value;

}
