package com.privalia.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BugsService {
    public List<String> getBugs(){
        List<String> bugs = new ArrayList<>();
        bugs.add("Production error 1");
        bugs.add("Production error 2");
        bugs.add("Production error 3");
        bugs.add("Production error 4");
        bugs.add("Production error 5");
        bugs.add("Production error 6");
        bugs.add("Production error 7");
        return bugs;
    }

}
