
package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.testutil.FeaturesCollectionCreator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataTransformationServiceTest {


    DataTransformationService dataTransformationService;

    @Before
    public void setup() {
        dataTransformationService = new DataTransformationService();
    }


    @Test
    public void transformToFeatureListShouldTransformToFeatureList() {
        List<Feature> objectUnderTest = dataTransformationService.transformToFeatureList(FeaturesCollectionCreator.createTestFeaturesCollection());
        assertThat(objectUnderTest).isNotEmpty();
        assertThat(objectUnderTest).hasSize(1);
        assertThat(objectUnderTest).containsOnly(new Feature(FeaturesCollectionCreator.ID,
                FeaturesCollectionCreator.TIMESTAMP,
                FeaturesCollectionCreator.BEGIN_VIEWING_DATE,
                FeaturesCollectionCreator.END_VIEWING_DATE,
                FeaturesCollectionCreator.MISSION_NAME,
                FeaturesCollectionCreator.SATELLITE.getBytes()));
    }
}
