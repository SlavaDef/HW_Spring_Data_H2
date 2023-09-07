package com.example.hw_spring_data.servises;

import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.repo.NoteJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class NoteJpaService {

    private final NoteJpaRepo repo;

    public List<Note> findAll() {
        return repo.findAll();
    }


    public void deleteById(Long id) {
        Note note = repo.findById(id).orElseThrow();
        repo.delete(note);
    }

    public void addNote(Note note) {
        repo.save(note);
    }

    public Note getById(Long id) throws ChangeSetPersister.NotFoundException {
        return repo.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void update( Note note) {

        repo.save(note);
    }
}
