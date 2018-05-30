package com.example.sarah.passwordval;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ValidateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);

        Button validateButton = findViewById(R.id.button);
        validateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView isValidated = findViewById(R.id.textView);
                EditText password = findViewById(R.id.editText);
                String passwordMessage;
                if (Validator.validate(password.getText().toString()) < 5) {
                    passwordMessage = "This password is too weak";
                } else {
                    passwordMessage = "This password is sufficiently strong";
                }

                isValidated.setText(passwordMessage);
            }
        });


    }
}