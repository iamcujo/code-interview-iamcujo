package com.iamcujo.hurayUser.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamcujo.hurayUser.dto.BoardResponseDto;
import com.iamcujo.hurayUser.dto.BoardSaveRequestDto;
import com.iamcujo.hurayUser.dto.BoardUpdateRequestDto;
import com.iamcujo.hurayUser.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {
 
    private final BoardService boardService;
 
    /* user - 목록 조회  */
    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<BoardResponseDto>> findAll() {
 
        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();
 
        return new ResponseEntity<List<BoardResponseDto>>(boardResponseDtoList, HttpStatus.OK);
    }
 
    /* user - 상세 조회 */
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BoardResponseDto> findById(@PathVariable("id") Long id) {
 
        BoardResponseDto boardResponseDto = boardService.findById(id);
 
        return new ResponseEntity<BoardResponseDto>(boardResponseDto, HttpStatus.OK);
    }
 
    /* user - 등록 */
    @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> save(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {
 
        Long savedId = boardService.save(boardSaveRequestDto);
 
        return new ResponseEntity<Long>(savedId, HttpStatus.CREATED);
    }
 
    /* user - 수정 */
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> update(@PathVariable("id") Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
 
        Long updatedId = boardService.update(id, boardUpdateRequestDto);
 
        return new ResponseEntity<Long>(updatedId, HttpStatus.CREATED);
    }
 
    /* user - 삭제 */
    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
 
        boardService.delete(id);
 
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }
}
