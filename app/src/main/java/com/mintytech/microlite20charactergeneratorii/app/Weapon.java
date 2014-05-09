package com.mintytech.microlite20charactergeneratorii.app;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by minty on 5/8/14.
 */

@Table(name = "Weapons")
public class Weapon extends Model {
    @Column(name = "Owner")
    private PlayerCharacter character;

    @Column(name = "Name")
    public String name;

    @Column(name = "Dice")
    public int dice;

    @Column(name = "Step")
    public int step;

    @Column(name = "Bonus")
    public int bonus;

    @Column(name = "Cost")
    public double cost;

    @Column(name = "Description")
    public String description;

    @Column(name = "Notes")
    public String notes;
}
