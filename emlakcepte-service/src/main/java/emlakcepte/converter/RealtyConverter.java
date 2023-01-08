package emlakcepte.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import emlakcepte.model.Realty;
import emlakcepte.request.RealtyRequest;
import emlakcepte.response.RealtyResponse;

@Component
public class RealtyConverter {
	
	public Realty convert(RealtyRequest realtyRequest)
	{
		Realty realty = new Realty();
		realty.setNo(realtyRequest.getNo());
		realty.setTitle(realtyRequest.getTitle());
		realty.setProvince(realtyRequest.getProvince());
		realty.setDistrict(realtyRequest.getDistrict());
		realty.setCreateDate(LocalDateTime.now());
		realty.setStatus(realtyRequest.getStatus());
		realty.setType(realtyRequest.getType());
		realty.setOption(realtyRequest.getOption());
		return realty;
	}
	
	public RealtyResponse convert(Realty realty)
	{
 		
		RealtyResponse realtyResponse = new RealtyResponse();
		realtyResponse.setId(realty.getId());
		realtyResponse.setNo(realty.getNo());
		realtyResponse.setTitle(realty.getTitle());
		realtyResponse.setProvince(realty.getProvince());
		realtyResponse.setDistrict(realty.getDistrict());
		realtyResponse.setStatus(realty.getStatus());
		realtyResponse.setType(realty.getType());
		realtyResponse.setOption(realty.getOption());
		realtyResponse.setUserId(realty.getUser().getId());
		return realtyResponse;
		
	}
	
	public List<RealtyResponse> convert(List<Realty> realtyList)
	{
		List<RealtyResponse> realtyResponses = new ArrayList<>();
		
		realtyList.stream().forEach(realty -> realtyResponses.add(convert(realty)));
		return realtyResponses;
		
	}

}
