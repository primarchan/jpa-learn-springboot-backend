package com.example.jpalearnproject.domain.board;

import com.example.jpalearnproject.dto.board.BoardRequestDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
@Entity(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "BOARD_TITLE", nullable = false)
    private String title;

    @Column(name = "BOARD_CONTENT", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "BOARD_WRITER", nullable = false)
    private String writer;

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    @Column(name = "REG_DATE")
    private String reg_date;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
    @Column(name = "MODIFY_DATE")
    private String modify_date;

    @Builder
    public Board(String title, String content, String writer, String reg_date, String modify_date) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.reg_date = reg_date;
        this.modify_date = modify_date;
    }

    public void update(BoardRequestDTO boardRequestDTO) {
        this.title = boardRequestDTO.getTitle();
        this.content = boardRequestDTO.getContent();
        this.writer = boardRequestDTO.getWriter();
        this.modify_date = boardRequestDTO.getModify_date();
    }

}
