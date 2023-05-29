package com.travel.travelapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private String id;
    private String name;
    private String email;
    private String country;
    private int travellerCount;
    private int totalBudget;

}
