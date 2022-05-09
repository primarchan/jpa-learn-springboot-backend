package com.example.jpalearnproject.service.board;

import com.example.jpalearnproject.domain.board.Board;
import com.example.jpalearnproject.domain.board.BoardRepository;
import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void save(BoardRequestDTO boardRequestDTO) {
        boardRepository.save(boardRequestDTO.toEntity());
    }

    @Override
    public BoardRequestDTO read() {
        return null;
    }

    @Override
    public List<BoardRequestDTO> getList() {
        return null;
    }
}
