package com.example.hw_spring_data.servises;

import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.repo.NoteRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteServis {

    private final NoteRepository repository;

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
        return repository.getById(id);
    }

    public void update( Note note) {

        repository.save(note);
    }


}
