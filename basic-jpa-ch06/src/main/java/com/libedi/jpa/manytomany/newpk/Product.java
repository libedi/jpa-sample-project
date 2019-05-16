package com.libedi.jpa.manytomany.newpk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Product
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 10
 */
@Entity(name = "Product_ManyToMany_newPk")
@Getter @Setter
public class Product {

    @Id @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    /*
     * 연결 엔티티를 사용하므로,
     * 상품 엔티티에서 회원상품 엔티티로 객체 그래프 탐색기능이 필요하지 않다고 판단하여
     * 연관관계를 만들지 않아다.
     */
//    @ManyToMany(mappedBy = "products")  // 역방향 추가
//    private List<Member> members = new ArrayList<>();

}
