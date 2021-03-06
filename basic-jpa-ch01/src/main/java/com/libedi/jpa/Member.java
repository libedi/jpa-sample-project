package com.libedi.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Member entity class
 * @author PARK SANG JUN
 *
 */
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@ToString
public class Member {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String username;

	// 매핑정보가 없는 필드 : 필드명을 사용해서 컬럼명 매핑
	private Integer age;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE_TYPE")
	private RoleType roleType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	@Lob
	private String description;

	@Builder
	public Member(final String id, final String username, final Integer age) {
		this.id = id;
		this.username = username;
		this.age = age;
	}

}
