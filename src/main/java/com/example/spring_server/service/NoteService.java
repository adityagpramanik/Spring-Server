package com.example.spring_server.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.spring_server.model.Note;

@Service
public class NoteService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Note create(Note note) {
        try {
            mongoTemplate.insert(note, "notes");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return note;
    }
    public List<Note> find() {
        try {
            List<Note> notes = mongoTemplate.findAll(Note.class, "notes");
            return notes;   
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
