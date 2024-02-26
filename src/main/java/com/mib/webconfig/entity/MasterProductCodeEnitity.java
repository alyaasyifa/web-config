package com.mib.webconfig.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")

public class MasterProductCodeEnitity {
    @Id
    @SequenceGenerator(name = "productSequence", sequenceName = "productSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
    private Long id;
    private String product_code;
    private String input_by;
    private Date input_date;
    private String modify_by;
    private Date mofify_date;
}
