package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.model.RealtyPackage;
import emlakcepte.repository.RealtyPackageRepository;




@Service
public class RealtyPackageService {
	
	@Autowired
	private RealtyPackageRepository realtyPackageRepository;
	
	public void create(RealtyPackage realtyPackage)
	{
		realtyPackageRepository.save(realtyPackage);
	}
	
	public List<RealtyPackage> getAll()
	{
		return realtyPackageRepository.findAll();
	}
	
	public List<RealtyPackage> getAllByUserId(Integer id)
	{
		return realtyPackageRepository.findAllByUserId(id);
	}
	

}
