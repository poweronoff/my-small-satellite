package click.poweronoff.satellite.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Acquisition {

    private String beginViewingDate;

    private String endViewingDate;

    private String missionName;
}
