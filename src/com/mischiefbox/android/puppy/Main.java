package com.mischiefbox.android.puppy;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main extends ListActivity {
//    public final static String STATE_CHECKBOXES = "checkboxState";
//    private boolean [] checkboxState = new boolean[5];
    private final static String [] GOAL_CHOICES = new String[] {
        "Locations"
    };

    private final static String [][] GOAL_NAMES = new String[][] {
        {"Staircases", "Another Home", "Lake/Pond", "Boat", "Crate", "Tethered to Couch", "Stationary Car"}
    };

    private final static int [] GOAL_IDS = new int[] {
        200000
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, GOAL_CHOICES));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setTextFilterEnabled(true);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                loadGoal(i);
            }
        });

//        final CheckBox [] checkbox = {
//                (CheckBox) findViewById(R.id.checkbox0),
//                (CheckBox) findViewById(R.id.checkbox1),
//                (CheckBox) findViewById(R.id.checkbox2),
//                (CheckBox) findViewById(R.id.checkbox3),
//                (CheckBox) findViewById(R.id.checkbox4),
//        };
//
//        for (int i = 0; i < checkboxState.length; i++) {
//            final int j = i;
//            checkbox[i].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    checkboxState[j] = ((CheckBox)view).isChecked();
//                }
//            });
//        }
    }

    private void loadGoal(int goalId) {
        Intent showGoal = new Intent(this, Goals.class);
        Bundle b = new Bundle();
        b.putString("name", GOAL_CHOICES[goalId]);
        b.putStringArray("goalNames", GOAL_NAMES[goalId]);
        b.putInt("id", GOAL_IDS[goalId]);
        showGoal.putExtras(b);
        startActivity(showGoal);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the checkbox state
//        outState.putBooleanArray(STATE_CHECKBOXES, checkboxState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // load the checkbox state
//        checkboxState = savedInstanceState.getBooleanArray(STATE_CHECKBOXES);
    }


}
