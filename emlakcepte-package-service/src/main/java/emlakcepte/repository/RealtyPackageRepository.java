package emlakcepte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emlakcepte.model.RealtyPackage;





public interface RealtyPackageRepository extends JpaRepository<RealtyPackage, Integer>{

	List<RealtyPackage> findAllByUserId(Integer id);

}
