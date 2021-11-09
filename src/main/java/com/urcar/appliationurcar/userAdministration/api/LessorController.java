package com.urcar.appliationurcar.userAdministration.api;


import com.urcar.appliationurcar.userAdministration.domain.service.LessorService;
import com.urcar.appliationurcar.userAdministration.mapping.LessorMapper;
import com.urcar.appliationurcar.userAdministration.resource.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessor")
public class LessorController {

    private final LessorService lessorService;
    private final LessorMapper mapper;

    public LessorController(LessorService lessorService, LessorMapper mapper) {

        this.lessorService = lessorService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<LessorResource> getAllLessor(Pageable pageable){
        return mapper.modelListToPage(lessorService.getAll(),pageable);
    }

    @GetMapping("{lessorId}")
    public LessorResource getLessorById(@PathVariable Long lessorId){
        return mapper.toResource(lessorService.getById(lessorId));
    }

    @PostMapping(consumes= "application/json")
    public LessorResource createLessor(@RequestBody CreateLessorResource request){
        return mapper.toResource(lessorService.create(mapper.toModel(request)));
    }
    @PutMapping("{lessorId}")
    public LessorResource updateLessor(@PathVariable Long lessorId, @RequestBody UpdateLessorResource request){
        return mapper.toResource(lessorService.update(lessorId,mapper.toModel(request)));
    }

    @DeleteMapping("{lessorId}")
    public ResponseEntity<?> deleteLessor(@PathVariable Long lessorId){
        return lessorService.delete(lessorId);
    }

}
