package com.example.jwtprotice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtprotice.entity.UserEntity;


// https://www.youtube.com/watch?v=JFTpzy7gsg0&list=PLJkjrxxiBSFCcOjy0AAVGNtIa08VLk1EJ&index=5
// 참고 자료
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    

    Boolean existsByUsername(String username);
		
		//username을 받아 DB 테이블에서 회원을 조회하는 메소드 작성
    UserEntity findByUsername(String username);

}
