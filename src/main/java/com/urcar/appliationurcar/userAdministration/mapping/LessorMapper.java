package com.urcar.appliationurcar.userAdministration.mapping;

import com.urcar.appliationurcar.shared.mapping.EnhancedModelMapper;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import com.urcar.appliationurcar.userAdministration.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class LessorMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public LessorResource toResource(Lessor model){
        return mapper.map(model,LessorResource.class);
    }

    public Page<LessorResource> modelListToPage(List<Lessor> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,LessorResource.class),pageable, modelList.size());
    }

    public Lessor toModel(UpdateLessorResource resource){

        return mapper.map(resource,Lessor.class);
    }

    public Lessor toModel(CreateLessorResource resource){
        return mapper.map(resource,Lessor.class);
    }
}
