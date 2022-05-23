package com.example.jpalearnproject.dto.board;

import com.example.jpalearnproject.domain.board.Board;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDTO {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private String reg_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    private String modify_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    /* Entity -> DTO */
    @Builder
    public BoardResponseDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.reg_date = board.getRegDate();
        this.modify_date = board.getModifyDate();
    }
}
