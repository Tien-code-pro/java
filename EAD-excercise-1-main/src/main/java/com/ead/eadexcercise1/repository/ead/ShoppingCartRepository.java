package com.ead.eadexcercise1.repository.ead;

import com.ead.eadexcercise1.entity.ead.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
}
