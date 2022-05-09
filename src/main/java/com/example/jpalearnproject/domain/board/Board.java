package com.example.jpalearnproject.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
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

    @Column(name = "REG_DATE")
    private Date reg_date;

    @Column(name = "UPDATE_DATE")
    private Date update_date;

    @Builder
    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
