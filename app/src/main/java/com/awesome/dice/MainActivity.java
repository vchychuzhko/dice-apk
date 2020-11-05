package com.awesome.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     *
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dice");
        initViews();
    }

    private void initViews() {
        Button button = (Button) findViewById(R.id.button);
        Button decButton = (Button) findViewById(R.id.dec_button);
        RadioButton rb1 = (RadioButton) findViewById(R.id.flag1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.flag2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.flag3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.flag4);
        TextView tw = (TextView) findViewById(R.id.main);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        tw.setOnClickListener(this);
        button.setOnClickListener(this);
        decButton.setOnClickListener(this);
    }

    /**
     *
     * @param v View
     */
    @Override
    public void onClick(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        int id = v.getId();
        switch (id) {
            case R.id.button:
                dice(Integer.parseInt(editText.getText().toString()));
                break;
            case R.id.main:
                clear();
                break;
            case R.id.dec_button:
                decide();
                break;
            case R.id.flag1:
                editText.setText("10");
                break;
            case R.id.flag2:
                editText.setText("20");
                break;
            case R.id.flag3:
                editText.setText("50");
                break;
            case R.id.flag4:
                editText.setText("100");
                break;
        }
    }

    /**
     *
     * @param n int
     */
    public void dice(int n) {
        Random random = new Random(System.currentTimeMillis());
        int r = random.nextInt(n) + 1;

        TextView textView = (TextView) findViewById(R.id.main);
        textView.setTextSize(200);

        if (r >= 100) {
            textView.setTextSize(150);
        }
        textView.setText("" + r);
    }

    public void clear() {
        TextView textView = (TextView) findViewById(R.id.main);
        textView.setText("");
    }

    public void decide() {
        Random random = new Random(System.currentTimeMillis());
        int r = (int) (random.nextDouble() * 1000);

        TextView textView = (TextView) findViewById(R.id.main);
        textView.setTextSize(150);

        if (r % 2 == 0) {
            textView.setText("YES");
        } else {
            textView.setText("NO");
        }
    }
}
