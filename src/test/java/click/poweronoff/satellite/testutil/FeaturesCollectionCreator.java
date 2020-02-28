package click.poweronoff.satellite.testutil;

import click.poweronoff.satellite.repository.dto.Acquisition;
import click.poweronoff.satellite.repository.dto.Features;
import click.poweronoff.satellite.repository.dto.FeaturesCollection;
import click.poweronoff.satellite.repository.dto.Properties;

import java.util.Base64;

public class FeaturesCollectionCreator {


    public static final String ID = "id";
    public static final long TIMESTAMP = 271770505L;
    public static final long BEGIN_VIEWING_DATE = 271770509L;
    public static final long END_VIEWING_DATE = 271770512L;
    public static final String MISSION_NAME = "cool-mission";
    public static final String SATELLITE = "satellite";


    public static FeaturesCollection[] createTestFeaturesCollection() {

        Acquisition acquisition = new Acquisition();
        acquisition.setBeginViewingDate(Long.toString(BEGIN_VIEWING_DATE));
        acquisition.setEndViewingDate(Long.toString(END_VIEWING_DATE));
        acquisition.setMissionName(MISSION_NAME);

        Properties properties = new Properties();
        properties.setId(ID);
        properties.setQuicklook(new String(Base64.getEncoder().encode(SATELLITE.getBytes())));
        properties.setTimestamp(Long.toString(TIMESTAMP));
        properties.setAcquisition(acquisition);

        Features features = new Features();
        features.setProperties(properties);

        FeaturesCollection featuresCollection = new FeaturesCollection();
        featuresCollection.setFeatures(new Features[]{features});

        return new FeaturesCollection[]{featuresCollection};
    }

}
