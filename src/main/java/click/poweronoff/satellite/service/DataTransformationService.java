package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.repository.dto.Features;
import click.poweronoff.satellite.repository.dto.FeaturesCollection;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataTransformationService {

    public List<Feature> transformToFeatureList(FeaturesCollection[] collections) {

        List<Feature> featuresList = new ArrayList<>();

        Arrays.stream(collections).forEach(collection -> Arrays.stream(collection.getFeatures()).forEach(feature -> featuresList.add(createFeature(feature))));

        return featuresList;
    }

    private Feature createFeature(final Features features) {
        return new Feature(
                features.getProperties().getId(),
                Long.parseLong(features.getProperties().getTimestamp()),
                Long.parseLong(features.getProperties().getAcquisition().getBeginViewingDate()),
                Long.parseLong(features.getProperties().getAcquisition().getEndViewingDate()),
                features.getProperties().getAcquisition().getMissionName(),
                Base64.decodeBase64(features.getProperties().getQuicklook().getBytes())
        );
    }
}
