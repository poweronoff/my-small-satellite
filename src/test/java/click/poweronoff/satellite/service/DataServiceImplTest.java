package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.repository.JsonFileRepository;
import click.poweronoff.satellite.repository.dto.FeaturesCollection;
import click.poweronoff.satellite.testutil.FeaturesCollectionCreator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataServiceImplTest {

    @Mock
    JsonFileRepository jsonFileRepository;

    DataServiceImpl dataService;

    DataTransformationService dataTransformationService;

    @Before
    public void setup() {
        dataTransformationService = new DataTransformationService();
        dataService = new DataServiceImpl(jsonFileRepository, dataTransformationService);
    }

    @Test
    public void getAllFeaturesReturnsEmpty() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(new FeaturesCollection[]{});
        assertThat(dataService.getAllFeatures()).isEmpty();
    }

    @Test
    public void getAllFeaturesReturnsAListOfFeatures() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(FeaturesCollectionCreator.createTestFeaturesCollection());
        assertThat(dataService.getAllFeatures()).isNotEmpty();
        assertThat(dataService.getAllFeatures().get()).hasSize(1);
    }

    @Test
    public void getFeatureReturnsEmpty() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(new FeaturesCollection[]{});
        assertThat(dataService.getFeature(FeaturesCollectionCreator.ID)).isEmpty();
    }

    @Test
    public void getFeatureWithNonexistentIdReturnsEmpty() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(FeaturesCollectionCreator.createTestFeaturesCollection());
        assertThat(dataService.getFeature("non-existing-feature")).isEmpty();
    }

    @Test
    public void getFeatureReturnFeature() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(FeaturesCollectionCreator.createTestFeaturesCollection());
        assertThat(dataService.getFeature(FeaturesCollectionCreator.ID)).isNotEmpty();
        assertThat(dataService.getFeature(FeaturesCollectionCreator.ID)).isPresent().hasValue(new Feature(
                FeaturesCollectionCreator.ID,
                FeaturesCollectionCreator.TIMESTAMP,
                FeaturesCollectionCreator.BEGIN_VIEWING_DATE,
                FeaturesCollectionCreator.END_VIEWING_DATE,
                FeaturesCollectionCreator.MISSION_NAME,
                FeaturesCollectionCreator.SATELLITE.getBytes()));
    }

    @Test
    public void getPictureReturnsEmpty() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(new FeaturesCollection[]{});
        assertThat(dataService.getPicture(FeaturesCollectionCreator.ID)).isEmpty();
    }

    @Test
    public void getPictureWithNonexistentIdReturnsEmpty() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(FeaturesCollectionCreator.createTestFeaturesCollection());
        assertThat(dataService.getPicture("non-existing-feature")).isEmpty();
    }

    @Test
    public void getPictureReturnsPicture() throws IOException {
        when(jsonFileRepository.readAllFeatures()).thenReturn(FeaturesCollectionCreator.createTestFeaturesCollection());
        assertThat(dataService.getPicture(FeaturesCollectionCreator.ID)).isPresent().hasValue(FeaturesCollectionCreator.SATELLITE.getBytes());
    }


}