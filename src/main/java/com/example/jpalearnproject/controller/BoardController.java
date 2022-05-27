package com.example.jpalearnproject.controller;

import com.example.jpalearnproject.domain.board.Board;
import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import com.example.jpalearnproject.dto.board.BoardResponseDTO;
import com.example.jpalearnproject.dto.common.Message;
import com.example.jpalearnproject.dto.common.StatusEnum;
import com.example.jpalearnproject.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping("/write")
    public ResponseEntity<Message> boardWrite(@RequestBody BoardRequestDTO boardRequestDTO) {
        Long boardId = boardService.boardSave(boardRequestDTO);
        Message message = new Message(StatusEnum.OK, "성공 코드", boardId + "번 게시물이 등록되었습니다.");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(message, httpHeaders, HttpStatus.OK);
    }

    // 게시글 조회
    @GetMapping("/{id}")
    public BoardResponseDTO boardRead(@PathVariable Long id) throws Exception{
        return boardService.boardFindById(id);
    }

    // 게시글 목록 조회
    @GetMapping("/list")
    public List<BoardResponseDTO> boardList() {
        return boardService.boardFindAll();
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Message> boardModify(@PathVariable Long id, @RequestBody BoardRequestDTO boardRequestDTO) {
        Long boardId = boardService.boardModify(id, boardRequestDTO);

        Message message = new Message(StatusEnum.OK, "성공 코드", boardId + "번 게시물이 수정되었습니다.");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(message, httpHeaders, HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public void boardRemove(@PathVariable Long id) {
        boardService.boardRemove(id);
    }

}
