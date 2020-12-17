/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.utils;

import com.webapp.groupproject.pojo.Activity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author alexk
 */
public class QuizFilters {

    public static List<Activity> filterActivitiesBasedOnAnswers(String answer1,
            String answer2, String answer3, String answer4, List<Activity> activities) {

        List<Activity> activitiesSortedByAnswer1 = filterActivitiesBasedOnAnswer1(answer1, activities);
        List<Activity> activitiesSortedByAnswer2 = filterActivitiesBasedOnAnswer2(answer2, activitiesSortedByAnswer1);
        List<Activity> activitiesSortedByAnswer3 = filterActivitiesBasedOnAnswer3(answer3, activitiesSortedByAnswer2);
        List<Activity> activitiesSortedByAnswer4 = filterActivitiesBasedOnAnswer4(answer4, activitiesSortedByAnswer3);
        List<Activity> activitiesSuggestedMaximum3 = keepThreeListItemsToShow(activitiesSortedByAnswer4);
        return activitiesSuggestedMaximum3;
    }

    private static List<Activity> filterActivitiesBasedOnAnswer1(String answer1, List<Activity> activities) {

        List<Activity> activitiesFilteredByAnswer1;
        switch (answer1) {
            case "yes":
                activitiesFilteredByAnswer1 = activities.stream()
                        .filter(activity -> activity.group.equals(answer1)
                        || activity.group.equals("both"))
                        .collect(Collectors.toList());
                break;
            case "no":
                activitiesFilteredByAnswer1 = activities.stream()
                        .filter(activity -> activity.group.equals(answer1)
                        || activity.group.equals("both"))
                        .collect(Collectors.toList());
                break;
            default:
                activitiesFilteredByAnswer1 = new ArrayList(activities);
                Collections.copy(activitiesFilteredByAnswer1, activities);
                break;
        }
        return activitiesFilteredByAnswer1;

    }

    private static List<Activity> filterActivitiesBasedOnAnswer2(String answer2, List<Activity> activitiesFilteredByAnswer1) {

        List<Activity> activitiesFilteredByAnswer2;
        switch (Integer.parseInt(answer2)) {
            case 2:
                activitiesFilteredByAnswer2 = new ArrayList(activitiesFilteredByAnswer1);
                Collections.copy(activitiesFilteredByAnswer2, activitiesFilteredByAnswer1);
                break;
            case 1:
                activitiesFilteredByAnswer2 = activitiesFilteredByAnswer1.stream()
                        .filter(activity -> activity.level == 1
                        || activity.level == 0)
                        .collect(Collectors.toList());
                break;
            default:
                activitiesFilteredByAnswer2 = activitiesFilteredByAnswer1.stream()
                        .filter(activity -> activity.level == 0)
                        .collect(Collectors.toList());
                break;
        }
        return activitiesFilteredByAnswer2;

    }

    private static List<Activity> filterActivitiesBasedOnAnswer3(String answer3, List<Activity> activitiesFilteredByAnswer2) {

        List<Activity> activitiesFilteredByAnswer3;
        switch (answer3) {
            case "strength":
                activitiesFilteredByAnswer3 = activitiesFilteredByAnswer2.stream()
                        .filter(activity -> activity.properties.contains(answer3))
                        .collect(Collectors.toList());
                break;
            case "endurance":
                activitiesFilteredByAnswer3 = activitiesFilteredByAnswer2.stream()
                        .filter(activity -> activity.properties.contains(answer3))
                        .collect(Collectors.toList());
                break;
            default:
                activitiesFilteredByAnswer3 = activitiesFilteredByAnswer2.stream()
                        .filter(activity -> activity.properties.contains(answer3))
                        .collect(Collectors.toList());
                break;
        }
        return activitiesFilteredByAnswer3;

    }

    private static List<Activity> filterActivitiesBasedOnAnswer4(String answer4, List<Activity> activitiesFilteredByAnswer3) {

        List<Activity> activitiesFilteredByAnswer4;
        switch (answer4) {
            case "indoor":
                activitiesFilteredByAnswer4 = activitiesFilteredByAnswer3.stream()
                        .filter(activity -> activity.environment.equals("indoor")
                        || activity.environment.equals("both"))
                        .collect(Collectors.toList());
                break;
            case "outdoor":
                activitiesFilteredByAnswer4 = activitiesFilteredByAnswer3.stream()
                        .filter(activity -> activity.environment.equals("outdoor")
                        || activity.environment.equals("both"))
                        .collect(Collectors.toList());
                break;
            default:
                activitiesFilteredByAnswer4 = new ArrayList(activitiesFilteredByAnswer3);
                Collections.copy(activitiesFilteredByAnswer4, activitiesFilteredByAnswer3);
                break;
        }
        return activitiesFilteredByAnswer4;

    }
    
    private static List<Activity> keepThreeListItemsToShow(List<Activity> activitiesSuggested) {
        
        Random random = new Random();
        List<Activity> activitiesSuggestedMaximum3 = new ArrayList();
        int numberOfActivitiesToKeep = 3;
        for(int i = 0; i < numberOfActivitiesToKeep; i++) {
            int randomIndex = random.nextInt(activitiesSuggested.size());
            Activity activityRandomlyChosen = activitiesSuggested.get(randomIndex);
            activitiesSuggestedMaximum3.add(activityRandomlyChosen);
            activitiesSuggested.remove(randomIndex);
            if(activitiesSuggested.size() < 1) {
                break;
            }
        }
        return activitiesSuggestedMaximum3;
    }

}
