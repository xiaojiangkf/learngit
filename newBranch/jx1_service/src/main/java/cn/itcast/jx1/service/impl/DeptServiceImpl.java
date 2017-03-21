package cn.itcast.jx1.service.impl;

import java.util.List;

import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

import cn.itcast.jx.common.SysConstant;
import cn.itcast.jx.dao.BaseDao;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Dept;
import cn.itcast.jx1.service.DeptService;

public class DeptServiceImpl implements DeptService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void findPage(String hql, Page page, Object... params) {
		baseDao.findPage(hql, page, Dept.class, params);
	}

	@Override
	public Dept get(String id) {
		return baseDao.get(Dept.class, id);
	}

	@Override
	public List<Dept> findAll() {
		return baseDao.find("from Dept", Dept.class, null);
	}

	@Override
	public void saveOrUpdate(Dept entity) {
		if(StringUtils.isBlank(entity.getId())) {
			// 新增
			entity.setState(SysConstant.DEPT_ENABLED);
			baseDao.saveOrUpdate(entity);
		} else {
			// 修改	先查再改	先查再删
			Dept dept = baseDao.get(Dept.class, entity.getId());
			dept.setDeptName(entity.getDeptName());
			dept.setParent(entity.getParent());
			dept.setState(entity.getState());
			baseDao.saveOrUpdate(dept);
		}
	}

	@Override
	public void deleteById(String id) {
		
		/*删除的三种方式：
		1.	递归删除父子部门
		2.	删除父项时，子项不删除，因为子项可以进入其它 部门
		先更新子项所属的父部门，这样当前这个父部门下就没有子部门，直接删除父部门
		3.	结合状态字段，假删除（本质是修改状态字段），递归修改*/
		// 判断是否有子部门
		// 条件查询，条件为parent_id = dept_id
		
		/*// 递归删除子部门，然后删除父部门
//		String hql = "from Dept where PARENT_ID='" + id + "'";
//		List<Dept> list = baseDao.find(hql, Dept.class,null);
		String hql = "from Dept where parent.id=?";
		List<Dept> list = baseDao.find(hql, Dept.class,new String[]{id});
		if(list != null && list.size() > 0) {
			for (Dept dept : list) {
				deleteById(dept.getId());
			}
		}
		baseDao.deleteById(Dept.class, id);*/
		
		/*// 子项不删除	修改子项的parent_id为null
		String hql = "from Dept where PARENT_ID='" + id + "'";
		List<Dept> list = baseDao.find(hql, Dept.class,null);
		if(list.size() > 0) {
//			for (Dept dept : list) {
//				System.out.println(dept.getParent().getId());
//				dept.getParent().setId("1");
//				System.out.println(dept.getParent().getId());
//				baseDao.saveOrUpdate(dept);
//			}
			for(int i = 0; i < list.size(); i ++) {
//				Dept dept = new Dept();
//				dept.setId("100");
//				Dept dept1 = list.get(i);
//				dept1.setParent(dept);
//				baseDao.saveOrUpdate(dept1);
				Dept dept = list.get(i);
				dept.setParent(null);
				baseDao.saveOrUpdate(dept);
			}
		}
		baseDao.deleteById(Dept.class, id);*/
		
		// 直接修改父项的state
		Dept dept = baseDao.get(Dept.class, id);
		dept.setState(SysConstant.DEPT_DISABLED);
		baseDao.saveOrUpdate(dept);
	}

	public void delete(String[] ids) {
		for (String id : ids) {
			deleteById(id);
		}
	}
}
