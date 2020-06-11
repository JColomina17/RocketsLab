package Application;

import Application.DTO.RocketDTO;
import Domain.Rocket;
import Persistance.RocketRepository;

public class RocketController {
	public RocketDTO createRocket(RocketDTO rocketDTO) throws Exception {
		Rocket rocket= new Rocket(rocketDTO);
		RocketRepository.storeRocket(rocket);
		
		
		return new RocketDTO(rocket);
		
	}
	
	public RocketDTO getRocketDTO(String name)throws Exception{
		Rocket rocket = RocketRepository.getRocket(name);
		return new RocketDTO(rocket);
	}

}
