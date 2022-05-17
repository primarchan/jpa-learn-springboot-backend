package com.example.jpalearnproject.service.board;

import com.example.jpalearnproject.common.exception.BoardException;
import com.example.jpalearnproject.domain.board.Board;
import com.example.jpalearnproject.domain.board.BoardRepository;
import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import com.example.jpalearnproject.dto.board.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long boardSave(BoardRequestDTO boardRequestDTO) {
        Board board = boardRepository.save(boardRequestDTO.toEntity());
        return board.getId();
    }

    @Transactional
    public BoardResponseDTO boardFindById(Long id) throws Exception{
        Board board = boardRepository.findById(id).orElseThrow(() -> new BoardException(HttpStatus.NOT_FOUND, id + "번 게시글이 존재하지않습니다."));
        // Board board = boardRepository.findById(id).get();
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
        boardRepository.deleteById(id);
    }
}
