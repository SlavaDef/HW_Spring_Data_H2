/* package com.example.hw_spring_data.controllers;

import com.example.hw_spring_data.models.Note;
import com.example.hw_spring_data.repo.NoteCrudRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class NoteControllerWithoutServise {

    private final NoteCrudRepo repository;

    @GetMapping("/note/list")
    public String noteMain(Model model) {
        Iterable<Note> notes = repository.findAll();
        model.addAttribute("noteList", notes); // передаємо всі найдені note
        return "note-all"; // визов шаблона
    }

    @GetMapping("/note/add") // тут вже будемо відслідковувати нову note
    public String noteAdd(Model model) {
        return "note-add"; // визов шаблона
    }


    // @RequestParam String title отримаємо дані з параметра (note-add) для полів title, context
    @PostMapping("/note/add") // тут будемо отримувати данні з форми сайту
    public String notePostAdd(@RequestParam String title,
                              @RequestParam String content,
                               Model model) {

        Note note = new Note(title, content);
        repository.save(note); // зберігаємо отриманий обьект
        return "redirect:/note/list"; // далі переадрес на list note

    }

    @GetMapping("/note/{id}") // прописуємо динамічний параметр
    public String noteDetails(@PathVariable(value = "id") long id, Model model) { // від статті
        if (!repository.existsById(id)) { // якщо note нема то редирект на головну
            return "redirect:/note/list";
        }
        Optional<Note> note = repository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        note.ifPresent(res::add);
        model.addAttribute("noteList", res); // тут вже буде запис з бази данних
        return "note-all"; // визов шаблона
    }

    // метод для форми оновлення
    @GetMapping("/note/edit/{id}") // прописуємо динамічний параметр
    public String noteEdit(@PathVariable(value = "id") long id, Model model) { // від статті
        if (!repository.existsById(id)) { // якщо note нема то редирект на головну
            return "redirect:/note/list";
        }
        Optional<Note> note = repository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        note.ifPresent(res::add);
        model.addAttribute("noteList", res); // тут вже буде запис з бази данних
        return "note-edit"; // визов шаблона
    }

    // метод для додавання оновлення note
    @PostMapping("/note/edit") // адреса яку ми відслідковуємо
    public String notePostUpdate( long id, // + таккож приймаємо параметр для обробки
                                 @RequestParam String title,
                                 @RequestParam String content,
                                  Model model) {
        // + orElseThrow() викине виключення якщо запис не був знайдений
        Note note = repository.findById(id).orElseThrow();
        note.setTitle(title);
        note.setContent(content);
        repository.save(note);
        return "redirect:/note/list"; // далі переадрес на блог
    }

    @PostMapping("/note/delete") // адреса яку ми відслідковуємо
    public String notePostDelete(long id, // + таккож приймаємо параметр для обробки
                                 Model model) {
        // + orElseThrow() викине виключення якщо запис не був знайдений
        Note note = repository.findById(id).orElseThrow();
        repository.delete(note);
        return "redirect:/note/list"; // далі переадрес на list
    }


}




 */