package ruslan.simakov.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityDate extends AppCompatActivity {

    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String time = sdf.format(new Date(System.currentTimeMillis()));

        tvDate = findViewById(R.id.tvDate);
        tvDate.setText(time);
    }
}