package cn.itcast.jx1.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.User;

public interface UserService {

	//查询所有，带条件查询
	List find(String hql, Class entityClass, Object[] params);
	//获取一条记录
	User get(Class<User> entityClass, Serializable id);
	//分页查询，将数据封装到一个page分页工具类对象
	Page<User> findPage(String hql, Page<User> page, Class<User> entityClass, Object[] params);
	
	//新增和修改保存
	void saveOrUpdate(User entity);
	//批量新增和修改保存
	void saveOrUpdateAll(Collection<User> entitys);
	
	//单条删除，按id
	void deleteById(Class<User> entityClass, Serializable id);
	//批量删除
	void delete(Class<User> entityClass, Serializable[] ids);
}
