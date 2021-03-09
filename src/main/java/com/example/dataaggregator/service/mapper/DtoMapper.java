package com.example.dataaggregator.service.mapper;

public interface DtoMapper<M, D> {
    D getDtoFromModel(M entity);
}
