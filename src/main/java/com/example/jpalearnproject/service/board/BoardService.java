package com.example.jpalearnproject.service.board;

import com.example.jpalearnproject.domain.board.Board;
import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import com.example.jpalearnproject.dto.board.BoardResponseDTO;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    Long boardSave(BoardRequestDTO boardRequestDTO);

    BoardResponseDTO boardFindById(Long id);

    List<Board> boardFindAll();
}
