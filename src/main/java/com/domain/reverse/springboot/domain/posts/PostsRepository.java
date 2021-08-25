package com.domain.reverse.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{    //<Entity 클래스, PK타입>, CRUD메소드 자동생성
}
