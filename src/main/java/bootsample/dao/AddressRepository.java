package bootsample.dao;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
