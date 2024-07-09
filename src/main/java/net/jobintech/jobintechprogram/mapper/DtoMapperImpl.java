package net.jobintech.jobintechprogram.mapper;

import org.modelmapper.ModelMapper;


public class DtoMapperImpl<ENTITY , REQUEST , RESPONSE> implements IDaoMapper<ENTITY , REQUEST , RESPONSE>{

    private final ModelMapper modelMapper;
    private final Class<ENTITY> entityClass;
    private final Class<RESPONSE> responseClass;

    protected DtoMapperImpl(ModelMapper modelMapper,
                            Class<ENTITY> entityClass,
                            Class<RESPONSE> dtoResponseClass) {
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.responseClass = dtoResponseClass;
    }


    @Override
    public ENTITY requestToEntity(REQUEST request) {
        return this.modelMapper.map(request , entityClass);
    }

    @Override
    public RESPONSE entityToResponse(ENTITY entity) {
        return this.modelMapper.map(entity , responseClass);
    }

    @Override
    public ENTITY updatedEntityFields(REQUEST request , ENTITY entity) {
         this.modelMapper.map(request , entity);
         return entity;
    }
}
