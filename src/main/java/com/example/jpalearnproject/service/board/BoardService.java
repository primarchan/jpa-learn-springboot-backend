package com.example.jpalearnproject.service.board;

import com.example.jpalearnproject.dto.board.BoardRequestDTO;

import java.util.List;

public interface BoardService {

    void save(BoardRequestDTO boardRequestDTO);

    BoardRequestDTO read();

    List<BoardRequestDTO> getList();
}
