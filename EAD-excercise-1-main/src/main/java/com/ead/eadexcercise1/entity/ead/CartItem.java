package com.ead.eadexcercise1.entity.ead;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ead_cart_item")
public class CartItem {
    @EmbeddedId
    private CartItemId id;
    private String productName;
    private String productImage;
    private int quantity;
    private BigDecimal unitPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("shoppingCartId")
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
}
