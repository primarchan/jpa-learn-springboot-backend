package com.example.jpalearnproject.service.board;

import com.example.jpalearnproject.domain.board.Board;
import com.example.jpalearnproject.domain.board.BoardRepository;
import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import com.example.jpalearnproject.dto.board.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Long boardSave(BoardRequestDTO boardRequestDTO) {
        Board board = boardRepository.save(boardRequestDTO.toEntity());
        return board.getId();
    }

    @Override
    public BoardResponseDTO boardFindById(Long id){
        Board board = boardRepository.findById(id).get();
        return new BoardResponseDTO(board);
    }

    @Override
    public List<Board> boardFindAll() {

        return boardRepository.findAll();
    }
}
