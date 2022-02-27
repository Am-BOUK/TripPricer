package TripPricer.service;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import tripPricer.Provider;
import tripPricer.TripPricer;

import TripPricer.exception.UUIDException;

@Service
public class TripPriceService {
	private Logger logger = LoggerFactory.getLogger("TripPricerService");
	private TripPricer tripPricer = new TripPricer();
	private final static Pattern UUID_REGEX_PATTERN = Pattern
			.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

	/**
	 * get Price of the TripPricer
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
	public List<Provider> getPriceTripPricer(String apiKey, String attractionId, int adults, int children,
			int nightsStay, int rewardsPoints) throws UUIDException {
		logger.debug("getPriceTripPricer");
		if (!isValidUUID(attractionId)) {
			logger.error("format UUID of userId invalid!");
			throw new UUIDException("format UUID attractionId is invalid!");
		}
		UUID attractionIdUUID = UUID.fromString(attractionId);

		return tripPricer.getPrice(apiKey, attractionIdUUID, adults, children, nightsStay, rewardsPoints);
	}

	private static boolean isValidUUID(String str) {
		if (str == null) {
			return false;
		}
		return UUID_REGEX_PATTERN.matcher(str).matches();
	}
}
