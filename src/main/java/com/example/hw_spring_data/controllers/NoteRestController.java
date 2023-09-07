 /* package com.example.hw_spring_data.controllers;

import com.example.hw_spring_data.exeption.NotFoundNoteExp;
import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.servises.NoteCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/ip/note")
@RestController
public class NoteRestController {

    private final NoteCrudService noteService;

    @GetMapping("/list")
    public List<Note> list() {
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note NoteById(@PathVariable("id") Long id) throws NotFoundNoteExp {

        return noteService.getById(id);
    }

    @GetMapping("/delete/{id}") // todo Post
    public String deleteNoteById(@PathVariable("id") Long id) throws NotFoundNoteExp {
        if (id > noteService.findAll().size()) {
            throw new NotFoundNoteExp("No such id, try enother id");
        }
        noteService.deleteById(id);
        // redirect:/ip/note/list
        return "Succes!!";

    }

    @PostMapping("/add")
    public ResponseEntity <Note> addNote(@RequestBody Note note) {
        noteService.addNote(note);
      return ResponseEntity.ok(note);
    }

    @PostMapping("/update/{id}")
    public void updateNote(@PathVariable("id") Long id) {

    }

}


  */