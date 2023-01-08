package emlakcepte.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import emlakcepte.model.Realty;
import emlakcepte.model.enums.RealtyStatus;

public interface RealtyRepository extends JpaRepository<Realty, Integer>{

	List<Realty> findAllByUserId(Integer id);

	List<Realty> findAllByStatus(RealtyStatus active);

	

	
	
	

}
