package com.example.jpalearnproject.controller;

import com.example.jpalearnproject.domain.board.Board;
import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import com.example.jpalearnproject.dto.board.BoardResponseDTO;
import com.example.jpalearnproject.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping("/write")
    public String write(@RequestBody BoardRequestDTO boardRequestDTO) {
        Long boardId = boardService.boardSave(boardRequestDTO);
        return boardId + "번 게시물이 등록되었습니다.";
    }

    // 게시글 조회
    @GetMapping("/{id}")
    public BoardResponseDTO read(@PathVariable Long id) {
        return boardService.boardFindById(id);
    }

    // 게시글 목록 조회
    @GetMapping("/list")
    public List<Board> list() {
        return boardService.boardFindAll();
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public void modify(@PathVariable Long id, @RequestBody BoardRequestDTO boardRequestDTO) {

    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {

    }

}
