/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.pojo;

import java.util.List;

/**
 *
 * @author alexk
 */
public class Activity {
    
    public int id;
    public String name;
    public String environment;
    public String group;
    public int level;
    public List<String> properties;

    @Override
    public String toString() {
        return "Activity{" + "name=" + name + ", environment=" + environment + ", group=" + group + ", level=" + level + ", properties=" + properties + '}';
    }
    
    
}
