package cn.itcast.jx.action.user;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javassist.expr.NewArray;
import cn.itcast.jx.action.BaseAction;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Dept;
import cn.itcast.jx1.domain.Role;
import cn.itcast.jx1.domain.User;
import cn.itcast.jx1.service.RoleService;
import cn.itcast.jx1.service.UserService;

import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User> {
	private User model = new User();

	@Override
	public User getModel() {
		return model;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
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
		String hql = "from User";
		Page<User> list = userService.findPage(hql, page, User.class, null);
		page.setUrl("userAction_list");
		super.push(list);
		return "list";
	}
	
	public String toview() throws Exception {
		User user = userService.get(User.class, model.getId());
		push(user);
		return "toview";
	}
	
	public String tocreate() throws Exception {
		List<Dept> dList = userService.find("from Dept where state=1", Dept.class, null);
		List<User> uList = userService.find("from User where state=1", User.class, null);
		put("deptList", dList);
		put("userList", uList);
		return "tocreate";
	}
	
	public String insert() throws Exception {
		userService.saveOrUpdate(model);
		return "insert";
	}
	
	public String toupdate() throws Exception {
		List<Dept> dList = userService.find("from Dept where state=1", Dept.class, null);
		put("deptList", dList);
		User user = userService.get(User.class, model.getId());
		push(user);
		return "toupdate";
	}
	
	public String update() throws Exception {
		userService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		userService.delete(User.class, ids);;
		return SUCCESS;
	}
	
	public String torole() throws Exception {
		User user = userService.get(User.class, model.getId());
		push(user);
		List<Role> list = roleService.find("from Role", Role.class, null);
		put("roleList", list);
		/*StringBuffer sb = new StringBuffer();
		for (Role role : list) {
			sb.append(role.getName());
		}
		String userRoleString = sb.toString();
		push(userRoleString);
		System.out.println(userRoleString);*/
		return "torole";
	}
	
	
	

}
