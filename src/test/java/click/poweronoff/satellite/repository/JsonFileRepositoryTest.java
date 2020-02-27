package click.poweronoff.satellite.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonFileRepositoryTest {

    @Autowired
    private JsonFileRepository repository;

    @Test
    public void readAllFeaturesShouldReturnAllFeatures() throws IOException {
        assertThat(repository.readAllFeatures()).isNotEmpty();
        assertThat(repository.readAllFeatures()).hasSize(14);
    }

}