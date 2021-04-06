package com.medilab.preclinic.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medilab.preclinic.bean.DepartmentBean;
import com.medilab.preclinic.bean.DoctorBean;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	
	
	@RequestMapping
	public String viewDoctorBoard(Model model) {
		System.out.println("i am in doctor");
		return "doctor/doctors";
	}
	
	@RequestMapping("/addDoctorPage")
	public String addDoctorPage(Model model) {
		System.out.println("i am in viewDoctorDeptPage");
		model.addAttribute("doctBean", new DoctorBean());
		return "doctor/addDoctors";
	}
	
	@RequestMapping("/addDoctor")
	public String addDept(@ModelAttribute("doctBean") DoctorBean doctBean,Model model) {
		System.out.println("doctBean data is:\t"+doctBean.toString());
		
		return "doctor/doctors";
	}
}
