package org.example.springexample.controllers;

import org.example.springexample.dto.CommentDto;
import org.example.springexample.services.CommentCRUDSerice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentCRUDSerice commentCRUDSerice;

    public CommentController(CommentCRUDSerice commentCRUDSerice) {
        this.commentCRUDSerice = commentCRUDSerice;
    }
    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Integer id){
        return commentCRUDSerice.getById(id);
    }
    @GetMapping
    public Collection<CommentDto> getAllComments() {
        return commentCRUDSerice.getAll();
    }
    @PostMapping
    public void createComment(@RequestBody CommentDto commentDto) {
        commentCRUDSerice.create(commentDto);
    }
    @PutMapping("/{id}")
    public void updateComment(@PathVariable Integer id, @RequestBody CommentDto commentDto) {
        commentCRUDSerice.update(id, commentDto);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentCRUDSerice.delete(id);
    }
}
