package com.urcar.appliationurcar.publications.mapping;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import com.urcar.appliationurcar.publications.resource.CreatePostResource;
import com.urcar.appliationurcar.publications.resource.PostResource;
import com.urcar.appliationurcar.publications.resource.UpdatePostResource;
import com.urcar.appliationurcar.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PostMapper implements Serializable {

    private EnhancedModelMapper mapper;

    public PostMapper(EnhancedModelMapper mapper){
        this.mapper = mapper;
    }

    // Object Mapping
    public PostResource toResource(Post model){
        return mapper.map(model, PostResource.class);
    }

    public Page<PostResource> modelListToPage(List<Post> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, PostResource.class), pageable, modelList.size());
    }

    public Post toModel(CreatePostResource resource){
        return mapper.map(resource, Post.class);
    }

    public Post toModel(UpdatePostResource resource){
        return mapper.map(resource, Post.class);
    }

}
