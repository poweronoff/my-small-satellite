package click.poweronoff.satellite.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Feature {

    private String id;

    private long timestamp;

    private long beginViewingDate;

    private long endViewingDate;

    private String missionName;

    @JsonIgnore
    private byte[] picture;
}
