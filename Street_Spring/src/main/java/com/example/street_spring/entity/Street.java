package com.example.street_spring.entity;

import com.example.street_spring.entity.enums.StreetSimpleStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "streets")
public class Street{
    @Id
    private String id;
    private String name;
    private String description;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @Enumerated(EnumType.ORDINAL)
    private StreetSimpleStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "districtId")
    private District district;

}
