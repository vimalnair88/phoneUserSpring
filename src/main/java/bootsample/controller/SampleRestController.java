package bootsample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import bootsample.model.User;
import bootsample.service.AddressService;
import bootsample.service.PhoneService;
import bootsample.service.UserService;

@RestController
public class SampleRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private AddressService addressService;

	/*
	 * Get User as HTML(Handles JSON also)
	 */
/*	@GetMapping("/user/userId")
	public String createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		return "createUser";
	}
*/	
	@GetMapping("/user/{userId}")
	public @ResponseBody  ModelAndView getUserJson(HttpServletRequest request, @PathVariable(value="userId") int id,
			@RequestParam(value="json",required=false) String json){		
		User user = userService.getUser(id);
		if(!(json==null)){
			ModelMap model = new ModelMap();
			model.addAttribute("user", user);
			model.addAttribute("phones", user.getPhones());
			ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView(), model) ;
			return modelAndView;
		}else{
		ModelMap model = new ModelMap();
		model.addAttribute("user", user);
		model.addAttribute("phones", user.getPhones());
		return new ModelAndView("getUser", model);
		}
	}
	
	
	@GetMapping("/getUsers")
	public  List<User> getAllUsers(){
		return userService.findAll();
	}
	/*
	 * Create an User
	 */
	
/*	@PostMapping("/user/userId")
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
	}*/
	
	/*
	 *Update an user 
	 */
	
	@PostMapping("/user/{userId}")
	public @ResponseBody void updateUser(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="userId",required=true) int id,
			@RequestParam(value="fname",required=false) String fname,
			@RequestParam(value="lname",required=false) String lname,
			@RequestParam(value="title",required=false) String title,
			@RequestParam(value="street",required=false) String street,
			@RequestParam(value="city",required=false) String city,
			@RequestParam(value="state",required=false) String state,
			@RequestParam(value="zip",required=false) String zip
			) throws IOException
	{
		userService.updateUser(id,fname,lname,title,street,city,state,zip);
		response.sendRedirect("/user/"+id);
	}
	/*
	 * Delete an User
	 */
	
	@DeleteMapping("/user/{userID}")
	public String deleteUser(@PathVariable(value="userID") int id ){		
		userService.delete(id);
		return "Delete Successful";
	}
}
