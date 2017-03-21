package cn.itcast.jx1.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Module;

public interface ModuleService {

	//查询所有，带条件查询
	List<Module> find(String hql, Class<Module> entityClass, Object[] params);
	//获取一条记录
	Module get(Class<Module> entityClass, Serializable id);
	//分页查询，将数据封装到一个page分页工具类对象
	Page<Module> findPage(String hql, Page<Module> page, Class<Module> entityClass, Object[] params);
	
	//新增和修改保存
	void saveOrUpdate(Module entity);
	//批量新增和修改保存
	void saveOrUpdateAll(Collection<Module> entitys);
	
	//单条删除，按id
	void deleteById(Class<Module> entityClass, Serializable id);
	//批量删除
	void delete(Class<Module> entityClass, Serializable[] ids);
}
