package com.example.hw_spring_data.repo;

import com.example.hw_spring_data.models.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

    @Query("select n from Note n where n.id= ?1")
    Note getById(Long id);
}





