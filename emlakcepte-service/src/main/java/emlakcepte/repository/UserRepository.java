package emlakcepte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlakcepte.model.User;
import emlakcepte.response.UserResponse;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

	
	
	

}
