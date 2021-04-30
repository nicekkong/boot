package com.nicekkong.boot.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_OPTION")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable=false)
    private Product product;
}
