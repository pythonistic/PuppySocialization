package com.mischiefbox.android.puppy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chris
 * Date: 8/19/12
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Goals extends Activity {
    private TextView textTitle;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals);

        textTitle = (TextView)findViewById(R.id.goalText);

        Bundle b = getIntent().getExtras();
        loadLayout(b.getInt("id"), b.getString("name"), b.getStringArray("goalNames"),
                new boolean[b.getStringArray("goalNames").length]);

        // refresh?
        setContentView(R.layout.goals);
    }

    public void loadLayout(int layoutId, String name, String [] goalNames, boolean [] goalStatus) {
        textTitle.setText(name);
        TableLayout tl = (TableLayout)findViewById(R.id.goalTable);

        for (int i = 0; i < goalNames.length; i++) {
            Log.i(getClass().getName(), "Creating checkbox " + goalNames[i]);
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            CheckBox checkBox = new CheckBox( this );
            checkBox.setText(goalNames[i]);
            checkBox.setChecked(goalStatus[i]);
            checkBox.setTag(layoutId + i);
            Log.i(getClass().getName(), "Created checkbox " + checkBox);

//            LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams( LayoutParams.WRAP_CONTENT,
//                                                                                  LayoutParams.WRAP_CONTENT );
//            Log.i(getClass().getName(), "Adding checkbox to without layout " + layout);
//            ((LinearLayout)findViewById(R.id.goalLayout)).addView(checkBox, layout);
//            ((LinearLayout)findViewById(R.id.goalLayout)).addView(checkBox);

            tr.addView(checkBox);
            tl.addView(tr);
            Log.i(getClass().getName(), "Added checkbox");
        }

        // trying to get these rows to appear to verify I'm doing this right
        CheckBox cb = new CheckBox(this);
        cb.setText("Hello there");
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        tr.addView(cb);
        tl.addView(tr);

        TextView tv = new TextView(this);
        tv.setText("Argh");
        tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        tr.addView(tv);
        tl.addView(tr);

//        Log.i(getClass().getName(), tl.getParent().toString());
//        Log.i(getClass().getName(), findViewById(R.id.goalLayout).toString());
//        ((LinearLayout)findViewById(R.id.goalLayout)).addView(tl);
//        setContentView(tl);
    }
}