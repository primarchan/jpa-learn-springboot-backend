package com.example.jpalearnproject.dto.board;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class BoardDTO {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private Date reg_date;

    private Date update_date;
}
