package net.jobintech.jobintechprogram.Services.Impl;


import net.jobintech.jobintechprogram.Services.CrudService;
import net.jobintech.jobintechprogram.exceptions.ResourceNotFoundException;
import net.jobintech.jobintechprogram.mapper.IDaoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public class CrudServiceImpl<ENTITY , REQUEST , RESPONSE , ID> implements CrudService<REQUEST , RESPONSE , ID> {

    private final MongoRepository<ENTITY , ID> repository;
    private final IDaoMapper<ENTITY , REQUEST , RESPONSE > mapper;
    private final String resource;

    public CrudServiceImpl(MongoRepository<ENTITY, ID> repository, IDaoMapper<ENTITY, REQUEST, RESPONSE> mapper, String resource) {
        this.repository = repository;
        this.mapper = mapper;
        this.resource = resource;
    }

    @Override
    public RESPONSE create(REQUEST request) {
        ENTITY entity = this.mapper.requestToEntity(request);
        ENTITY created = this.repository.save(entity);
        return this.mapper.entityToResponse(created);
    }

    @Override
    public RESPONSE update(REQUEST request, ID id) {
        ENTITY entity = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(resource + " doesn't exist with this ID : " + id));
        ENTITY updatedEntityFields = this.mapper.updatedEntityFields(request, entity);
        ENTITY updated = this.repository.save(updatedEntityFields);

        return this.mapper.entityToResponse(updated);
    }

    @Override
    public RESPONSE delete(ID id) {
        ENTITY entity = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(resource + " doesn't exist with this ID : " + id));
        this.repository.delete(entity);
        return this.mapper.entityToResponse(entity);
    }

    @Override
    public RESPONSE getOne(ID id) {
        ENTITY entity = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(resource + " doesn't exist with this ID : " + id));
        return this.mapper.entityToResponse(entity);
    }

    @Override
    public List<RESPONSE> getAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .toList();
    }

    @Override
    public Page<RESPONSE> getAll(int pageNumber, int pageSize) {
        Page<ENTITY> page = this.repository.findAll(PageRequest.of(pageNumber, pageSize));
        List<RESPONSE> responseList = page.getContent()
                .stream()
                .map(mapper::entityToResponse)
                .toList();

        return new PageImpl<>(responseList , page.getPageable() , page.getTotalElements());
    }
}
