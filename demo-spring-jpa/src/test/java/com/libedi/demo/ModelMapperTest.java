package com.libedi.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ModelMapperTest {

	private ModelMapper modelMapper;

	@Getter @Setter
	@Builder
	static class User {
		private String name;
		private String address;
	}

	@Getter @Setter
	static class UserDto {
		private String userNm;
		private String userAddr;
	}

	@Before
	public void before() {
		modelMapper = new ModelMapper();
	}

	@Test
	public void testNoTypeMap() {
		User user = User.builder().name("nam1").address("addr1").build();
		UserDto dto = modelMapper.map(user, UserDto.class);
		assertNull(dto.getUserNm());
		assertNull(dto.getUserAddr());
	}

	@Test
	public void testTypeMap() {
		final TypeMap<User, UserDto> typeMap = modelMapper.createTypeMap(User.class, UserDto.class);
		typeMap.addMappings(mapper -> mapper.map(User::getName, UserDto::setUserNm))
			.addMappings(mapper -> mapper.map(User::getAddress, UserDto::setUserAddr))
		;
		User user = User.builder().name("nam1").address("addr1").build();
		UserDto dto = modelMapper.map(user, UserDto.class);
		assertEquals(user.getName(), dto.getUserNm());
		assertEquals(user.getAddress(), dto.getUserAddr());
	}

}
