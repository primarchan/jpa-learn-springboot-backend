package com.example.jpalearnproject.controller;

import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import com.example.jpalearnproject.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping("/write")
    public void write(@RequestBody BoardRequestDTO boardRequestDTO) {
        boardService.save(boardRequestDTO);
    }

    // 게시글 조회
    @GetMapping("/read")
    public BoardRequestDTO read() {
        return null;
    }

    // 게시글 목록 조회
    @GetMapping("/list")
    public List<BoardRequestDTO> list() {
        return null;
    }

    // 게시글 수정
    @PutMapping("/modify")
    public void modify() {

    }

    // 게시글 삭제
    @DeleteMapping("/remove")
    public void remove() {

    }

}
