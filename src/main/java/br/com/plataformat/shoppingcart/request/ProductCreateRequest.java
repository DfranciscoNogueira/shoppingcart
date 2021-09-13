package br.com.plataformat.shoppingcart.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCreateRequest {
    
    @ApiModelProperty(value = "Nome do Produto")
    private String name;

    @ApiModelProperty(value = "Valor do Produto")
    private Double value;

}
