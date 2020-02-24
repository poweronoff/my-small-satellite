package click.poweronoff.satellite.service;

import click.poweronoff.satellite.domain.Feature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataServiceImpl implements DataService {

    public List<Feature> getAllFeatures() {
        return null;
    }

    @Override
    public Feature getFeature(String featureId) {
        return null;
    }

    @Override
    public String getPictureAsB64(String featureId) {
        return null;
    }
}
