package com.disposable.note_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto {

    private long id;
    private String content;
    private LocalDateTime createdAt;
    private boolean seen;
    private String author;
    private String shortUri;

}
