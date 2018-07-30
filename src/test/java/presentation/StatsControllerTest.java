package presentation;

import configuration.ControllerConfiguration;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@WebMvcTest(StatsController.class)
@ContextConfiguration(classes={ControllerConfiguration.class})
public class StatsControllerTest extends TestCase {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testShouldReturn200AndTheStats() throws Exception {
        mvc.perform(get("/statistics")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
