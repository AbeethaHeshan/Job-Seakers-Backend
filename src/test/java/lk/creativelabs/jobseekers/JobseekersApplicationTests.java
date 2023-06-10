package lk.creativelabs.jobseekers;

import lk.creativelabs.jobseekers.service.JobCatogaryService;
import lk.creativelabs.jobseekers.util.ResponseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
@AutoConfigureMockMvc
class JobseekersApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	JobCatogaryService jobCatogaryService;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllCategories() throws Exception {

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/getAll")
				.contentType(MediaType.APPLICATION_JSON));

	}

}
