package com.mischiefbox.android.puppy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Main extends Activity {
    public final static String STATE_CHECKBOXES = "checkboxState";
    private boolean [] checkboxState = new boolean[5];

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final CheckBox [] checkbox = {
                (CheckBox) findViewById(R.id.checkbox0),
                (CheckBox) findViewById(R.id.checkbox1),
                (CheckBox) findViewById(R.id.checkbox2),
                (CheckBox) findViewById(R.id.checkbox3),
                (CheckBox) findViewById(R.id.checkbox4),
        };

        for (int i = 0; i < checkboxState.length; i++) {
            final int j = i;
            checkbox[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkboxState[j] = ((CheckBox)view).isChecked();
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the checkbox state
        outState.putBooleanArray(STATE_CHECKBOXES, checkboxState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // load the checkbox state
        checkboxState = savedInstanceState.getBooleanArray(STATE_CHECKBOXES);
    }


}
