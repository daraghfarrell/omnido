package com.omnido.app;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class OmnidoWebIntegrationTest {

    @Value("${local.server.port}")
    private int port;

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}

	@Test
	public void testIndex() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+"/", String.class);
		assertThat(response.getBody(), containsString("Hello - Welcome to Omnido!"));
	}

	@Test
	public void testBlankWebGreeting() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+"/greeting", String.class);
		assertThat(response.getBody(), containsString("Hello - Welcome to Omnido!"));
	}

	@Test
	public void testNamedWebGreetingUsingThymeleaf() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+"/greeting?name=Daragh Farrell", String.class);
		assertThat(response.getBody(), containsString("Hello - Welcome to Omnido! Daragh Farrell"));
	}

	@Test
	public void testGraphFound() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+"/graph", String.class);
		assertThat(response.getBody(), containsString("Omnido Graph"));
	}

	@Test
	public void testAnytodoService() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+"/anytodo", String.class);
		assertThat(response.getBody(), equalTo("{\"id\":1,\"name\":\"anytodo\"}"));
	}

	@Test
	public void testTestJson() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+ "/static/test.json", String.class);
		assertThat(response.getBody(), containsString("{\"id\": \"Myriel\", \"group\": 1}"));
	}
}