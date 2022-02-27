package TripPricerService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import TripPricer.Application;
import TripPricer.exception.UUIDException;
import TripPricer.service.TripPriceService;
import tripPricer.Provider;
import tripPricer.TripPricer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TripPricerServiceTest {

	@Autowired
	private TripPriceService tripPriceService;

	@Test
	public void getPriceTripPricerTest() throws UUIDException {
		List<Provider> result = null;

		result = tripPriceService.getPriceTripPricer("", String.valueOf(UUID.randomUUID()), 1, 1, 1, 1);
		assertNotNull(result);
		assertEquals(5, result.size());
	}

	@Test
	public void getPriceTripPricerTest_whenUUIDIsNull_shouldReturnUUIDException() {

		try {
			tripPriceService.getPriceTripPricer("", "", 1, 1, 1, 1);
		} catch (UUIDException e) {
			assertTrue(e instanceof UUIDException);
			assertTrue(e.getMessage().contains("format UUID attractionId is invalid!"));
		}
	}


}
