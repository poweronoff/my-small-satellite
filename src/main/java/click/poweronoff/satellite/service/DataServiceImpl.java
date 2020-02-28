package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.repository.JsonFileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class DataServiceImpl implements DataService {

    @Autowired
    JsonFileRepository jsonFileRepository;

    @Autowired
    DataTransformationService dataTransformationService;

    public Optional<List<Feature>> getAllFeatures() {
        try {
            List<Feature> features = dataTransformationService.transformToFeatureList(jsonFileRepository.readAllFeatures());
            if (!features.isEmpty()) {
                return Optional.of(features);
            }
            return Optional.empty();
        } catch (IOException e) {
            log.error("exception on getAllFeatures() occurred, please check your app configuration");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Feature> getFeature(String featureId) {
        try {
            List<Feature> features = dataTransformationService.transformToFeatureList(jsonFileRepository.readAllFeatures());
            if (!features.isEmpty()) {
                return features.stream().filter(feature -> feature.getId().equals(featureId)).findFirst();
            }
            return Optional.empty();
        } catch (IOException e) {
            log.error("exception on getFeature() and featureIo {} occurred, please check your app configuration", featureId);
            return Optional.empty();
        }
    }

    @Override
    public Optional<byte[]> getPicture(String featureId) {
        try {
            List<Feature> features = dataTransformationService.transformToFeatureList(jsonFileRepository.readAllFeatures());
            if (!features.isEmpty()) {
                return features.stream().filter(feature -> feature.getId().equals(featureId)).findFirst().filter(feature -> feature.getPicture() != null).map(Feature::getPicture);
            }
            return Optional.empty();
        } catch (IOException e) {
            log.error("exception on getPicture() and featureIo {} occurred, please check your app configuration", featureId);
            return Optional.empty();
        }
    }
}
