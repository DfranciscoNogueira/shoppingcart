package br.com.plataformat.shoppingcart.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.plataformat.shoppingcart.exception.EntityNotFoundException;
import br.com.plataformat.shoppingcart.model.Coupon;
import br.com.plataformat.shoppingcart.request.CouponCreateRequest;

@Service
public class CouponService {
    
    private static List<Coupon> coupons = new ArrayList<>();
    
    public CouponService() {
	coupons.add(Coupon.builder().id(1L).name("CUPOM5").percentageDiscount(5).build());
	coupons.add(Coupon.builder().id(2L).name("CUPOM10").percentageDiscount(10).build());
	coupons.add(Coupon.builder().id(3L).name("CUPOM15").percentageDiscount(15).build());
	coupons.add(Coupon.builder().id(4L).name("CUPOM20").percentageDiscount(20).build());
    }

    public List<Coupon> findAll() {
	return coupons;
    }

    public Coupon findById(Long id) throws EntityNotFoundException {

	Coupon coupon = coupons.stream().filter(p -> p.getId().equals(id)).collect(Collectors.toList()).get(0);

	if (Objects.nonNull(coupon)) {
	    return coupon;
	} else {
	    throw new EntityNotFoundException("Cupom não encotrado", null);
	}

    }

    public Coupon saveCoupon(CouponCreateRequest coupon) {
	Long newID = coupons.stream().max(Comparator.comparing(Coupon::getId)).get().getId() + 1;
	Coupon c = Coupon.builder().id(newID).name(coupon.getName()).percentageDiscount(coupon.getPercentageDiscount()).build();
	coupons.add(c);
	return c;
    }

}
