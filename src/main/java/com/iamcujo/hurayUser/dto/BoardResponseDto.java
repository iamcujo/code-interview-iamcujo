package com.iamcujo.hurayUser.dto;

import com.iamcujo.hurayUser.domain.Board;

import lombok.Getter;

@Getter
public class BoardResponseDto {
 
    private Long id;
    private String name;
    private String created_date;
 
    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.name = board.getName();
        this.created_date = board.getCreated_date();
    }
}
