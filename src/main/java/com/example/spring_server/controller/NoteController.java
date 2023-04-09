package com.example.spring_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring_server.model.Note;
import com.example.spring_server.service.NoteService;

@RestController
public class NoteController {
     @Autowired
    private NoteService noteService;
    
    @GetMapping("api/v1/notes")
    public ResponseEntity<?> findNotes() {
        try {
            List<Note> notes = noteService.find();
            return ResponseEntity.status(HttpStatus.CREATED).body(notes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to fetch notes");
        }
    }

    @PostMapping("api/v1/note/create")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        if (note.getBody() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing params: body");
        }
        if (note.getHead() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing params: head");
        }
        if (note.getTags().length == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing params: tags");
        }
        try {
            Note noteDoc = noteService.create(note);
            return ResponseEntity.status(HttpStatus.CREATED).body(noteDoc);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating note");
        }
    }
}
