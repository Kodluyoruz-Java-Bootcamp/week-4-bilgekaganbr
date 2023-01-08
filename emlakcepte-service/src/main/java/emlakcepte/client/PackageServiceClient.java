package emlakcepte.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@FeignClient(value = "emlakcepte-package", url = "http://localhost:8082/packages")
public interface PackageServiceClient {
	
	@PostMapping
	RealtyPackage create(@RequestBody RealtyPackage realtyPackage);

}
