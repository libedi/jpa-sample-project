package com.libedi.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Member entity class
 * @author PARK SANG JUN
 *
 */
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @ToString
public class Member {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String username;
	
	// 매핑정보가 없는 필드 : 필드명을 사용해서 컬럼명 매핑
	private Integer age;

	@Builder
	public Member(final String id, final String username, final Integer age) {
		this.id = id;
		this.username = username;
		this.age = age;
	}
	
	public void setAge(final Integer age) {
		this.age = age;
	}
	
}
