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

        Features[] features = new Features[]{Features.builder().properties(Properties.builder()
                .id(ID)
                .timestamp(Long.toString(TIMESTAMP))
                .quicklook(new String(Base64.getEncoder().encode("satellite".getBytes())))
                .acquisition(Acquisition.builder()
                        .beginViewingDate(Long.toString(BEGIN_VIEWING_DATE))
                        .endViewingDate(Long.toString(END_VIEWING_DATE))
                        .missionName(MISSION_NAME)
                        .build())
                .build())
                .build()};

        return new FeaturesCollection[]{FeaturesCollection.builder().features(features).build()};
    }
}