package com.pcsalt.example.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textViewSelected;

    RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            textViewSelected.setText("selected button: " + checkedId);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        addRadioButtons();
    }

    private void initViews() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        textViewSelected = (TextView) findViewById(R.id.textViewSelected);
        radioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private void addRadioButtons() {
        for (int i = 0; i < 4; i++) {
            addRadioButton(i);
        }
    }

    private void addRadioButton(int position) {
        RadioButton radioButton = new RadioButton(this);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.MATCH_PARENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
        );
        radioButton.setLayoutParams(layoutParams);
        radioButton.setText("Button #" + position);
        radioButton.setId(position);
        radioGroup.addView(radioButton);
    }
}
