package cn.itcast.jx1.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.itcast.jx.common.SysConstant;
import cn.itcast.jx.dao.BaseDao;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Module;
import cn.itcast.jx1.service.ModuleService;

public class ModuleServiceImpl implements ModuleService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Module> find(String hql, Class<Module> entityClass,
			Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Module get(Class<Module> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Module> findPage(String hql, Page<Module> page,
			Class<Module> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Module entity) {
		if(StringUtils.isBlank(entity.getId())) {
			// 新增
			baseDao.saveOrUpdate(entity);
		} else {
			// 修改
			Module module = baseDao.get(Module.class, entity.getId());
			module.setName(entity.getName());
			module.setLayerNum(entity.getLayerNum());
			module.setCpermission(entity.getCpermission());
			module.setCurl(entity.getCurl());
			module.setCtype(entity.getCtype());
			module.setState(entity.getState());
			module.setBelong(entity.getBelong());
			module.setCwhich(entity.getCwhich());
			module.setRemark(entity.getRemark());
			module.setOrderNo(entity.getOrderNo());
			baseDao.saveOrUpdate(module);
		}
	}

	@Override
	public void saveOrUpdateAll(Collection<Module> entitys) {
		baseDao.saveOrUpdate(entitys);
	}

	@Override
	public void deleteById(Class<Module> entityClass, Serializable id) {
		// 不删除	设置标记
		Module module = baseDao.get(entityClass, id);
		module.setState(SysConstant.MODULE_DISABLED);
		baseDao.saveOrUpdate(module);
	}

	@Override
	public void delete(Class<Module> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			deleteById(entityClass, id);
		}
	}

}
