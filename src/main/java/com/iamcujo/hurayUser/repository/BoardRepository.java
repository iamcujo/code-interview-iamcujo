package com.iamcujo.hurayUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamcujo.hurayUser.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
