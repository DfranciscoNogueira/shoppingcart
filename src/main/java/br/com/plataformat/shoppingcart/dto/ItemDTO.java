package br.com.plataformat.shoppingcart.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemDTO {
    
    @ApiModelProperty(value = "Produto")
    private ProductDTO product;
    
    @ApiModelProperty(value = "Quantidade do produto")
    private int qtd;

}
