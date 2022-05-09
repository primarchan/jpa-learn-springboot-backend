package com.example.jpalearnproject.domain.board;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @After // 테스트 단위가 종료될 때마다 수해되는 메서드 지정
    public void cleanup() {
        boardRepository.deleteAll();
    }

    @Test
    public void BoardRepository_연동_테스트() {
        String title = "테스트 제목";
        String content = "테스트 본문";
        String writer = "테스트 작성자";

        // Builder 클래스를 통해 생성자 생성 후 save (insert/update) -> id 값이 있다면 update, 없다면 insert
        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build());

        List<Board> boardList = boardRepository.findAll();
        Board board = boardList.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
        assertThat(board.getWriter()).isEqualTo(writer);

    }
}
