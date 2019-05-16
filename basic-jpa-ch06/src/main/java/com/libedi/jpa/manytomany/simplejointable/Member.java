package com.libedi.jpa.manytomany.simplejointable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Member
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 10
 */
@Entity(name = "Member_ManyToMany")
@Table(name = "MEMBER_MANY")
@Getter @Setter
public class Member {

    @Id @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    /*
     * 다대다 관계를 테이블로 표현하려면 연결(매핑) 테이블이 필요하다.
     * JPA에서는 @ManyToMany로 매핑하면 이 연결 테이블을 신경쓰지 않아도 된다.
     */
    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",
            joinColumns = { @JoinColumn(name = "MEMBER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
    private final List<Product> products = new ArrayList<>();

    /*
     * 양방향 연관관계는 연관관계 편의 메서드를 추가해서 관리하는 것이 편리하다.
     */
    public void addProduct(Product product) {
        products.add(product);
        product.getMembers().add(this);
    }

}
