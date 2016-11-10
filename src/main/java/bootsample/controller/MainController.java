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
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/user/getUserId")
	public @ResponseBody ModelAndView getUserId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return new ModelAndView("getUserId");
	}
	
	@PostMapping("/user/getUserId")
	public @ResponseBody void postUserId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String ids = (String)request.getParameter("userId");
		int id = Integer.parseInt(ids);
		response.sendRedirect("/user/"+id);
	}
	
	/*
	 * Create an User
	 */
	@PostMapping("/user/userId")
	public @ResponseBody void createUser(HttpServletResponse response, @RequestParam(value="fname",required=true) String fname,
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
			) throws IOException
	{
		User user = userService.createUser(fname,lname,title,street,city,state,zip,no1,desc1,no2,desc2,no3,desc3);
		//return "Task Saved";
		response.sendRedirect("/user/"+user.getId());
	}
	
}
