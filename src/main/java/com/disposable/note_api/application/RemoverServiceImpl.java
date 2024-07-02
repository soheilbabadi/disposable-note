package com.disposable.note_api.application;

import com.disposable.note_api.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@EnableScheduling
@EnableAsync

public class RemoverServiceImpl {

    private final NoteRepository noteRepository;

    @Async
    @Scheduled(fixedRate = 5000,fixedDelay = 5000)
    public void remover(){
       var p= noteRepository.findAllBySeen(true);
        noteRepository.deleteAll(p);
    }


}
