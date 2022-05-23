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

    @CreatedDate
    @Column(name = "REG_DATE")
    private String regDate;

    @LastModifiedDate
    @Column(name = "MODIFY_DATE")
    private String modifyDate;

    @Builder
    public Board(String title, String content, String writer, String reg_date, String modify_date) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = reg_date;
        this.modifyDate = modify_date;
    }

    public void update(BoardRequestDTO boardRequestDTO) {
        this.title = boardRequestDTO.getTitle();
        this.content = boardRequestDTO.getContent();
        this.writer = boardRequestDTO.getWriter();
        this.modifyDate = boardRequestDTO.getModifyDate();
    }

}
