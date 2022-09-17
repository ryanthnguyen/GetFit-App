package com.GetFit.utils;

import lombok.Builder;


public class TypeMapper<R,E> implements IMapper<R,E> {

    // map a record to an entity
    @Override
    public R toRecord(E entity) {
        return null;
    }

    //map an entity to a record -
    @Override
    public E toEntity(R record) {
        return null;
    }
}
