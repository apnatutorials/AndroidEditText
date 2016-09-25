package com.apnatutorials.androidedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etImeOptiondemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etImeOptiondemo = (EditText) findViewById(R.id.etImeOptiondemo);
        demonstrateTextChangeListener();
        demonstrateOnEditorActionListener();

    }

    /**
     * Method used to demonstrate addTextChangedListener
     */
    private void demonstrateTextChangeListener() {
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // fires just before text changes
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                // fires as text changes
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Fires just after text changes
                Toast.makeText(MainActivity.this, "Text value : " + editable.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Method demonstrate OnEditorActionListener
     */
    private void demonstrateOnEditorActionListener() {
        etImeOptiondemo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String text = textView.getText().toString();
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
