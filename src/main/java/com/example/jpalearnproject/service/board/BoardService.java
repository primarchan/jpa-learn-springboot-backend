package com.example.jpalearnproject.service.board;

import com.example.jpalearnproject.domain.board.Board;
import com.example.jpalearnproject.domain.board.BoardRepository;
import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import com.example.jpalearnproject.dto.board.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long boardSave(BoardRequestDTO boardRequestDTO) {
        Board board = boardRepository.save(boardRequestDTO.toEntity());
        return board.getId();
    }

    @Transactional
    public BoardResponseDTO boardFindById(Long id){
        Board board = boardRepository.findById(id).get();
        return new BoardResponseDTO(board);
    }

    @Transactional
    public List<BoardResponseDTO> boardFindAll() {
        List<Board> boardList= boardRepository.findAll();
        List<BoardResponseDTO> boardResponseDTOList = new ArrayList<>();
        for(int i = 0; i < boardList.size(); i++) {
            BoardResponseDTO boardResponseDTO = new BoardResponseDTO(boardList.get(i));
            boardResponseDTOList.add(boardResponseDTO);
        }
        return boardResponseDTOList;
    }

    @Transactional
    public Long boardModify(Long id, BoardRequestDTO boardRequestDTO) {
        Board board = boardRepository.findById(id).get();
        board.update(boardRequestDTO);
        return board.getId();
    }

    @Transactional
    public void boardRemove(Long id) {
        Board board = boardRepository.findById(id).get();
        boardRepository.delete(board);
    }
}
