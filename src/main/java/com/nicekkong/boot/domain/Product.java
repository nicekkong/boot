package com.nicekkong.boot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Integer price;

    private String shopName;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ProductOption> options = new ArrayList<>();
}
