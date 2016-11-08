package bootsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Phone> findAllPhone(){
		return phoneservice.findAll();	
	}
	/*
	 * Get Details of Phone(Supports JSON as well)
	 */
	
	@GetMapping("/phone/{phoneId}")
	public @ResponseBody Phone findOnePhone(@PathVariable(value="phoneId") int id,
			@RequestParam(value="json",required=true) String json)
	{
		return phoneservice.findOne(id);	
	}
	/*
	 * Creating a phone(Handles Assigns functionality also)
	 */
	@PostMapping("/phone/phoneId")
	public String savePhone(@RequestParam(value="phone",required=true) String phone,
			@RequestParam(value="desc",required=true) String desc,
			@RequestParam(value="street",required=true) String street,
			@RequestParam(value="city",required=true) String city,
			@RequestParam(value="state",required=true) String state,
			@RequestParam(value="zip",required=true) long zip,
			@RequestParam(value="userId",required=false) String userId)
	{
		phoneservice.savePhone(phone,desc,street,city,state,zip,userId);
		return "Phone Saved";
	}
	/*
	 * Updating a phone(Handles assigning also)
	 */
	
	@PostMapping("/phone/{phoneId}")
	public String updatePhone(@PathVariable(value="phoneId") int phoneId,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="desc",required=false) String desc,
			@RequestParam(value="street",required=false) String street,
			@RequestParam(value="city",required=false) String city,
			@RequestParam(value="state",required=false) String state,
			@RequestParam(value="zip",required=false) String zip,
			@RequestParam(value="userId",required=false) String userId)
	{
		phoneservice.updatePhone(phoneId,phone,desc,street,city,state,zip,userId);
		return "Phone Updated";
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
	
	
	@PostMapping("/user/{userID}/assignPhone")
	public @ResponseBody User findOne(@PathVariable(value="userID") int id,
			@RequestParam(value="phone_id",required=true) int phone_id){
		//userService.assignPhone(id, phone_id);
		return userService.getUser(id);
	}
}