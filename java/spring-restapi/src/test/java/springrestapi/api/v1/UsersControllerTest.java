package springrestapi.api.v1;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springrestapi.bootstrap.Bootstrap;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UsersControllerTest {

    @Autowired
    private UsersController usersController;
    private MockMvc mvc;

    private String convertToJson(Object data) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Test
    void get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v1/users").accept("application/json"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.data[0].lastName", new IsEqual<>("Adamus")))
            .andReturn();
    }

    @Test
    void post() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/users")
            .accept("application/json")
            .contentType("application/json")
            .content(convertToJson(new HashMap<String, String>() {{
                put("id", "e96b6f1f-30ee-4227-a090-eb2bd452f2f0");
                put("firstName", "Paweł");
                put("lastName", "Kowalski");
                put("username", "pawel.kowalski");
                put("gender", "m");
            }}));

        mvc.perform(requestBuilder)
            .andExpect(status().isCreated())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.data.id", new IsEqual<>("e96b6f1f-30ee-4227-a090-eb2bd452f2f0")))
            .andReturn();
    }

    @Test
    void postError() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/users")
            .accept("application/json")
            .contentType("application/json")
            .content(convertToJson(new HashMap<String, String>() {{
                put("firstName", "Paweł");
            }}));

        mvc.perform(requestBuilder)
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType("application/json"))
            .andDo(mvcResult -> System.out.println(mvcResult.getResponse().getContentAsString()))
            // .andExpect(jsonPath("$.data.id", new IsEqual<>("e96b6f1f-30ee-4227-a090-eb2bd452f2f0")))
            .andReturn();
    }

    @Test
    void put() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/users/" + Bootstrap.USER_JOHN_ID)
            .accept("application/json")
            .contentType("application/json")
            .content(convertToJson(new HashMap<String, String>() {{
                put("firstName", "Paweł");
            }}));

        mvc.perform(requestBuilder)
            .andDo(mvcResult -> System.out.println(mvcResult.getResponse().getContentAsString()))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            // .andExpect(jsonPath("$.data.id", new IsEqual<>("e96b6f1f-30ee-4227-a090-eb2bd452f2f0")))
            .andReturn();
    }

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(usersController)
            .setControllerAdvice(new ApiControllerAdvice())
            .build();
    }
}