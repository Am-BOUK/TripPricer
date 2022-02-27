package TripPricerController;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import TripPricer.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TripPricerControllerIT {

	@Autowired
	private MockMvc mock;

	@Test
	public void getPriceTest() throws Exception {

		mock.perform(get("/getPrice").param("apiKey", "").param("attractionId", String.valueOf(UUID.randomUUID()))
				.param("adults", "1").param("children", "1").param("nightsStay", "1").param("rewardsPoints", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(5)));
	}

}
