package com.example.jpalearnproject.dto.board;

import com.example.jpalearnproject.domain.board.Board;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDTO {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private String reg_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    private String modify_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    /* DTO -> Entity */
    public Board toEntity() {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .reg_date(reg_date)
                .modify_date(modify_date)
                .build();

        return board;
    }


}
