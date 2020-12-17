/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.groupproject.pojo.Activity;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.utils.QuizFilters;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexk
 */
@RestController
public class HomeController {

    @Autowired
    MyUserServiceInterface myUserServiceInterface;
    
    @GetMapping("/quiz/answers")
    public String showQuizAnswers(
            @RequestParam String answer1,
            @RequestParam String answer2,
            @RequestParam String answer3,
            @RequestParam String answer4
    ) throws MalformedURLException, IOException {
        ObjectMapper om = new ObjectMapper();
        List<Activity> activities = om.readValue(new File("src/main/resources/activities.json"), new TypeReference<List<Activity>>() {
        });
        List<Activity> filteredActivities = QuizFilters.filterActivitiesBasedOnAnswers(answer1, answer2, answer3, answer4, activities);
        if (filteredActivities.isEmpty()) {
            return null;
        } else {
            return om.writeValueAsString(filteredActivities);
        }

    }
}
