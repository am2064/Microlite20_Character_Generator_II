package com.mintytech.microlite20charactergeneratorii.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.mintytech.microlite20charactergeneratorii.app.dummy.DummyContent;


public class RollActivity extends ActionBarActivity {

    private int[] stats;
    private int characterClass, characterRace;
    private Spinner classes, races;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);

        //getActionBar().setTitle("Create your Character");

        classes = (Spinner) findViewById(R.id.spinner1);
        races = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> class_adapter = ArrayAdapter
                .createFromResource(this, R.array.Classes,
                        android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> race_adapter = ArrayAdapter
                .createFromResource(this, R.array.Races,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        class_adapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        race_adapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        classes.setAdapter(class_adapter);
        races.setAdapter(race_adapter);


        classes.setOnItemSelectedListener(this.new ClassSelection());
        races.setOnItemSelectedListener(this.new RaceSelection());
        Bundle bundle = getIntent().getExtras();

        stats = bundle.getIntArray("stats");
        EditText stat = (EditText) findViewById(R.id.editStrength);
        stat.setText("" + stats[PlayerCharacter.STR]);
        stat = (EditText) findViewById(R.id.editDexterity);
        stat.setText("" + stats[PlayerCharacter.DEX]);
        stat = (EditText) findViewById(R.id.editMind);
        stat.setText("" + stats[PlayerCharacter.MND]);

    }

    public void createCharacter(View v){
        EditText stat = (EditText) findViewById(R.id.editStrength);
        stats[PlayerCharacter.STR] = Integer.parseInt(stat.getText().toString());
        stat = (EditText) findViewById(R.id.editDexterity);
        stats[PlayerCharacter.DEX] = Integer.parseInt(stat.getText().toString());
        stat = (EditText) findViewById(R.id.editMind);
        stats[PlayerCharacter.MND] = Integer.parseInt(stat.getText().toString());
        stat = (EditText) findViewById(R.id.editName);
        characterClass = classes.getSelectedItemPosition();
        characterRace = races.getSelectedItemPosition();

        String[] races = getResources().getStringArray(R.array.Races);
        String[] classes = getResources().getStringArray(R.array.Classes);

        PlayerCharacter ch = new PlayerCharacter(stat.getText().toString(), stats, races[characterRace], classes[characterClass]);
        DummyContent.addItem(ch);

        startActivity(new Intent(getBaseContext(), SheetListActivity.class));
    }

    private class ClassSelection implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            String[] descriptions = {
                    "Fighters wear any kind of armour and use shields. They have a +3 bonus to Physical and add +1 to all attack and damage rolls. This increases by +1 at 5th level and every five levels on.",
                    "Rogues can use light armour. They have a +3 bonus to Subterfuge. If they successfully Sneak (usually sub+DEX, but depends on situation) against a foe they can add their Subterfuge skill rank to the damage of their first attack that round",
                    "Magi wear no armour. They can cast arcane spells, and gain a +3 bonus to Knowledge",
                    "Clerics can wear light or medium armour and use shields. They cast divine spells and gain +3 bonus to Communication. A Cleric can Turn Undead with a successful Magic Attack. DC is the current Hit Points of the Undead. If the DC is exceeded by 10 it is destroyed. This can be used (2 + Level + MIND Bonus) times per day." };
            TextView description = (TextView) findViewById(R.id.classText);
            description.setText(descriptions[arg2]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }

    }

    private class RaceSelection implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            String[] descriptions = {
                    "Humans get +1 to all skill rolls",
                    "Elves get +2 MIND",
                    "Dwarves get +2 STR",
                    "Halflings get +2 DEX"
            };
            TextView description = (TextView) findViewById(R.id.raceText);
            description.setText(descriptions[arg2]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }

    }

}
