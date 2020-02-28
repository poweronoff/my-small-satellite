package click.poweronoff.satellite.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Properties {

    @JsonProperty
    private String id;
    @JsonProperty
    private String timestamp;
    @JsonProperty
    private String quicklook;
    @JsonProperty
    private Acquisition acquisition;
}
