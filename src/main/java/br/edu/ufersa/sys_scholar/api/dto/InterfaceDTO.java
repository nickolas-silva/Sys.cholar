package br.edu.ufersa.sys_scholar.api.dto;

public interface InterfaceDTO<T>{
    public T convert();
    public void getData(T entity);
}
