package com.example.batch.dto;

import com.example.batch.repository.entity.Coffee;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor // 생성자에서 모든 필드를 초기화하는 생성자
@NoArgsConstructor  // 기본 생성자
@Builder            // 빌더 패턴을 위한 어노테이션
public class CoffeeDto {

    // 커피 아이디
    private Long coffee_id;

    // 브랜드 정보
    private String brand;

    // 원산지 정보
    private String origin;

    // 특징 정보
    private String characteristics;

    // 가공 방식 정보
    private String processed;

    public static CoffeeDto toCoffeeDto(Coffee coffee) {
        CoffeeDto coffeeDto = new CoffeeDto();

        // Coffee 객체의 데이터를 CoffeeDto로 변환하여 설정
        coffeeDto.setCoffee_id(coffee.getCoffee_id());
        coffeeDto.setBrand(coffee.getBrand());
        coffeeDto.setOrigin(coffee.getOrigin());
        coffeeDto.setCharacteristics(coffee.getCharacteristics());
        coffeeDto.setProcessed(coffee.getProcessed());

        return coffeeDto;
    }
}
