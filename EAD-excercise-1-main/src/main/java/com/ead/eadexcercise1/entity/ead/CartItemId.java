package com.ead.eadexcercise1.entity.ead;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CartItemId implements Serializable {
    private static final long serialVersionUID = 8426905756068306875L;
    @Column(name = "shopping_cart_id")
    private String shoppingCartId;
    @Column(name = "product_id")
    private String productId;
}
