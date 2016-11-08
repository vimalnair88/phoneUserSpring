package bootsample.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bootsample.dao.AddressRepository;
import bootsample.model.Address;

@Transactional
@Service
public class AddressService {
	
	private final AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository) {
	this.addressRepository = addressRepository;
	}

	public void saveAddress(Address address){
		addressRepository.save(address);
	}
	
	public Address getAddress(int id){
		return addressRepository.findOne(id);
	}
	
}
