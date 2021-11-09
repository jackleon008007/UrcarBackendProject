package com.urcar.appliationurcar.userAdministration.mapping;


import com.urcar.appliationurcar.shared.mapping.EnhancedModelMapper;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import com.urcar.appliationurcar.userAdministration.resource.CreateLeaseHolderResource;
import com.urcar.appliationurcar.userAdministration.resource.LeaseHolderResource;
import com.urcar.appliationurcar.userAdministration.resource.UpdateLeaseHolderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class LeaseHolderMapper implements Serializable {


    @Autowired
    EnhancedModelMapper mapper;

    public LeaseHolderResource toResource(LeaseHolder model){
        return mapper.map(model,LeaseHolderResource.class);
    }

    public Page<LeaseHolderResource> modelListToPage(List<LeaseHolder> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,LeaseHolderResource.class),pageable, modelList.size());
    }

    public LeaseHolder toModel(CreateLeaseHolderResource resource){

        return mapper.map(resource,LeaseHolder.class);
    }

    public LeaseHolder toModel(UpdateLeaseHolderResource resource){
        return mapper.map(resource,LeaseHolder.class);
    }
}
