package cn.itcast.jx1.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import cn.itcast.jx.common.SysConstant;
import cn.itcast.jx.dao.BaseDao;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.User;
import cn.itcast.jx1.service.UserService;

public class UserServiceImpl implements UserService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List find(String hql, Class entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public User get(Class<User> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<User> findPage(String hql, Page<User> page,
			Class<User> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(User entity) {
		if(StringUtils.isBlank(entity.getId())) {
			// 新增
			String uuid = UUID.randomUUID().toString();
			entity.setId(uuid);
			entity.getUserInfo().setId(uuid);
			baseDao.saveOrUpdate(entity);
		} else {
			// 修改	先查再改/删
			User user = baseDao.get(User.class, entity.getId());
			user.setDept(entity.getDept());
			user.setUserName(entity.getUserName());
			user.setState(entity.getState());
			baseDao.saveOrUpdate(user);
		}
		
	}

	@Override
	public void saveOrUpdateAll(Collection<User> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<User> entityClass, Serializable id) {
//		baseDao.deleteById(entityClass, id);
		User user = baseDao.get(entityClass, id);
		user.setState(SysConstant.USER_DISABLED);
		baseDao.saveOrUpdate(user);
	}

	@Override
	public void delete(Class<User> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			baseDao.deleteById(entityClass, id);
		}
	}

}
