package com.revature.dao;

import java.util.List;

public interface DAO<T> {
    public T addInstance(T instance);
    public List<T> getAllInstances();
    public T updateInstance(T instance);
    public T deleteInstance(T instance);
}
