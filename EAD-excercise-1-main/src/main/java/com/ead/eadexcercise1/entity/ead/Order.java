package com.ead.eadexcercise1.entity.ead;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ead.eadexcercise1.entity.ead.base.BaseEntity;
import com.ead.eadexcercise1.entity.ead.enums.OrderSimpleStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ead_orders")
public class Order extends BaseEntity {
    @Id
    private String id;

    private String userId;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.ORDINAL)
    private OrderSimpleStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<OrderDetail> orderDetailSet;

    @PostPersist
    public void updateSlug() {
        System.out.println("After save");
        System.out.println(id);
    }

    @PostUpdate
    private void afterSave() {
        System.out.println("After Save");
        System.out.println(id);
    }

    public void addTotalPrice(OrderDetail orderDetail) {
        if (this.totalPrice == null) {
            this.totalPrice = new BigDecimal(0);
        }
        BigDecimal quantityInBigDecimal = new BigDecimal(orderDetail.getQuantity());
        this.totalPrice = this.totalPrice.add(
                orderDetail.getUnitPrice().multiply(quantityInBigDecimal));
    }
}
