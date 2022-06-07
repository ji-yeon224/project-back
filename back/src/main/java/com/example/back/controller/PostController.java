package com.example.back.controller;

import com.example.back.domain.Post;
import com.example.back.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*", maxAge = 3600)
@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    //전체 조회
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    //하나 조회
    @GetMapping("/{postNo}")
    public ResponseEntity<Post> getPost(@PathVariable Integer postNo){
        return ResponseEntity.ok(postService.getPost(postNo));

    }

    //새글 작성
    @PostMapping
    public ResponseEntity<Post> writePost(@RequestBody Post post){
        return ResponseEntity.ok(postService.writePost(post));
    }
    //수정
    @PutMapping("/{postNo}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer postNo, @RequestBody Post updatePost){
        return ResponseEntity.ok(postService.updatePost(postNo, updatePost));
    }

    //삭제
    @DeleteMapping("/{postNo}")
    public void deletePost(@PathVariable Integer postNo){
        postService.deletePost(postNo);
    }


}
