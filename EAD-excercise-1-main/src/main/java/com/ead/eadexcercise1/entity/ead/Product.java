package com.ead.eadexcercise1.entity.ead;

import com.ead.eadexcercise1.entity.ead.base.BaseEntity;
import com.ead.eadexcercise1.entity.ead.enums.ProductSimpleStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "ead_products")
@SQLDelete(sql = "UPDATE ead_products SET status = true WHERE id = ?")
@Where(clause = "status = false")
public class Product extends BaseEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String slug;
    private int quantity;
    private String description;
    private String detail;
    private String thumbnail;
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    private ProductSimpleStatus status;

    public Product() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }
}
