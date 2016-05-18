package com.omnido.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class OmnidoWebControllerTest {

	private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".html");

		mvc = MockMvcBuilders.standaloneSetup(new OmnidoWebController())
                .setViewResolvers(viewResolver)
                .build();
	}

    @Test
    public void testWebContentSlash() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
                .andExpect(status().isNotFound());
    }

//	TODO: problem with SpringMVC test - actual integration test works but spring MVC test messes up
//  @Test
//	public void testWebContent() throws Exception {
//
//		mvc.perform(
//                MockMvcRequestBuilders.get("/greeting").accept(MediaType.ALL)
//        )
//				.andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello - Welcome to Omnido!")));
//	}
}
