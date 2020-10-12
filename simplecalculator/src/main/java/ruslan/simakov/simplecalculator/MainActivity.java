package ruslan.simakov.simplecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ZZZ";
    final int MENU_ALFA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANCE_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

    EditText etNum1;
    EditText etNum2;
    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnSecondActivity;
    TextView tvResult;
    Button btnTime;
    Button btnDate;

    EditText etFname;
    EditText etLname;
    Button btnSubmit;

    TextView tvText;
    Button btnColor;
    Button btnAlign;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "MainActivity: onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** находим элементы */
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);
        btnSecondActivity =findViewById(R.id.btnSecondActivity);
        tvResult = findViewById(R.id.tvResult);

        etFname = findViewById(R.id.etFName);
        etLname = findViewById(R.id.etLName);
        btnSubmit = findViewById(R.id.btnSubmit);

        /** прописываем обработчик */
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
        btnSecondActivity.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        float num1 = 0;
        float num2 = 0;
        float result = 0;

        String oper = null;

        /** читаем EditText и заполняем переменные числами */
        if(!etNum1.getText().toString().isEmpty() && !etNum2.getText().toString().isEmpty()) {
            num1 = Float.parseFloat(etNum1.getText().toString());
            num2 = Float.parseFloat(etNum2.getText().toString());
        }

        /** определяем нажатую кнопку и выполняем соответствующую операцию
         в oper пишем операцию, потом будем использовать в выводе */
        switch (view.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnSecondActivity:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.btnTime:
                intent = new Intent("ruslan.simakov.intent.action.showtime");
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("ruslan.simakov.intent.action.showdate");
                startActivity(intent);
                break;
            case R.id.btnSubmit:
                Intent intentName = new Intent(this, NameActivity.class);
                intentName.putExtra("fname", etFname.getText().toString());
                intentName.putExtra("lname", etLname.getText().toString());
                startActivity(intentName);
                break;
            default:
                break;
        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " " + " = " + result);
    }

    /**
     * создание меню
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, MENU_ALFA_ID, 0, "ALFA");
        menu.add(0, MENU_SCALE_ID, 0, "SCALE");
        menu.add(0, MENU_TRANCE_ID, 0, "TRANCE");
        menu.add(0, MENU_ROTATE_ID, 0, "ROTATE");
        menu.add(0, MENU_COMBO_ID, 0, "COMBO");

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * обработка нажатий на пункты меню
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Animation anim = null;

        switch (item.getItemId()) {
            case MENU_ALFA_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myalfa);
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_TRANCE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrance);
                break;
            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case MENU_COMBO_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }
        tvResult.startAnimation(anim);
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }
}
