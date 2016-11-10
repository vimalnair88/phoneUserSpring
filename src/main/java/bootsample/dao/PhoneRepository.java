package bootsample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import bootsample.model.Phone;
import bootsample.model.User;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

	@Query(value = "select * from lab2.user where id in (select pu.users_id from lab2.phone p join lab2.phone_users pu on p.phone_id=pu.phone_phone_id where p.phone_id=?)", nativeQuery = true)
	List<Object> findUserPhoneNum(int phoneid);
}
