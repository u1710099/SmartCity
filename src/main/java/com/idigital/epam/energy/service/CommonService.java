package com.idigital.epam.energy.service;

import java.util.List;

public interface CommonService<T> {
    public List<T> getAll();
    public T getById(Long id);
    public T create(T data) throws Exception;
    public T update(T data) throws Exception;
    public void delete(T data);
}
