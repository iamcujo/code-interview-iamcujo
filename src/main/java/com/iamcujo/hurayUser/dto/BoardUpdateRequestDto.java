package com.iamcujo.hurayUser.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
 
    private String name;
    private String created_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
 
    @Builder
    public BoardUpdateRequestDto(String name, String created_date) {
        this.name = name;
        this.created_date = created_date;
    }
}