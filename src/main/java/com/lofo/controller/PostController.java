package com.lofo.controller;

import com.lofo.dto.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class
PostController {

    List<PostDTO> postDTOList = new ArrayList<>();

    @GetMapping(path = "/posts")
    public List<PostDTO> getAllPost() {
        return postDTOList;
    }


    @PostMapping(path = "/posts")
    public void createPosts(@RequestBody PostDTO postDTO) {
        postDTOList.add(postDTO);
    }


    @GetMapping(path = "/posts/{id}")
    public PostDTO getPostById(@PathVariable(value = "id") int id) {
        return postDTOList.stream().filter(post -> post.getId() == id).findFirst().get();
    }


    @PutMapping(path = "/posts/{id}")
    public ResponseEntity<?> updatePost(@PathVariable(value = "id") int id, @RequestBody PostDTO postDTO) {

        PostDTO post = getPostById(id);
        if (post == null) {
            return new ResponseEntity<>("Post with id = " + id + " was not found ", HttpStatus.NOT_FOUND);
        }

        post.setDate(postDTO.getDate());
        post.setCategory(postDTO.getCategory());
        post.setType(postDTO.getType());

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(path = "/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") int id) {
        PostDTO postDTO = getPostById(id);
        if (postDTO == null) {
            return new ResponseEntity<>("Post with id = " + id + " was not found ", HttpStatus.NOT_FOUND);
        }
        postDTOList.remove(postDTO);
        return new ResponseEntity<>("Post has been deleted" , HttpStatus.OK);
    }

}
