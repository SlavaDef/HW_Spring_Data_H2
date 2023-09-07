package com.example.hw_spring_data.servises;

import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.repo.NoteCrudRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteCrudService {

    private final NoteCrudRepo repository;

    public List<Note> findAll() {
        return (List<Note>) repository.findAll();
    }


    public void deleteById(Long id) {
        Note note = repository.findById(id).orElseThrow();
        repository.delete(note);
    }

    public void addNote(Note note) {
        repository.save(note);
    }

    public Note getById(Long id) {
        return repository.findById(id)
                .orElseThrow(IllegalStateException::new);
    }

    public void update(Note note) {

        repository.save(note);
    }


}
