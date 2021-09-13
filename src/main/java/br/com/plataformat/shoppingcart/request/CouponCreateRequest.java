package br.com.plataformat.shoppingcart.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CouponCreateRequest {
    
    @ApiModelProperty(value = "Nome do Cupom")
    private String name;

    @ApiModelProperty(value = "Porcentagem do desconto")
    private Integer percentageDiscount;

}
