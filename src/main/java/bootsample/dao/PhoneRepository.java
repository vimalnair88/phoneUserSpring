package bootsample.dao;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

}
