package presentation;

import com.google.gson.Gson;
import configuration.ControllerConfiguration;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
@ContextConfiguration(classes={ControllerConfiguration.class})
public class TransactionControllerTest extends TestCase {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testShouldReturn204IfTimestampIsGreaterThan60Seconds() throws Exception {
        TransactionInput ti = new TransactionInput(10, System.currentTimeMillis() - (100 * 1000));

        Gson gson = new Gson();
        String json = gson.toJson(ti);

        mvc.perform(post("/transactions")
                .content(json)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testShouldReturn201IfTransactionIsCorrect() throws Exception {
        TransactionInput ti = new TransactionInput(10, System.currentTimeMillis() - (20 * 1000));

        Gson gson = new Gson();
        String json = gson.toJson(ti);

        mvc.perform(post("/transactions")
                .content(json)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
