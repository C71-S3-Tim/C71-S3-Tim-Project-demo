package com.yc.spirngboot.takeout.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class admInfo {

	@GetMapping("admin/adminfo")
	public String adminfo(Model m) {
		return "admin/admininfo";
	}
}
