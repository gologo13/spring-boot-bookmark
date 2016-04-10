package com.gologo13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

//import static org.assertj.core.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookmarkServiceApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class BookmarkServiceApplicationTests {

    @Value("${local.server.port")
    int port;

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testHome() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port, String.class);
//        assertThat(response.getStatusCode()).is(HttpStatus.OK);
//        assertThat(response.getBody()).is("Hello World!");
    }

}
