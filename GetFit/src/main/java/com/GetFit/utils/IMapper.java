package com.GetFit.utils;

/*
this interface defines the blueprint for mapping dao > entity and entity > dao
 */
public interface IMapper<R,E> {
    public R toRecord(E entity);
    public E toEntity(R record);
}
