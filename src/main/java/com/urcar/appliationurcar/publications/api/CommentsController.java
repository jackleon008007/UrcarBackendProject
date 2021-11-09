package com.urcar.appliationurcar.publications.api;


import com.urcar.appliationurcar.publications.domain.model.entity.Comment;
import com.urcar.appliationurcar.publications.domain.service.CommentService;
import com.urcar.appliationurcar.publications.domain.service.PostService;
import com.urcar.appliationurcar.publications.mapping.CommentMapper;
import com.urcar.appliationurcar.publications.mapping.PostMapper;
import com.urcar.appliationurcar.publications.resource.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/lessor/{lessorId}/post/{postId}/comment")
public class CommentsController {
    private final CommentService commentService;
    private final CommentMapper mapper;


    public CommentsController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }



    @GetMapping
    public Page<CommentResource> getAllCommentByPostId(@PathVariable Long postId, Pageable pageable){
        return mapper.modelListToPage(commentService.getAllByPostId(postId),pageable);
    }

    @PostMapping(consumes="application/json")
    public CommentResource createComment(@PathVariable Long postId,
                                         @RequestBody CreateCommentResource request){
        return mapper.toResource(commentService.create(postId,mapper.toModel(request)));
    }

    @PutMapping("{commentId}")
    public CommentResource updateComment(@PathVariable Long postId,
                                         @PathVariable Long commentId,
                                         @RequestBody UpdateCommentResource request){
        return mapper.toResource(commentService.update(postId,commentId,mapper.toModel(request)));
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long postId,
                                           @PathVariable Long commentId){
        return commentService.delete(postId,commentId);
    }

    
}
