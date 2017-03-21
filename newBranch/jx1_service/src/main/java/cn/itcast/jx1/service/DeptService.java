package cn.itcast.jx1.service;

import java.io.Serializable;
import java.util.List;

import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Dept;


public interface DeptService {

	/**
	 * 分页查询
	 * @param hql
	 * @param page
	 * @param params
	 */
	void findPage(String hql, Page page, Object ...params);
	
	/**
	 * 根据id获取Dept
	 * @param id
	 * @return
	 */
	Dept get(String id);
	
	
	/**
	 * 查询所有Dept
	 * @return
	 */
	List<Dept> findAll();
	
	
	/**
	 * 插入Dept
	 * @param entity
	 */
	void saveOrUpdate(Dept entity);
	
	/**
	 * 根据id删除dept
	 * @param entityClass
	 * @param id
	 */
	void deleteById(String id);
	
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String[] ids);
	
}
