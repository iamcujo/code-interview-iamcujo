package com.iamcujo.hurayUser.controller;

//import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.iamcujo.hurayUser.domain.Board;
import com.iamcujo.hurayUser.dto.BoardSaveRequestDto;
import com.iamcujo.hurayUser.dto.BoardUpdateRequestDto;
import com.iamcujo.hurayUser.repository.BoardRepository;

@RunWith(Suite.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {
 
    @LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
 
    @Autowired
    private BoardRepository boardRepository;
 
    @Test
    public void findAll() throws Exception {
 
        String url = "http://localhost:" + port + "/api/board";
 
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
 
        assertThat(responseEntity, equalTo(HttpStatus.OK));
        assertThat(responseEntity, is("id"));
        assertThat(responseEntity, is("name"));
        assertThat(responseEntity, is("created_date"));
        
    }
 
    @Test
    public void findById() throws Exception {
 
        Long id = 1L;
 
        String url = "http://localhost:" + port + "/api/board/" + id;
 
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
 
        assertThat(responseEntity, equalTo(HttpStatus.OK));
        assertThat(responseEntity, is("id"));
        assertThat(responseEntity, is("name"));
        assertThat(responseEntity, is("created_date"));
    }
 
    @Test
    public void save() throws Exception {
 
        String name = "홍길동";
 
        BoardSaveRequestDto boardSaveRequestDto = BoardSaveRequestDto.builder()
                                                                     .name(name)
                                                                     .build();
 
        String url = "http://localhost:" + port + "/api/board";
 
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, boardSaveRequestDto, Long.class);
 
        assertThat(responseEntity, equalTo(HttpStatus.CREATED));
 
        List<Board> boardList = boardRepository.findAll();
        Board board = boardList.get(boardList.size() - 1);
        
        assertThat(board.getName(), is("name"));
        assertThat(board.getCreated_date(), is("created_date"));
    }
 
    @Test
    public void update() throws Exception {
 
        String name = "추호년";
 
        Board saveBoard = boardRepository.save(Board.builder()
                                                    .name(name)
                                                    .build());
 
        Long id = saveBoard.getId();
        String updatedName = "홍길동";
 
        BoardUpdateRequestDto boardUpdateRequestDto = BoardUpdateRequestDto.builder()
                                                                           .name(updatedName)
                                                                           .build();
 
        String url = "http://localhost:" + port + "/api/board/" + id;
 
        HttpEntity<BoardUpdateRequestDto> requestEntity = new HttpEntity<>(boardUpdateRequestDto);
 
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
 
        assertThat(responseEntity, equalTo(HttpStatus.CREATED));
 
        List<Board> boardList = boardRepository.findAll();
        Board board = boardList.get(boardList.size() - 1);

        assertThat(board.getName(), is("name"));
        assertThat(board.getCreated_date(), is("created_date"));
        
    }
 
    @Test
    public void delete() throws Exception {
 
        String name = "추호년";
 
        Board saveBoard = boardRepository.save(Board.builder()
                                                    .name(name)
                                                    .build());
 
        Long id = saveBoard.getId();
 
        String url = "http://localhost:" + port + "/api/board/" + id;
 
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
 
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Long.class);
 
        assertThat(responseEntity, equalTo(HttpStatus.NO_CONTENT));
        
    }
}
