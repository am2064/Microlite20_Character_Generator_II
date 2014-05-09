package com.mintytech.microlite20charactergeneratorii.app;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by minty on 5/8/14.
 */

@Table(name = "Spells")
public class Spell extends Model {
    @Column(name = "Owner")
    private PlayerCharacter character;

    @Column(name = "Name")
    private String name;

    @Column(name="Level")
    private int level;

    @Column(name="Effect")
    private String effect;

    @Column(name = "Description")
    public String description;

    @Column(name = "Notes")
    public String notes;
}
