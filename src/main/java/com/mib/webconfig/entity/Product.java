package com.mib.webconfig.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agregator_name", nullable = false)
    private String agregatorName;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "fee", nullable = false)
    private String fee;

    @Column(name = "input_by")
    private String inputBy;

    @Column(name = "input_date")
    private LocalDateTime inputDate;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;
}
