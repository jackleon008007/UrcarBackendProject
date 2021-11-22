package com.urcar.appliationurcar.publications.api;


import com.urcar.appliationurcar.publications.domain.service.PostService;
import com.urcar.appliationurcar.publications.mapping.PostMapper;
import com.urcar.appliationurcar.publications.resource.PostResource;
import com.urcar.appliationurcar.publications.resource.UpdatePostResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostAlternativeController {


    private final PostService postService1;
    private final PostMapper mapper1;

    public PostAlternativeController(PostService postService1, PostMapper mapper1) {
        this.postService1 = postService1;
        this.mapper1 = mapper1;
    }

    @GetMapping
    public Page<PostResource> getAllPost(Pageable pageable){
        return mapper1.modelListToPage(postService1.getAll(),pageable);
    }
    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable Long postId){
        return mapper1.toResource(postService1.getById(postId));
    }
    @PutMapping("{postId}")
    public PostResource updatePost(@PathVariable Long postId,@RequestBody UpdatePostResource request){
        return mapper1.toResource(postService1.update(postId,mapper1.toModel(request)));
    }
}
