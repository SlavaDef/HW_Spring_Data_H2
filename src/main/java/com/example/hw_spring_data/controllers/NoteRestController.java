/* package com.example.hw_spring_data.controllers;

import com.example.hw_spring_data.exeption.NotFoundNoteExp;
import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.servises.NoteServis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/ip/note")
@RestController
public class NoteRestController {

    private final NoteServis noteServis;

    @GetMapping("/list")
    public List<Note> list() {
        return noteServis.findAll();
    }

    @GetMapping("/{id}")
    public Note NoteById(@PathVariable("id") Long id) throws NotFoundNoteExp {

        return noteServis.getById(id);
    }

    @GetMapping("/delete/{id}") // todo Post
    public String deleteNoteById(@PathVariable("id") Long id) throws NotFoundNoteExp {
        if (id > noteServis.findAll().size()) {
            throw new NotFoundNoteExp("No such id, try enother id");
        }
        noteServis.deleteById(id);
        // redirect:/ip/note/list
        return "Succes!!";

    }

    @PostMapping("/add")
    public void addNote(@RequestBody Note note) {
        noteServis.addNote(note);
    }

    @PostMapping("/update/{id}")
    public void updateNote(@PathVariable("id") Long id) {

    }

}
 */