package emlakcepte.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.client.Banner;
import emlakcepte.client.BannerServiceClient;
import emlakcepte.controller.UserController;
import emlakcepte.converter.RealtyConverter;
import emlakcepte.converter.UserConverter;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyStatus;
import emlakcepte.model.enums.UserStatus;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.RealtyRepository;
import emlakcepte.request.RealtyDeleteRequest;
import emlakcepte.request.RealtyRequest;
import emlakcepte.request.RealtyUpdateRequest;
import emlakcepte.response.RealtyResponse;

@Service
public class RealtyService {
	
	private static final int MAX_INDIVIDUAL_REALTY_SIZE = 5;
	
	@Autowired
	private RealtyRepository realtyRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BannerServiceClient bannerServiceClient;
	
	@Autowired
	private RealtyConverter converter;
	
	@Autowired
	private UserConverter userConverter;
	
	public RealtyResponse create(RealtyRequest realtyRequest)
	{
		Logger logger = Logger.getLogger(UserController.class.getName());
		
		Optional<User> foundUser = userService.getById(realtyRequest.getUserId());
		
		/*if (UserType.INDIVIDUAL.equals(foundUser.get().getType()))
		{
			List<Realty> realtyList = realtyRepository.findAllByUserId(foundUser.get().getId());
			
			if (MAX_INDIVIDUAL_REALTY_SIZE == realtyList.size())
			{
				logger.log(Level.WARNING, "Bireysel kullanıcılar en fazla 5 ilan girebilir! userID: {0}"
						,foundUser.get().getId());
			}
		}
		
		if (!foundUser.isPresent())
		{
			System.out.println("User bulunamadı!");
		}*/
		if (UserStatus.LOGGEDIN.equals(foundUser.get().getStatus()))
		{
			List<Realty> realtyList = realtyRepository.findAllByUserId(foundUser.get().getId());
			
			if (userConverter.convert(foundUser.get()).getRealtyPackageList() != null)
			{
				
				if (true)
				{
					logger.log(Level.WARNING, "You do not have the right to post a realty! userID: {0}"
							,foundUser.get().getId());
					
					return null;
				}
				else
				{
					Realty realty = converter.convert(realtyRequest);
					realty.setUser(foundUser.get());
					Realty savedRealty = realtyRepository.save(realty);
					
					Banner bannerRequest = new Banner(String.valueOf(realty.getNo()), 1, "123123", "");

					Banner bannerResponse = bannerServiceClient.create(bannerRequest);
					
					System.out.println("bannerResponse :" + bannerResponse.getAdet());
					
					return converter.convert(savedRealty);
				}
			}
			else
			{
				logger.log(Level.WARNING, "Please buy package before post a realty! userID: {0}"
						,foundUser.get().getId());
				
				return null;
			}
			
				
		}
		else
		{
			logger.log(Level.WARNING, "Please log in before post a realty! userID: {0}"
					,foundUser.get().getId());
			
			return null;
		}
		
		
	}
	
	public RealtyResponse update(RealtyUpdateRequest realtyUpdateRequest)
	{
		Logger logger = Logger.getLogger(UserController.class.getName());
		
		Realty updateRealty = realtyRepository.findAllByUserId(realtyUpdateRequest.getUserId()).stream()
				.filter(realty -> realtyUpdateRequest.getNo().equals(realty.getNo()))
				.findAny()
				.get();
		
		updateRealty.setTitle(realtyUpdateRequest.getTitle());
		updateRealty.setStatus(realtyUpdateRequest.getStatus());
		updateRealty.setOption(realtyUpdateRequest.getOption());
		
		Realty updatedRealty = realtyRepository.save(updateRealty);
		
		logger.log(Level.INFO, "Updated! realtyID: {0}"
				,updatedRealty.getId());
		
		return converter.convert(updatedRealty);
	}
	
	public void delete(RealtyDeleteRequest realtyDeleteRequest)
	{
		
		Realty deleteRealty = realtyRepository.findAllByUserId(realtyDeleteRequest.getUserId()).stream()
				.filter(realty -> realtyDeleteRequest.getNo().equals(realty.getNo()))
				.findAny()
				.get();
		
		System.out.println(deleteRealty);
		
		realtyRepository.delete(deleteRealty);
	}
	
	public List<RealtyResponse> getAll()
	{
		return converter.convert(realtyRepository.findAll());
	}
	
	public List<RealtyResponse> getAllByProvince(String province)
	{
		return getAll()
				.stream()
				.filter(realty -> realty.getProvince().equals(province))
				.toList();
	}
	
	public List<RealtyResponse> getActiveRealtyByUserId(int id)
	{
		return getAll()
				.stream()
				.filter(realty -> realty.getUserId().equals(id))
				.filter(realty -> RealtyStatus.ACTIVE.equals(realty.getStatus())).toList();
	}
	
	public List<RealtyResponse> getPassiveRealtyByUserId(int id)
	{
		return getAll()
				.stream()
				.filter(realty -> realty.getUserId().equals(id))
				.filter(realty -> RealtyStatus.PASSIVE.equals(realty.getStatus())).toList();
	}

	public List<RealtyResponse> getAllById(int id) {
		return converter.convert(realtyRepository.findAllByUserId(id));
	}

	public List<RealtyResponse> getAllActiveRealtyes() {
		return converter.convert(realtyRepository.findAllByStatus(RealtyStatus.ACTIVE));
	}
	
	public List<RealtyResponse> getAllPassiveRealtyes() {
		return converter.convert(realtyRepository.findAllByStatus(RealtyStatus.PASSIVE));
	}

	public List<RealtyResponse> getAllByProvinceAndDistrict(String province, String district) {
		
		return getAll()
				.stream()
				.filter(realty -> realty.getProvince().equals(province))
				.filter(realty -> realty.getDistrict().equals(district))
				.toList();
	}
	
	

	

	

}
