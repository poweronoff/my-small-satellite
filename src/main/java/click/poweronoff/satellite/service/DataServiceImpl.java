package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataServiceImpl implements DataService {

    public Optional<List<Feature>> getAllFeatures() {
        return Optional.empty();
    }

    @Override
    public Optional<Feature> getFeature(String featureId) {
        return Optional.empty();
    }

    @Override
    public Optional<byte[]> getPicture(String featureId) {
        return Optional.empty();
    }
}
