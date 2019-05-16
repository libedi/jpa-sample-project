package com.libedi.jpa.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Product
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 10
 */
@Entity
@Getter @Setter
public class Product {

    @Id @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "products")  // 역방향 추가
    private List<Member> members = new ArrayList<>();

}
