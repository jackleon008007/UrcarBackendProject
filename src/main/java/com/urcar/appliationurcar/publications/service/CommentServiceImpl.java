package com.urcar.appliationurcar.publications.service;


import com.urcar.appliationurcar.publications.domain.model.entity.Comment;
import com.urcar.appliationurcar.publications.domain.persistence.CommentRepository;
import com.urcar.appliationurcar.publications.domain.persistence.PostRepository;
import com.urcar.appliationurcar.publications.domain.service.CommentService;
import com.urcar.appliationurcar.shared.exception.ResourceNotFoundException;
import com.urcar.appliationurcar.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private static final String ENTITY ="comment";
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final Validator validator;
    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository, Validator validator){
        this.commentRepository=commentRepository;
        this.validator = validator;
        this.postRepository = postRepository;
    }




    @Override
    public List<Comment> getAllByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Page<Comment> getAllByPostId(Long postId,Pageable pageable) {
        return commentRepository.findByPostId(postId,pageable);
    }




    @Override
    @Transactional
    public Comment create(Long postId, Comment request) {
        Set<ConstraintViolation<Comment>> violations = validator.validate(request);




        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }




        return postRepository.findById(postId).map(post->{
            request.setPost(post);
            return commentRepository.save(request);
        }).orElseThrow(()-> new ResourceNotFoundException("Post",postId));
    }

    @Override
    @Transactional
    public Comment update(Long postId, Long commentId, Comment request) {

        Set<ConstraintViolation<Comment>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
        if(!postRepository.existsById(postId)){
            throw new ResourceNotFoundException("Post",postId);
        }
        return commentRepository.findById(commentId).map(
                        comment-> commentRepository.save(comment.withLeaseHolderId(request.getLeaseHolderId())
                                .withText(request.getText())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,commentId));
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long postId, Long commentId) {
        return commentRepository.findByIdAndPostId(commentId,postId).map(comment->{
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,commentId));
    }

}
