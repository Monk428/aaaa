package com.monk.sbbook.service;

import java.util.List;

/**
 * jpa增强，支持sql查询并支持分页
 */
public interface DynamicQuery {

    public void save(Object entity);
    public void update(Object entity);
    public <T> void delete(Class<T> entityClass, Object entityid);
    public <T> void delete(Class<T> entityClass, Object[] entityids);

    /**
     * 查询对象列表，返回list
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryList(String nativeSql, Object... params);

    /**
     * 返回List<Map<key,value>>
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryListMap(String nativeSql, Object... params);

    /**
     * 返回List<组合对象>
     * @param resultClass
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T>  nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params);

    /**
     * 执行nativeSql统计查询
     * @param nativeSql
     * @param params
     * @return
     */
    Long nativeQueryCount(String nativeSql, Object... params);
}
