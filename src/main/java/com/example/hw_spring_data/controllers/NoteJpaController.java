package com.example.hw_spring_data.controllers;

import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.servises.NoteJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteJpaController {

    private final NoteJpaService service;

    @GetMapping("/list")
    public String noteMain(Model model) {
        Iterable<Note> notes = service.findAll();
        model.addAttribute("noteList", notes);
        return "note-all";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        service.deleteById(id);
        return "redirect:/note/list";

    }

    @GetMapping("/add") // щаблон
    public String noteAdd(Model model) {
        return "note-add";
    }

    @PostMapping("/add") //  отримуємо данні з форми сайту
    public String notePostAdd(@RequestParam String title,
                              @RequestParam String content,
                              Model model) {

        Note note = new Note(title, content);
        service.addNote(note);
        return "redirect:/note/list";

    }

    @GetMapping("/edit/{id}") // гет шаблон
    public String noteEdit(@PathVariable(value = "id") Long id, Model model) throws ChangeSetPersister.NotFoundException {
        if (service.getById(id) == null) {
            return "redirect:/note/list";
        }
        model.addAttribute("noteList", service.getById(id));

        return "note-edit";
    }


    @PostMapping("/edit") // post реліз
    public String noteUpdate(long id,
                             @RequestParam String title,
                             @RequestParam String content,
                             Model model) throws ChangeSetPersister.NotFoundException {

        Note note = service.getById(id);

        note.setTitle(title);
        note.setContent(content);
        service.update(note);
        return "redirect:/note/list";
    }

}
