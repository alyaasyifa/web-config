package com.mib.webconfig.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "multibiller")
    public class Multibiller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "prefix", nullable = false)
    private String prefix;

    @Column(name = "fee", nullable = false)
    private String fee;


    @Column(name = " destination_account", nullable = false)
    private String destinationAccount;

    @Column(name = "fee_account", nullable = false)
    private String feeAccount;

    @CreatedBy
    private String createdby;

    @LastModifiedBy
    private String lastmodifiedby;

    @CreatedDate
    private String createddate;

    @LastModifiedDate
    private String lastmodifieddate;

}



