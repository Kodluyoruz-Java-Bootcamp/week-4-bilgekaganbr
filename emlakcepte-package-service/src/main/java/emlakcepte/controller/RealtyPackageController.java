package emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.RealtyPackage;
import emlakcepte.service.RealtyPackageService;



@RestController
@RequestMapping(value = "/packages")
public class RealtyPackageController {
	
	@Autowired
	private RealtyPackageService realtyPackageService;
	
	@PostMapping
	public RealtyPackage create(@RequestBody RealtyPackage realtyPackage)
	{
		realtyPackageService.create(realtyPackage);
		return realtyPackage;
	}
	
	@GetMapping
	public List<RealtyPackage> getAll()
	{
		return realtyPackageService.getAll();
	}
	
	@GetMapping(value = "/{userId}")
	public List<RealtyPackage> getAllByUserId(@PathVariable Integer id)
	{
		return realtyPackageService.getAllByUserId(id);
	}

}
