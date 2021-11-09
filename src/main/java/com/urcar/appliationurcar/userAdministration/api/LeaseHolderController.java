package com.urcar.appliationurcar.userAdministration.api;


import com.urcar.appliationurcar.userAdministration.domain.service.LeaseHolderService;
import com.urcar.appliationurcar.userAdministration.mapping.LeaseHolderMapper;
import com.urcar.appliationurcar.userAdministration.resource.CreateLeaseHolderResource;
import com.urcar.appliationurcar.userAdministration.resource.LeaseHolderResource;
import com.urcar.appliationurcar.userAdministration.resource.UpdateLeaseHolderResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/leaseHolder")
public class LeaseHolderController {

    private final LeaseHolderService leaseHolderService;
    private final LeaseHolderMapper mapper;

    public LeaseHolderController(LeaseHolderService leaseHolderService, LeaseHolderMapper mapper) {
        this.leaseHolderService = leaseHolderService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<LeaseHolderResource> getAllLeaseHolder(Pageable pageable){
        return mapper.modelListToPage(leaseHolderService.getAll(),pageable);
    }

    @GetMapping("{leaseHolderId}")
    public LeaseHolderResource getLeaseHolderById(@PathVariable Long leaseHolderId){
        return mapper.toResource(leaseHolderService.getById(leaseHolderId));
    }

    @PostMapping(consumes="application/json")
    public LeaseHolderResource createLeaseHolder(@RequestBody CreateLeaseHolderResource request){
        return mapper.toResource(leaseHolderService.create(mapper.toModel(request)));
    }
    @PutMapping("{leaseHolderId}")
    public LeaseHolderResource updateLeaseHolder(@PathVariable Long leaseHolderId, @RequestBody UpdateLeaseHolderResource request){
        return mapper.toResource(leaseHolderService.update(leaseHolderId,mapper.toModel(request)));
    }

    @DeleteMapping("{leaseHolderId}")
    public ResponseEntity<?> deleteLeaseHolder(@PathVariable Long leaseHolderId){
        return leaseHolderService.delete(leaseHolderId);
    }
}
