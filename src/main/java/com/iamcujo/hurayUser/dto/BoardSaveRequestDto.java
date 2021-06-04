package com.iamcujo.hurayUser.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.iamcujo.hurayUser.domain.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
 
    private String name;
    private String created_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

    @Builder
    public BoardSaveRequestDto(String name, String created_date) {
        this.name = name;
        this.created_date = created_date;
    }
 
    public Board toEntity() {
        return Board.builder()
                    .name(name)
                    .created_date(created_date)
                    .build();
    }
}

