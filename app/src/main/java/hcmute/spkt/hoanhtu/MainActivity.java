package hcmute.spkt.hoanhtu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edScreen;
    public Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    public Button dot, plus, minus, multiply, division, equal, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        setNumericOnClickListener();
        setOperationOnClickListener();
    }

    private void findID() {
        edScreen = (EditText) findViewById(R.id.screen);
        edScreen.setText("");
        num0 = (Button) findViewById(R.id.num0);

        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        dot = (Button) findViewById(R.id.dot);
        plus = (Button) findViewById(R.id.sumation);
        minus = (Button) findViewById(R.id.subtraction);
        multiply = (Button) findViewById(R.id.multiplication);
        division = (Button) findViewById(R.id.division);
        equal = (Button) findViewById(R.id.equal);
        clear = (Button) findViewById(R.id.clear);
    }


    private void setNumericOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Button btn = (Button) view;
                    edScreen.append(btn.getText().toString());
                } catch (Exception e) {
                    System.out.println(61 + " " + e.getMessage());
                }
            }
        };
        findViewById(R.id.num0).setOnClickListener(listener);
        findViewById(R.id.num1).setOnClickListener(listener);
        findViewById(R.id.num2).setOnClickListener(listener);
        findViewById(R.id.num3).setOnClickListener(listener);
        findViewById(R.id.num4).setOnClickListener(listener);
        findViewById(R.id.num5).setOnClickListener(listener);
        findViewById(R.id.num6).setOnClickListener(listener);
        findViewById(R.id.num7).setOnClickListener(listener);
        findViewById(R.id.num8).setOnClickListener(listener);
        findViewById(R.id.num9).setOnClickListener(listener);
    }

    private void setOperationOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edScreen.getText().toString().endsWith("+")
                        || edScreen.getText().toString().endsWith("-")
                        || edScreen.getText().toString().endsWith("*")
                        || edScreen.getText().toString().endsWith("/")) {
                    System.out.println("nothing");
                } else {
                    Button button = (Button) view;
                    edScreen.append(button.getText());
                }

            }
        };
        findViewById(R.id.sumation).setOnClickListener(listener);
        findViewById(R.id.subtraction).setOnClickListener(listener);
        findViewById(R.id.multiplication).setOnClickListener(listener);
        findViewById(R.id.division).setOnClickListener(listener);

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edScreen.setText("");
            }
        });

    }


}
