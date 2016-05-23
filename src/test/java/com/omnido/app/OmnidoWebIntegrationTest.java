package com.omnido.app;

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

import java.net.URL;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class OmnidoWebIntegrationTest {

    @Value("${local.server.port}")
    private int port;

	private URL base;
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}

    @Test
    public void testSlashAutomapsToIndex() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString()+"/", String.class);
        assertThat(response.getBody(), containsString("Hello Omnido"));
    }

    @Test
    public void testIndexIsFound() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString()+"/index.html", String.class);
        assertThat(response.getBody(), containsString("Hello Omnido"));
    }

	@Test
	public void testTestJsonDataIsFound() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString()+ "/test.json", String.class);
		assertThat(response.getBody(), containsString("{\"id\": \"Myriel\", \"group\": 1}"));
	}

    @Test
    public void testAppGreetingFailsAsItRelysOnJavascript() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString()+"/index.html", String.class);
        assertFalse(response.getBody().contains("\"Hello World\""));
    }

    @Test
    public void testGraphPageIsFound() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString()+"/graph.html", String.class);
        assertThat(response.getBody(), containsString("Omnido Graph"));
    }
}