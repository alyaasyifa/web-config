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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siswa")
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nis", nullable = false)
    private String nis;

    @Column(name = "nama_siswa", nullable = false)
    private String namaSiswa;

    @CreatedBy
    private String createdby;

    @LastModifiedBy
    private String lastmodifiedby;

    @CreatedDate
    private String createddate;

    @LastModifiedDate
    private String lastmodifieddate;
}
