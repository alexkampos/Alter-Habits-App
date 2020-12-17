/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

 

/**
 *
 * @author vaggelis
 */
public class DeserializeActivityDto {
    
    
    private String label;
    private String value;

    public DeserializeActivityDto(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public DeserializeActivityDto() {
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(String value) {
        this.value = value;
    }
 
    
    
    
}
