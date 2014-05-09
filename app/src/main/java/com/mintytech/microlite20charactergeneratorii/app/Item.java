package com.mintytech.microlite20charactergeneratorii.app;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by minty on 5/8/14.
 */

@Table(name = "Items")
public class Item extends Model {
    
    @Column(name = "Owner")
    private PlayerCharacter character;

    @Column(name = "Cost")
    private double cost;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "Description")
    public String description;

    @Column(name = "Notes")
    public String notes;

}
