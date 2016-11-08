package bootsample.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootsample.dao.PhoneRepository;
import bootsample.model.Address;
import bootsample.model.Phone;
import bootsample.model.User;

@Transactional
@Service
public class PhoneService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	private final PhoneRepository phoneRepository;
	
	public PhoneService(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}
	public List<Phone> findAll(){
		List<Phone> phone = new ArrayList<Phone>();
		for(Phone phones : phoneRepository.findAll()){
			phone.add(phones);
		}
		return phone;
	}
	public Phone findOne(int id){
		return phoneRepository.findOne(id);
	}
	
	
	public String deletePhone(int phoneId){
		
		Phone phone = phoneRepository.findOne(phoneId);
		if(phone.getUsers().size()== 0){
			phoneRepository.delete(phoneId);
			return "Delete Successfull";
		}else{
			return "Delete UnSuccessfull";
		}
	}
	public void savePhone(String phone,String desc,String street,String city,String state,long zip,String userId){
		
	Address address = new Address(street,city,state,zip);
	addressService.saveAddress(address);
	long phoneNum = Long.parseLong(phone);
	Phone newPhone = new Phone(phoneNum,desc,address);
	phoneRepository.save(newPhone);
	if(!(userId==null)){
	User user = userService.getUser(Integer.parseInt(userId));
	if(newPhone.getUsers()==null){
		Set<User> set = new HashSet<>();
		set.add(user);
		newPhone.setUsers(set);
	}else{
		newPhone.getUsers().add(user);
	}
	}
	phoneRepository.save(newPhone);	
	}
	public void updatePhone(int phoneId,String phone,String desc,String street,String city,String state,String zip,String userId){
		
		Phone updatePhone = phoneRepository.findOne(phoneId);
		if(!(phone==null)){
			updatePhone.setPhoneNumber(Long.parseLong(phone));
		}
		if(!(desc==null)){
			updatePhone.setDesc(desc);
		}
		if(!(street==null)){
			updatePhone.getAddress().setStreet(street);
		}
		if(!(city==null)){
			updatePhone.getAddress().setCity(city);
		}
		if(!(state==null)){
			updatePhone.getAddress().setState(state);
		}
		if(!(zip==null)){
			updatePhone.getAddress().setZip(Long.parseLong(zip));
		}
		if(!(userId==null)){
			User user = userService.getUser(Integer.parseInt(userId));
			if(updatePhone.getUsers()==null){
				Set<User> set = new HashSet<>();
				set.add(user);
				updatePhone.setUsers(set);
			}else{
				updatePhone.getUsers().add(user);
			}
		}
		phoneRepository.save(updatePhone);
		
}
	public void save(Phone phone){
		phoneRepository.save(phone);
	}
	public void delete(int id){
		phoneRepository.delete(id);
	}
	public Phone getPhone(int id){
		return phoneRepository.findOne(id);
	}
	

}
