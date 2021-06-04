package com.iamcujo.hurayUser.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iamcujo.hurayUser.domain.Board;
import com.iamcujo.hurayUser.dto.BoardResponseDto;
import com.iamcujo.hurayUser.dto.BoardSaveRequestDto;
import com.iamcujo.hurayUser.dto.BoardUpdateRequestDto;
import com.iamcujo.hurayUser.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
 
    private final BoardRepository boardRepository;
 
    /* user - 목록 조회 */
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {
        
        return boardRepository.findAll()
                              .stream()
                              .map(BoardResponseDto::new)
                              .collect(Collectors.toList());
    }
 
    /* user - 상세 조회 */
    @Transactional(readOnly = true)
    public BoardResponseDto findById(Long id) {
 
        Board board = boardRepository.findById(id)
                                     .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 user가 존재하지 않습니다."));
 
        return new BoardResponseDto(board);
    }
 
    /* user - 등록 */
    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto) {
 
        return boardRepository.save(boardSaveRequestDto.toEntity())
                              .getId();
    }
 
    /* user - 수정 */
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
 
        Board board = boardRepository.findById(id)
                                     .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 user가 존재하지 않습니다."));
 
        board.update(boardUpdateRequestDto.getName(), boardUpdateRequestDto.getCreated_date());
 
        return id;
    }
 
    /* user - 삭제 */
    @Transactional
    public void delete(Long id) {
 
        Board board = boardRepository.findById(id)
                                     .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 user가 존재하지 않습니다."));
 
        boardRepository.delete(board);
    }
}