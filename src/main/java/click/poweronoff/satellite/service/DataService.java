package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;

import java.util.List;
import java.util.Optional;

public interface DataService {

    /**
     * returned all possible Features as a list
     *
     * @return list of Features
     */
    List<Feature> getAllFeatures();

    /**
     * returned specific Feature by given id
     *
     * @param featureId feature id
     * @return Optional of Feature in case of the feature can be
     * found
     * or an empty Optional
     */
    Optional<Feature> getFeature(final String featureId);


    /**
     * returned a picture as a byte[] representation for given feature id
     *
     * @param featureId feature id
     * @return a picture as a byte[]
     */
    Optional<byte[]> getPicture(final String featureId);
}
