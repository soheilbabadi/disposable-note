package com.disposable.note_api.repository;

import com.disposable.note_api.domain.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends CrudRepository<Note, Long> {

    Optional<Note> findByShortUri(String shortUrl);
    Optional<Note> findByShortUriAndSeenIsFalse(String shortUrl);
    List<Note> findAllBySeen(boolean seen);

}
