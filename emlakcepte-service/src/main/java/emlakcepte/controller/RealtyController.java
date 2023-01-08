package emlakcepte.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.request.RealtyDeleteRequest;
import emlakcepte.request.RealtyRequest;
import emlakcepte.request.RealtyUpdateRequest;
import emlakcepte.response.RealtyResponse;
import emlakcepte.service.RealtyService;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {
	
	@Autowired
	private RealtyService realtyService;
	
	@PostMapping
	public RealtyResponse create(@RequestBody RealtyRequest realtyRequest)
	{
		RealtyResponse realtyResponse = realtyService.create(realtyRequest);
		return realtyResponse;
	}
	
	@PutMapping(value = "/update")
	public RealtyResponse update(@RequestBody RealtyUpdateRequest realtyUpdateRequest)
	{
		return realtyService.update(realtyUpdateRequest);
	}
	
	@DeleteMapping(value = "/delete")
	public void delete(RealtyDeleteRequest realtyDeleteRequest)
	{
		realtyService.delete(realtyDeleteRequest);
	}
	
	@GetMapping
	public List<RealtyResponse> getAll()
	{
		return realtyService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public List<RealtyResponse> getAllByUserId(@PathVariable Integer id)
	{
		List<RealtyResponse> realtyes = realtyService.getAllById(id);
		return realtyes;
	}
	
	@GetMapping(value = "/active/{id}")
	public List<RealtyResponse> getAllActiveRealtyByUserId(@PathVariable Integer id)
	{
		return realtyService.getActiveRealtyByUserId(id);
	}
	
	@GetMapping(value = "/passive/{id}")
	public List<RealtyResponse> getAllPassiveRealtyByUserId(@PathVariable Integer id)
	{
		return realtyService.getPassiveRealtyByUserId(id);
	}
	
	
	@GetMapping(value = "/status/active")
	public List<RealtyResponse> getAllActiveRealtyes()
	{
		List<RealtyResponse> realtyes = realtyService.getAllActiveRealtyes();
		return realtyes;
	}
	
	@GetMapping(value = "/status/passive")
	public List<RealtyResponse> getAllPassiveRealtyes()
	{
		List<RealtyResponse> realtyes = realtyService.getAllPassiveRealtyes();
		return realtyes;
	}
	
	@GetMapping(value = "realtyesbyprovince/{province}")
	public List<RealtyResponse> getAllByProvince(@PathVariable String province)
	{
		return realtyService.getAllByProvince(province);
	}
	
	@GetMapping(value = "realtyesbyprovince/{province}/realtyesbydistrict/{district}")
	public List<RealtyResponse> getAllByProvinceAndDistrict(@PathVariable String province, @PathVariable String district)
	{
		return realtyService.getAllByProvinceAndDistrict(province, district);
	}
	
	
	
	
	
}
