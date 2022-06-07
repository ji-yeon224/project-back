package com.example.back.service;

import com.example.back.domain.Post;
import com.example.back.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    //전체 조회
    public List<Post> getAllPosts(){
        return postRepository.findAllByOrderByPostNoDesc();
    }

    //하나 조회
    public Post getPost(Integer postNo){
        Post post = postRepository.findById(postNo).orElseThrow();
        return post;
    }

    //작성
    public Post writePost(Post newPost){
        newPost.setDate(LocalDateTime.now());
        return postRepository.save(newPost);
    }

    //수정
    public Post updatePost(Integer postNo, Post update){
        Post post = postRepository.getById(postNo);
        post.setContent(update.getContent());
        post.setTitle(update.getTitle());

        return postRepository.save(post);
    }

    //삭제
    public void deletePost(Integer id){
        postRepository.delete(postRepository.getById(id));
    }


}
