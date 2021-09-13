package br.com.plataformat.shoppingcart.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.plataformat.shoppingcart.dto.CouponDTO;
import br.com.plataformat.shoppingcart.model.Coupon;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CouponMapper {
    
    public CouponDTO fromDto(Coupon coupon) {
	return CouponDTO.builder()
		.id(coupon.getId())
		.name(coupon.getName())
		.percentageDiscount(coupon.getPercentageDiscount())
		.build();
    }
    
    public List<CouponDTO> fromDto(List<Coupon> coupons) {
	List<CouponDTO> toReturn = new ArrayList<>();
	coupons.forEach(c -> toReturn.add(fromDto(c)));
	return toReturn;
    }
    
}
