package bootsample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import bootsample.model.Phone;
import bootsample.model.User;
import bootsample.service.PhoneService;
import bootsample.service.UserService;

@RestController
public class PhoneRESTController {

	@Autowired
	private PhoneService phoneservice;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/phone")
	public ModelAndView createPhone(){
		return new ModelAndView("createPhone");
	}
	/*
	 * Get Details of Phone(Supports JSON as well)
	 */
	
	@GetMapping("/phone/{phoneId}")
	public ModelAndView findOnePhone(HttpServletResponse response,@PathVariable(value="phoneId") int id,
			@RequestParam(value="json",required=false) String json)
	{
		Phone phone = phoneservice.findOne(id);
		if(phone==null){
			response.setStatus(404);			
			ModelMap model = new ModelMap();
			String message = "Sorry, the requested phone with ID "+id+" does not exist";
			model.addAttribute("error",message);
			model.addAttribute("code", "404 Not Found");
			ModelAndView modelAndView;
			if(!(json==null)){
				modelAndView = new ModelAndView(new MappingJackson2JsonView(),model);
			}else{
				modelAndView = new ModelAndView("notFound",model);	
			}
			return modelAndView;
		}else{
			if(!(json==null)){
				ModelMap model = new ModelMap();
				model.addAttribute("phone", phone);
				model.addAttribute("address", phone.getAddress());
				model.addAttribute("user",userService.findUserbyPhone(id));
				model.addAttribute("NotAssigned",userService.findUserNotAssigned(id));
				ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView(), model) ;
				return modelAndView;
			}else{
			ModelMap model = new ModelMap();
			model.addAttribute("phone", phone);
			model.addAttribute("address", phone.getAddress());
			model.addAttribute("user",userService.findUserbyPhone(id));
			model.addAttribute("NotAssigned",userService.findUserNotAssigned(id));
			return new ModelAndView("getPhone", model);
		}
		}
	}
	/*
	 * Creating a phone(Handles Assigns functionality also)
	 */
	@PostMapping("/phone/phoneId")
	public void savePhone(HttpServletResponse response, @RequestParam(value="phone",required=true) String phone,
			@RequestParam(value="desc",required=true) String desc,
			@RequestParam(value="street",required=true) String street,
			@RequestParam(value="city",required=true) String city,
			@RequestParam(value="state",required=true) String state,
			@RequestParam(value="zip",required=true) long zip,
			@RequestParam(value="userId",required=false) String userId) throws IOException
	{
		Phone newPhone = phoneservice.savePhone(phone,desc,street,city,state,zip,userId);
		//return "Phone Saved";
		response.sendRedirect("/phone/" + newPhone.getPhone_id());
	}
	/*
	 * Updating a phone(Handles assigning also)
	 */
	
	@PostMapping("/phone/{phoneId}")
	public void updatePhone(HttpServletResponse response, @PathVariable(value="phoneId") int phoneId,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="desc",required=false) String desc,
			@RequestParam(value="street",required=false) String street,
			@RequestParam(value="city",required=false) String city,
			@RequestParam(value="state",required=false) String state,
			@RequestParam(value="zip",required=false) String zip,
			@RequestParam(value="userId",required=false) String userId) throws IOException
	{
		Phone updatedPhone = phoneservice.updatePhone(phoneId,phone,desc,street,city,state,zip,userId);
		//return "Phone Updated";
		response.sendRedirect("/phone/" + updatedPhone.getPhone_id());
	}

	/*
	 * Deleting a phone service
	 */
	
	@DeleteMapping("/phone/{phoneId}")
	public ResponseEntity<String> deletePhone(@PathVariable(value="phoneId") int phoneId)
	{
		String status = phoneservice.deletePhone(phoneId);
		if(status.equals("Delete Successfull")){
			return ResponseEntity.ok("Delete Successfull");			
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Users Exist, Delete UnSuccessfull!");
		}		
	}
	
	@PostMapping("/phone/delete/{phoneId}")
	public ModelAndView deletePostPhone(HttpServletResponse response, @PathVariable(value="phoneId") int phoneId)
	{
		String status = phoneservice.deletePhone(phoneId);
		ModelMap model = new ModelMap();
		String message;
		if(status.equals("Delete Successfull")){
			message = "Delete Successfull";
			model.addAttribute("error",message);			
			return new ModelAndView("createPhone",model);
		}else{
			message = "Users Exit, Delete Unsuccessfull!";
			model.addAttribute("error",message);
			model.addAttribute("code","400 Bad Request");
			return new ModelAndView("notFound",model);
		}		
	}
	@PostMapping("phone/addUser/{phone_id}/{id}")
	public void addUsertoPhone(HttpServletResponse response,@PathVariable(value="id") int id,
	@PathVariable(value="phone_id") int phone_id) throws IOException{
		userService.addUsertoPhone(id, phone_id);
		response.sendRedirect("/phone/" +phone_id );
	}
	@PostMapping("phone/deleteUser/{phone_id}/{id}")
	public void removeUsertoPhone(HttpServletResponse response,@PathVariable(value="id") int id,
	@PathVariable(value="phone_id") int phone_id) throws IOException{
		userService.removeUsertoPhone(id, phone_id);
		response.sendRedirect("/phone/" +phone_id );
	}
		
	@PostMapping("/user/{userID}/assignPhone")
	public @ResponseBody User findOne(@PathVariable(value="userID") int id,
			@RequestParam(value="phone_id",required=true) int phone_id){
		//userService.assignPhone(id, phone_id);
		return userService.getUser(id);
	}
}
