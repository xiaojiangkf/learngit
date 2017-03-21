package cn.itcast.jx.action.module;

import org.apache.poi.ss.formula.functions.Odd;

import javassist.bytecode.analysis.ControlFlow.Node;
import cn.itcast.jx.action.BaseAction;
import cn.itcast.jx.util.Page;
import cn.itcast.jx1.domain.Module;
import cn.itcast.jx1.service.ModuleService;

import com.opensymphony.xwork2.ModelDriven;

public class ModuleAction extends BaseAction implements ModelDriven<Module>{
	private Module model = new Module();
	@Override
	public Module getModel() {
		return model;
	}
	
	private ModuleService moduleService;
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String list() throws Exception {
		moduleService.findPage("from Module", page, Module.class, null);
		page.setUrl("moduleAction_list");
		push(page);
		return "list";
	}
	
	public String toview() throws Exception {
		Module module = moduleService.get(Module.class, model.getId());
		push(module);
		return "toview";
	}
	
	public String tocreate() throws Exception {
//		Module module = moduleService.get(Module.class, model.getId());
//		push(module);
		return "tocreate";
	}
	
	public String insert() throws Exception {
		moduleService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String toupdate() throws Exception {
		Module module = moduleService.get(Module.class, model.getId());
		push(module);
		return "toupdate";
	}
	
	public String update() throws Exception {
		moduleService.saveOrUpdate(model);
		return SUCCESS; 
	}
	
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		moduleService.delete(Module.class, ids);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
