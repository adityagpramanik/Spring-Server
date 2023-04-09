package com.example.spring_server.model;

/**
 * noteModel
 */

public class Note {
    private String head;
    private String body;
    private String[] tags;
    private String id;
    
    public Note() {
    }
    public Note(String head, String body, String[] tags) {
        this.head = head;
        this.body = body;
        this.tags = tags;
    }
    public Note(String head, String body) {
        this.head = head;
        this.body = body;
        this.tags = new String[] {};
    }
    
    public String getHead() {
        return head;
    }
    
    public String getBody() {
        return body;
    }

    public String[] getTags() {
        return tags;
    }
    public String getId() {
        return id;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public void setTags(String[] tags) {
        this.tags = tags;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Head: " + head + "\nBody: " + body + "\nTags: " + String.join(", ", tags) + "\n";
    }
}