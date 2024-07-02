package com.disposable.note_api.application;


import com.disposable.note_api.domain.Note;
import com.disposable.note_api.dto.NoteCreateDto;
import com.disposable.note_api.dto.NoteDto;
import com.disposable.note_api.dto.NoteResponseDto;
import com.disposable.note_api.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl {

    private final NoteRepository noteRepository;

    public NoteDto createNote(NoteCreateDto dto) {
        Note note = new Note();
        note.setCreatedAt(LocalDateTime.now());
        note.setContent(dto.getContent());
        note.setAuthor(dto.getAuthor());
        note.setSeen(false);
        note.setShortUri(UUID.randomUUID().toString());
        noteRepository.save(note);

        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setContent(note.getContent());
        noteDto.setCreatedAt(note.getCreatedAt());
        noteDto.setSeen(note.isSeen());
        noteDto.setAuthor(note.getAuthor());
        noteDto.setShortUri(note.getShortUri());
        return noteDto;
    }

    public NoteResponseDto getNoteByShortUri(String shortUri) {
        Note note = noteRepository.findByShortUriAndSeenIsFalse(shortUri)
                .orElseThrow(() -> new EntityNotFoundException("Note not found"));
        NoteResponseDto noteDto = new NoteResponseDto();
        noteDto.setId(1323432L);
        noteDto.setContent(note.getContent());
        noteDto.setCreatedAt(note.getCreatedAt());
        noteDto.setAuthor(note.getAuthor());
        return noteDto;
    }

}
