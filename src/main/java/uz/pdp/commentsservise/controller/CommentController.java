package uz.pdp.commentsservise.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.commentsservise.dto.CommentCreateDTO;
import uz.pdp.commentsservise.entitys.Comment;
import uz.pdp.commentsservise.repositories.CommentRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;

    @GetMapping
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentRepository.findAll());
    }

    @GetMapping("/{id}/post")
    public ResponseEntity<List<Comment>> getAllByPostId(@PathVariable Integer id) throws InterruptedException {
        log.info("Comments requested for POST ID : {}", id);
        TimeUnit.SECONDS.sleep(1L);
        return ResponseEntity.ok(commentRepository.findAllByPostId(id));
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Void> createList(@RequestBody List<CommentCreateDTO> dtos) {
        log.info("Creating List Of Comments : {}", dtos);
        List<Comment> comments = dtos.stream()
                .map(Comment::new)
                .toList();
        commentRepository.saveAll(comments);
        return ResponseEntity.ok(null);
    }
}