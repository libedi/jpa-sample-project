package com.libedi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * JPA 기본 테스트
 * @author PARK SANG JUN
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBasicJpa {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void init() {
		// JPA 기본설정파일인  persistence.xml에서 읽어온다.
		emf = Persistence.createEntityManagerFactory("jpatest");
		em = emf.createEntityManager();
	}
	
	@After
	public void last() {
		em.close();
		emf.close();
	}
	
	/**
	 * Ch.01
	 * @throws Exception
	 */
	@Test
	public void ch01_testBasicJpa() throws Exception {
		final EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			//-- 비즈니스 로직 시작
			final String id = "id1";
			final Member member = Member.builder()
					.id(id)
					.username("상준")
					.age(37)
					.build();
			
			// 등록
			em.persist(member);
			
			// 수정
			member.setAge(27);
			
			// 한건 조회
			final Member findMember = em.find(Member.class, id);
			System.out.println(findMember.toString());
			
			// 목록 조회
			final List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
			System.out.println("members.size = " + members.size());
			
			// 삭제
			em.remove(member);
			
			//-- 비즈니스 로직 종료
			tx.commit();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
	}
	
	@Test
	public void ch04_testEntityMapping() throws Exception {
		
	}
}
