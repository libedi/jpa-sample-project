package com.libedi.jpa.mappedsuperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Seller
 *
 * @author Sang-jun, Park
 * @since 2019. 05. 20
 */
@Entity
@AttributeOverrides({       // 둘 이상 재정의
    @AttributeOverride(name = "id", column = @Column(name = "SELLER_ID")),
    @AttributeOverride(name = "name", column = @Column(name = "SELLER_NAME"))
})
@Getter @Setter
public class Seller extends BaseEntity {

    // ID 상속
    // NAME 상속
    private String shopName;
}
