package bootsample.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bootsample.model.User;
import bootsample.service.UserService;


@Controller
public class MainController {


	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		return "index";
	}
	
	@GetMapping("/user/userId")
	public String createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		return "createUser";
	}
	
	@PostMapping("/user/userId")
	public @ResponseBody String createUser(@RequestParam(value="fname",required=true) String fname,
			@RequestParam(value="lname",required=true) String lname,
			@RequestParam(value="title",required=true) String title,
			@RequestParam(value="street",required=true) String street,
			@RequestParam(value="city",required=true) String city,
			@RequestParam(value="state",required=true) String state,
			@RequestParam(value="zip",required=true) long zip,
			@RequestParam(value="phoneno1",required=true) String no1,
			@RequestParam(value="desc1",required=true) String desc1,
			@RequestParam(value="phoneno2",required=false) String no2,
			@RequestParam(value="desc2",required=false) String desc2,
			@RequestParam(value="phoneno3",required=false) String no3,
			@RequestParam(value="desc3",required=false) String desc3
			)
	{
		User user = userService.createUser(fname,lname,title,street,city,state,zip,no1,desc1,no2,desc2,no3,desc3);
		//return "Task Saved";
		return "redirect:/user/" + user.getId();
	}
/*	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request){
		task.setDateCreated(new Date());
		taskService.save(task);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("task", taskService.findTask(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id, HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
*/	
}
