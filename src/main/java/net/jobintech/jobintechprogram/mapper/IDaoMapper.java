package net.jobintech.jobintechprogram.mapper;

import java.util.List;

public interface IDaoMapper<ENTITY , REQUEST , RESPONSE> {

    ENTITY requestToEntity(REQUEST request);
    RESPONSE entityToResponse(ENTITY entity);
    ENTITY updatedEntityFields(REQUEST request , ENTITY entity);

    default List<ENTITY> requestListToEntityList(List<REQUEST> requestList){
        return requestList.stream()
                .map(this::requestToEntity)
                .toList();
    }

    default List<RESPONSE> entityListToResponseList(List<ENTITY> entityList){
        return entityList.stream()
                .map(this::entityToResponse)
                .toList();
    }
}
