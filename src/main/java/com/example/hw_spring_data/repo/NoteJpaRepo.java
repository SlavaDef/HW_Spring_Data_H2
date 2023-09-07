package com.example.hw_spring_data.repo;

import com.example.hw_spring_data.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteJpaRepo extends JpaRepository<Note, Long> {


}
