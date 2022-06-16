package com.ead.eadexcercise1.entity.ead;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "ead_user")
//@SQLDelete(sql = "UPDATE ead_products SET status = true WHERE id = ?")
//@Where(clause = "status = false")
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    private String address;
//
//    private String phone;
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date dob;
//
//    private boolean status;
}
