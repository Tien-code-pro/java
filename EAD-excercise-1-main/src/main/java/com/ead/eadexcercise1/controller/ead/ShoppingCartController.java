package com.ead.eadexcercise1.controller.ead;

import com.ead.eadexcercise1.dto.CartItemDTO;
import com.ead.eadexcercise1.dto.ProductDTO;
import com.ead.eadexcercise1.dto.ShoppingCartDTO;
import com.ead.eadexcercise1.entity.ead.CartItem;
import com.ead.eadexcercise1.entity.ead.CartItemId;
import com.ead.eadexcercise1.entity.ead.Product;
import com.ead.eadexcercise1.entity.ead.ShoppingCart;
import com.ead.eadexcercise1.repository.ead.ProductRepository;
import com.ead.eadexcercise1.repository.ead.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/ead-shopping-carts")
public class ShoppingCartController {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void saveCart(@RequestParam String userId,
                         @RequestBody ShoppingCartDTO shoppingCartDTO) {
        boolean hasException = false;
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .shipName(shoppingCartDTO.getShipName())
                .shipAddress(shoppingCartDTO.getShipAddress())
                .shipNote(shoppingCartDTO.getShipNote())
                .shipPhone(shoppingCartDTO.getShipPhone())
                .build();
        Set<CartItem> setCartItem = new HashSet<>();
        System.out.println(shoppingCart.getId());
        for (CartItemDTO cartItemDTO : shoppingCartDTO.getItems()) {
            Optional<Product> optionalProduct = productRepository.findById(cartItemDTO.getProductId());
            if (!optionalProduct.isPresent()) {
                hasException = true;
                break;
            }
            Product product = optionalProduct.get();
            CartItem cartItem = CartItem.builder()
                    .id(new CartItemId(shoppingCart.getId(), product.getId()))
                    .productName(product.getName())
                    .productImage(product.getThumbnail())
                    .quantity(cartItemDTO.getQuantity())
                    .unitPrice(product.getPrice())
                    .shoppingCart(shoppingCart)
                    .build();

            shoppingCart.addTotalPrice(cartItem);
            setCartItem.add(cartItem);
        }
        shoppingCart.setItems(setCartItem);
        shoppingCartRepository.save(shoppingCart);
    }
}
