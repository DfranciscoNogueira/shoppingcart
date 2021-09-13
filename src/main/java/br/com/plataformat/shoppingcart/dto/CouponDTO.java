package br.com.plataformat.shoppingcart.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CouponDTO {
    
    @ApiModelProperty(value = "Id do cupom")
    private Long id;
    
    @ApiModelProperty(value = "Nome do cupom")
    private String name;

    @ApiModelProperty(value = "Porcentagem do desconto")
    private int percentageDiscount;

}
