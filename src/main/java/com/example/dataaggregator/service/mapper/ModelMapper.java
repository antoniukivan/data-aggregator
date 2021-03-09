package com.example.dataaggregator.service.mapper;

public interface ModelMapper<M, D> {
    M getModelFromDto(D requestDto);
}
