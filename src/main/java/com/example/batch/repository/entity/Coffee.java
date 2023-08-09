package com.example.batch.repository.entity;

import com.example.batch.dto.CoffeeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Coffee {

	// 커피 아이디(primary key)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coffee_id;

	// 브랜드 정보
	@Column
	private String brand;

	// 원산지 정보
	@Column
	private String origin;

	// 특징 정보
	@Column
	private String characteristics;

	// 가공 방식 정보
	@Column
	private String processed;

	// 기본 생성자
	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	// CoffeeDto 객체를 Coffee 엔티티로 변환하는 정적 메서드
	public static Coffee toCoffee(CoffeeDto coffeeDto) {
		Coffee coffee = new Coffee();

		// CoffeeDto의 데이터를 Coffee 엔티티로 설정
		coffee.setBrand(coffeeDto.getBrand());
		coffee.setOrigin(coffeeDto.getOrigin());
		coffee.setCharacteristics(coffeeDto.getCharacteristics());
		coffee.setProcessed(coffeeDto.getProcessed());

		return coffee;
	}
}
