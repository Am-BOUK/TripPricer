package TripPricer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import TripPricer.exception.UUIDException;
import TripPricer.service.TripPriceService;
import tripPricer.Provider;

@RestController
public class TripPricerContoller {

	@Autowired
	private TripPriceService tripPriceService;

	/**
	 * get Price of the TripPricer endpoint
	 * 
	 * @param apiKey        : the api key String
	 * @param attractionId  : the attractionId UUID
	 * @param adults        : adults int number
	 * @param children      : children int number
	 * @param nightsStay    : nightsStay int period
	 * @param rewardsPoints : rewards Points int
	 * @return Provider list : list of provider contains name, price and trip id
	 * @throws UUIDException 
	 */
	@GetMapping("/getPrice")
	public List<Provider> getPrice(
			@RequestParam String apiKey, 
			@RequestParam String attractionId, 
			@RequestParam int adults,
			@RequestParam int children, 
			@RequestParam int nightsStay, 
			@RequestParam int rewardsPoints) throws UUIDException {
		return tripPriceService.getPriceTripPricer(apiKey, attractionId, adults, 
				children, nightsStay, rewardsPoints);

	}
}
