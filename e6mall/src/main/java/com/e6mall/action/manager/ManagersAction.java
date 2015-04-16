package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Manager;

public class ManagersAction extends BaseAction {
	private static final long serialVersionUID = -2908710429575286029L;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		list = smanager.findAll();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Manager manager = smanager.findById(checkbox[i]);
			if (null != manager)
				smanager.delete(manager);
		}
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
