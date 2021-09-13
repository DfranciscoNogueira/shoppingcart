package br.com.plataformat.shoppingcart.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequest {
    
    @ApiModelProperty(value = "Id do Produto")
    private Long idProduct;
    
    @ApiModelProperty(value = "Quantidade do Produto")
    private int qtd;

}
