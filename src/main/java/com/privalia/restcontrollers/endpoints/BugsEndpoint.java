package com.privalia.restcontrollers.endpoints;

import com.privalia.services.BugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BugsEndpoint extends AbstractEndpoint<List<String>> {

    @Autowired
    private BugsService bugsService;

    public BugsEndpoint() {
        super("bugs");
    }

    @Override
    public List<String> invoke() {
        return bugsService.getBugs();
    }
}
