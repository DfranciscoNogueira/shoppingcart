package br.com.plataformat.shoppingcart.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartDTO {

    @ApiModelProperty(value = "Id do Carrinho")
    private Long id;

    @ApiModelProperty(value = "Itens do carrinho")
    private List<ItemDTO> itens;

    @ApiModelProperty(value = "Valor dos produtos")
    private Double value;

}
