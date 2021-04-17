package com.nicekkong.boot.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_member")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class TbMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String team;

    @Column
    private String empNo;

    @Column
    private LocalDateTime creDate;

    @Column
    private LocalDateTime updDate;
}
