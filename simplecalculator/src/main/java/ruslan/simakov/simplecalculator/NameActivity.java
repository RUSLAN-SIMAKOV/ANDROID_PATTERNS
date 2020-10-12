package ruslan.simakov.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    TextView tvName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");

        tvName = findViewById(R.id.tvName);
        tvName.setText("Your name is: " + fname + " " + lname);
    }
}