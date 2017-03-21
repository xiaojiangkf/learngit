package cn.itcast.jx.action.dept;

import java.util.List;

import cn.itcast.jx.action.BaseAction;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Dept;
import cn.itcast.jx1.service.DeptService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class DeptAction extends BaseAction implements ModelDriven<Dept> {
	private Dept model = new Dept();
	@Override
	public Dept getModel() {
		return model;
	}
	
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * 分页查询所有部门
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		deptService.findPage("from Dept", page);
		page.setUrl("deptAction_list");
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}
	
	public String toview() throws Exception {
		Dept dept = deptService.get(model.getId());
		ActionContext.getContext().getValueStack().push(dept);
		return "toview";
	}
	
	public String tocreate() throws Exception {
		List<Dept> list = deptService.findAll();
		ActionContext.getContext().put("deptList", list);
		return "tocreate";
	}
	
	public String insert() throws Exception {
		deptService.saveOrUpdate(model);
		return "insert";
	}
	
	public String todelete() throws Exception {
//		deptService.deleteById(model.getId());	// 单条删除
		String[] ids = model.getId().split(", ");
		for (String string : ids) {
			System.out.println(string);
		}
		deptService.delete(ids);
		return "delete";
	}
	
	public String toupdate() throws Exception {
		Dept dept = deptService.get(model.getId());
		ActionContext.getContext().getValueStack().push(dept);
		List<Dept> list = deptService.findAll();
		// 去除list中的当前Dept
		list.remove(dept);
		ActionContext.getContext().put("deptList", list);
		return "toupdate";
	}
	
	public String update() throws Exception {
		deptService.saveOrUpdate(model);
		System.out.println(model.getState());
		return "update";
	}
	
	
	
	
	
	
}
