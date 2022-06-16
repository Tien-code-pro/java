package com.ead.eadexcercise1.dto;

import com.ead.eadexcercise1.entity.ead.ShoppingCart;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCartDTO {
    private String id;
    private String userId; // ai tạo
    private BigDecimal totalPrice;
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private String shipNote;
    private Set<CartItemDTO> items;

    public ShoppingCart generateCart(){
        return new ShoppingCart();
    }
}
