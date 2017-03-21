package cn.itcast.jx1.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.itcast.jx.dao.BaseDao;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Role;
import cn.itcast.jx1.domain.User;
import cn.itcast.jx1.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Role> find(String hql, Class<Role> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Role get(Class<Role> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Role> findPage(String hql, Page<Role> page,
			Class<Role> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Role entity) {
		if(StringUtils.isBlank(entity.getId())) {
			// 新增
			baseDao.saveOrUpdate(entity);
		} else {
			// 修改	先查再改/删
			Role role = baseDao.get(Role.class, entity.getId());
			role.setName(entity.getName());
			role.setRemark(entity.getRemark());
			baseDao.saveOrUpdate(role);
		}
	}

	@Override
	public void saveOrUpdateAll(Collection<Role> entitys) {
		baseDao.saveOrUpdate(entitys);
	}

	@Override
	public void deleteById(Class<Role> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);
	}

	@Override
	public void delete(Class<Role> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			deleteById(entityClass, id);
		}
		
	}

}
