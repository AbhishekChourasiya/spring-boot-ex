package com.siddu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginuser")
	public String login(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password, ModelMap teacherModel) {

		if(!name.equals(password)){
			teacherModel.addAttribute("msg", "Invalid Login");
			return "login";
		}
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		return "teachers";
	}

	@RequestMapping("/teacher/{id}") // by default Requestmethod is GET
	public String getTeacher(@PathVariable int id, ModelMap teacherModel) {
		Teacher teacher = teacherService.getTeacher(id);
		teacherModel.addAttribute("teacher", teacher);
		teacherModel.addAttribute("msg", "");
		return "teacher";
	}

	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public String getTeachers(ModelMap teacherModel) {
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		return "teachers";
	}

	@RequestMapping(value = "addTeacher")
	public String addPage() {
		return "add";
	}

	@RequestMapping(value = "/add/teacher", method = RequestMethod.POST)
	public String addTeacher(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "expertise", required = true) String expertise, ModelMap teacherModel) {
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setExpertise(expertise);
		teacherService.addTeacher(teacher);
		teacherModel.addAttribute("msg", "Teacher added successfully");
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		return "teachers";
	}

	@RequestMapping(value = "update/teacher/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap teacherModel) {
		teacherModel.addAttribute("id", id);
		Teacher teacher = teacherService.getTeacher(id);
		teacherModel.addAttribute("teacher", teacher);
		return "update";
	}

	@RequestMapping(value = "/update/teacher", method = RequestMethod.POST)
	public String updateTeacher(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "expertise", required = true) String expertise, ModelMap teacherModel) {
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setName(name);
		teacher.setExpertise(expertise);
		teacherService.updateTeacher(teacher);
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		teacherModel.addAttribute("id", id);
		teacherModel.addAttribute("msg", "Teacher updated successfully");
		return "teachers";
	}

	@RequestMapping(value = "/delete/teacher/{id}")
	public String deleteTeacher(@PathVariable int id, ModelMap teacherModel) {
		teacherService.deleteTeacher(id);
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		teacherModel.addAttribute("msg", "Teacher delted successfully");
		return "teachers";
	}
	
	@RequestMapping(value = "logout")
	public String logout() {
		return "login";
	}

}