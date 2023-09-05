package com.example.hw_spring_data.controllers;

import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.repo.NoteRepository;
import com.example.hw_spring_data.servises.NoteServis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {

    private final NoteServis servis;


    @GetMapping("/list")
    public String blogMain(Model model) {
        Iterable<Note> notes = servis.findAll();
        model.addAttribute("noteList", notes);
        return "note-all";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        servis.deleteById(id);
        return "redirect:/note/list";

    }

    @GetMapping("/add") // щаблон
    public String blogAdd(Model model) {
        return "note-add";
    }

    @PostMapping("/add") //  отримуємо данні з форми сайту
    public String blogPostAdd(@RequestParam String title,
                              @RequestParam String content,
                              Model model) {

        Note note = new Note(title, content);
        servis.addNote(note);
        return "redirect:/note/list";

    }

    @GetMapping("/edit/{id}") // гет шаблон
    public String noteEdit(@PathVariable(value = "id") Long id, Model model) {
        if (servis.getById(id) == null) {
            return "redirect:/note/list";
        }
        model.addAttribute("noteList", servis.getById(id));

        return "note-edit";
    }


    @PostMapping("/edit") // post реліз
    public String noteUpdate(long id,
                             @RequestParam String title,
                             @RequestParam String content,
                             Model model) {

        Note note = servis.getById(id);
        note.setTitle(title);
        note.setContent(content);
        servis.update(note);
        return "redirect:/note/list";
    }
}
