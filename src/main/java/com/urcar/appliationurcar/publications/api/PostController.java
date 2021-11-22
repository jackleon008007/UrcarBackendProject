package com.urcar.appliationurcar.publications.api;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import com.urcar.appliationurcar.publications.domain.service.PostService;
import com.urcar.appliationurcar.publications.mapping.PostMapper;
import com.urcar.appliationurcar.publications.resource.CreatePostResource;
import com.urcar.appliationurcar.publications.resource.PostResource;
import com.urcar.appliationurcar.publications.resource.UpdatePostResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="Post")
@RestController
@RequestMapping("/api/v1/lessor/{lessorId}/post")
public class PostController {

    private final PostService postService;
    private final PostMapper mapper;

    public PostController(PostService postService, PostMapper mapper) {
        this.postService = postService;
        this.mapper = mapper;
    }

    @Operation(summary="Get Posts", description="Get all post from Database PostgreSql")
    @ApiResponses(value ={
            @ApiResponse(
                    responseCode = "200",
                    description = "Post Found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = PostResource.class
                                    )

                            )
                    }
            )
    })
    @GetMapping
    public Page<PostResource> getAllPost(Pageable pageable){
        return mapper.modelListToPage(postService.getAll(),pageable);
    }
    

    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable Long postId){
        return mapper.toResource(postService.getById(postId));
    }
    

    @PostMapping(consumes="application/json")
    public PostResource createPost(@PathVariable Long lessorId, @RequestBody CreatePostResource request){
        return mapper.toResource(postService.create(lessorId,mapper.toModel(request)));
    }

    @PutMapping("{postId}")
    public PostResource updatePost(@PathVariable Long postId,@RequestBody UpdatePostResource request){
        return mapper.toResource(postService.update(postId,mapper.toModel(request)));
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId){
        return postService.delete(postId);
    }
}
