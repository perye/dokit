package com.perye.dokit.mapper;

import java.util.List;

public interface EntityMapper<D, E> {

    /**
     * DTO转Entity
     */
    E toEntity(D dto);

    /**
     * Entity转DTO
     */
    D toDto(E entity);

    /**
     * DTO集合转Entity集合
     */
    List <E> toEntity(List<D> dtoList);

    /**
     * Entity集合转DTO集合
     */
    List<D> toDto(List<E> entityList);
}
