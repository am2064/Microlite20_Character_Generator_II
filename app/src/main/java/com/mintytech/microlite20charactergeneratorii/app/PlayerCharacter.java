package com.mintytech.microlite20charactergeneratorii.app;

import android.content.res.Resources;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minty on 5/8/14.
 */

@Table(name = "Characters")
public class PlayerCharacter extends Model {

    private enum Jobs{
        FIGHTER,
        ROGUE,
        MAGE,
        CLERIC
    }

    private enum Races{
        HUMAN,
        DWARF,
        ELF,
        HALFLING
    }

    public static final int STR = 0;
    public static final int DEX = 1;
    public static final int MND = 2;

    @Column(name = "Name")
    public String name;

    @Column(name = "Race")
    public String race;

    @Column(name = "Job")
    public String job;

    @Column(name = "Level")
    public int level;

    @Column(name = "Stats")
    public int[] stats=new int[3];

    @Column(name ="Money")
    public double money;

    public List<Weapon> weapons(){
        return getMany(Weapon.class, "Owner");
    }

    public List<Armor> armors(){
        return getMany(Armor.class, "Owner");
    }

    public List<Spell> spells(){
        return getMany(Spell.class, "Owner");
    }

    public List<Item> items(){
        return getMany(Item.class, "Owner");
    }

    public String toString()
    {
        return name+", Level "+level+" "+race+" "+job;
    }

    public PlayerCharacter(){}

    public PlayerCharacter(String name, int[] stats, String race, String job){
        this.name = name;
        this.level = 1;
        this.stats = stats;
        this.race = race;
        this.job = job;

        switch(Jobs.valueOf(job.toUpperCase())){
            case FIGHTER:
                this.money = 150;
                break;
            case ROGUE:
                this.money = 125;
                break;
            case MAGE:
                this.money = 75;
                break;
            case CLERIC:
                this.money = 100;
                break;
            default:
                this.money = 150;
                break;
        }
        this.save();
    }


}
