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
@Table(name = "jurusan")
public class Jurusan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kode_jurusan", nullable = false)
    private String kodeJurusan;

    @Column(name = "nama_jurusan", nullable = false)
    private String namaJurusan;

    @CreatedBy
    private String createdby;

    @LastModifiedBy
    private String lastmodifiedby;

    @CreatedDate
    private String createddate;

    @LastModifiedDate
    private String lastmodifieddate;
}
