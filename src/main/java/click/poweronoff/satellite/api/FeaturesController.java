package click.poweronoff.satellite.api;


import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class FeaturesController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "/features", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Feature> features() {
        return dataService.getAllFeatures();
    }

    @RequestMapping(value = "/features/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Feature featureById(@PathVariable String id) {
        return dataService.getFeature(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find feature"));
    }

    @RequestMapping(value = "/features/{id}/quicklook", method = RequestMethod.GET, produces = "image/png")
    @ResponseBody
    public byte[] quicklookByFeatureId(@PathVariable String id) {
        return dataService.getPicture(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find feature"));
    }

}
