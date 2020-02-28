
package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.repository.dto.Acquisition;
import click.poweronoff.satellite.repository.dto.Features;
import click.poweronoff.satellite.repository.dto.FeaturesCollection;
import click.poweronoff.satellite.repository.dto.Properties;
import org.junit.Before;
import org.junit.Test;

import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataTransformationServiceTest {

    private static final String ID = "id";
    private static final long TIMESTAMP = 271770505L;
    private static final long BEGIN_VIEWING_DATE = 271770509L;
    private static final long END_VIEWING_DATE = 271770512L;
    private static final String MISSION_NAME = "cool-mission";
    private static final String SATELLITE = "satellite";


    DataTransformationService dataTransformationService;

    @Before
    public void setup() {
        dataTransformationService = new DataTransformationService();
    }


    @Test
    public void transformToFeatureListShouldTransformToFeatureList() {
        List<Feature> objectUnderTest = dataTransformationService.transformToFeatureList(createTestFeaturesCollection());
        assertThat(objectUnderTest).isNotEmpty();
        assertThat(objectUnderTest).hasSize(1);
        assertThat(objectUnderTest).containsOnly(new Feature(ID, TIMESTAMP, BEGIN_VIEWING_DATE, END_VIEWING_DATE, MISSION_NAME, SATELLITE.getBytes()));
    }


    private FeaturesCollection[] createTestFeaturesCollection() {

        Acquisition acquisition = new Acquisition();
        acquisition.setBeginViewingDate(Long.toString(BEGIN_VIEWING_DATE));
        acquisition.setEndViewingDate(Long.toString(END_VIEWING_DATE));
        acquisition.setMissionName(MISSION_NAME);

        Properties properties = new Properties();
        properties.setId(ID);
        properties.setQuicklook(new String(Base64.getEncoder().encode("satellite".getBytes())));
        properties.setTimestamp(Long.toString(TIMESTAMP));
        properties.setAcquisition(acquisition);

        Features features = new Features();
        features.setProperties(properties);

        FeaturesCollection featuresCollection = new FeaturesCollection();
        featuresCollection.setFeatures(new Features[]{features});

        return new FeaturesCollection[]{featuresCollection};
    }
}
