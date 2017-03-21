package cn.itcast.jx.action.role;

import cn.itcast.jx.action.BaseAction;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Role;
import cn.itcast.jx1.service.RoleService;

import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends BaseAction implements ModelDriven<Role> {
	private Role model = new Role();
	
	@Override
	public Role getModel() {
		return model;
	}
	
	private RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String list() throws Exception {
		String hql = "from Role";
		Page<Role> list = roleService.findPage(hql, page, Role.class, null);
		page.setUrl("roleAction_list");
		push(list);
		return "list";
	}
	
	public String toview() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		push(role);
		return "toview";
	}
	
	public String tocreate() throws Exception {
		return "tocreate";
	}
	
	public String insert() throws Exception {
		roleService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String toupdate() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		super.push(role);
		return "toupdate";
	}
	
	public String update() throws Exception {
		roleService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		roleService.delete(Role.class, ids);
		return SUCCESS;
	}
	
	
	
	

	
}
