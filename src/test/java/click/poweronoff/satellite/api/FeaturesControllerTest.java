package click.poweronoff.satellite.api;

import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FeaturesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DataService dataService;

    @Test
    public void getFeaturesShouldReturnDefaultMessage() throws Exception {
        when(dataService.getAllFeatures()).thenReturn(List.of(new Feature("feature-id", 123L, 234L, 345L, "mission")));
        this.mockMvc.perform(get("/features")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].id", is("feature-id")))
                .andExpect(jsonPath("$[0].timestamp", is(123)))
                .andExpect(jsonPath("$[0].beginViewingDate", is(234)))
                .andExpect(jsonPath("$[0].endViewingDate", is(345)))
                .andExpect(jsonPath("$[0].missionName", is("mission"))
                );
    }

}