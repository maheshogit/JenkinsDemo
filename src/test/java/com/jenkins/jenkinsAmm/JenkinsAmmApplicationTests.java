package com.jenkins.jenkinsAmm;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class JenkinsAmmApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllEmployees() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllEmployees")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getEmployeeByNo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getEmployeeById/2")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	@Test
	public void returnsNotFoundEmployeeByNo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getEmployeeById/7")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andReturn();
	}

	@Test
	public void insertEmployees() throws Exception {
		/*File input = new File("C:\\Users\\MAHESH\\Downloads\\emp.csv");
		File output = new File("output.json");

		CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
		CsvMapper csvMapper = new CsvMapper();

		// Read data from CSV file
		List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();

		ObjectMapper mapper = new ObjectMapper();

		// Write JSON formated data to output.json file
		mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);

		String str=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll);*/

		String employeedata= "{\"empId\":\"2\",\"empName\":\"mahesh123\",\"empSalary\":\"2000\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/insertEmployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(employeedata)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

}
