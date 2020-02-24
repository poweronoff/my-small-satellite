package click.poweronoff.satellite.api;


import click.poweronoff.satellite.domain.Feature;
import click.poweronoff.satellite.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FeaturesController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "/features", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Feature> features() {
        return dataService.getAllFeatures();
    }

}
