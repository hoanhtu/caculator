package hcmute.spkt.hoanhtu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText editTextScreen;
    public Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, dot;
    public Button plus, minus, multiply, division, equal, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        setNumericOnClickListener();
        setOperationOnClickListener();
    }

    private void findID() {
        editTextScreen = (EditText) findViewById(R.id.screen);
        editTextScreen.setText("");
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
                    editTextScreen.append(btn.getText().toString());
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

                String edScreenText = editTextScreen.getText().toString();

                // Just 2 operation are allowed in editText screen
                if (edScreenText.isEmpty() || edScreenText == null) {
                    // Only addition and subtraction are allowed
                    Button operationButton = (Button) view;
                    String operationText = operationButton.getText().toString();
                    if (operationText.equals("+") || operationText.equals("-")) {
                        editTextScreen.append(operationText);
                    } else {
                        // Do nothing
                    }
                } else {
                    if (edScreenText.length() == 1) {
                        Button operationButton = (Button) view;
                        String operationText = operationButton.getText().toString();
                        // If first letter is operation
                        if (edScreenText.charAt(0) == '+' || edScreenText.charAt(0) == '-') {
                            if (operationText.charAt(0) == '+' || operationText.charAt(0) == '-') {
                                editTextScreen.setText("");
                                editTextScreen.setText(operationText);
                            } else {
                                // do nothing
                            }
                        } else {
                            editTextScreen.append(operationText);
                        }
                    } else if (edScreenText.length() > 1) { // First letter is numeric
                        // All operation are allowed, but just Two Operation are allowed exists
                        Button operationButton = (Button) view;
                        String operationText = operationButton.getText().toString();
                        boolean isOperationExists = isOperationExists(edScreenText);
                        if (isOperationExists  ) {
                            if(edScreenText.charAt(edScreenText.length() - 1) == '+'
                                    || edScreenText.charAt(edScreenText.length() - 1) == '-'
                                    || edScreenText.charAt(edScreenText.length() - 1) == '*'
                                    || edScreenText.charAt(edScreenText.length() - 1) == '/') {
                                edScreenText = edScreenText.substring(0, edScreenText.length() - 1);
                                editTextScreen.setText(edScreenText);
                                editTextScreen.append(operationText);
                            }
                        } else {
                            editTextScreen.append(operationText);
                        }
                    }
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
                editTextScreen.setText("");
            }
        });

        findViewById(R.id.equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String result = getResult(editTextScreen.getText().toString());
                    editTextScreen.setText(result);
                } catch (Exception e) {
                    Log.d("Get result error", e.getMessage());
                    Toast.makeText(MainActivity.this, "Không tính được", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (canAddDot(editTextScreen.getText().toString())) {
                    editTextScreen.append(".");
                }
            }
        });
    }

    private boolean isOperationExists(String value) {
        for (int i = value.length() - 1; i > 0; i--) {
            if (value.charAt(i) == '+' || value.charAt(i) == '-' || value.charAt(i) == '*' || value.charAt(i) == '/')
                return true;
        }
        return false;
    }

    private boolean canAddDot(String value) {
        if (value.isEmpty() || value == null || value == "") return true;
        else {
            for (int i = value.length() - 1; i >= 0; i--) {
                if (value.charAt(i) == '.') return false;
                else if (value.charAt(i) == '+' || value.charAt(i) == '-' || value.charAt(i) == '*' || value.charAt(i) == '/')
                    return true;
            }
        }
        return true;
    }

    private String getResult(String sequenceCal) {
        String num1Str, num2Str, result;
        // get num2
        int splitIndex = -1;
        char operation = '!';
        for (int i = sequenceCal.length() - 1; i >= 0; i--) {
            if (sequenceCal.charAt(i) == '+' || sequenceCal.charAt(i) == '-' ||
                    sequenceCal.charAt(i) == '*' || sequenceCal.charAt(i) == '/') {
                splitIndex = i;
                operation = sequenceCal.charAt(i);
                break;
            }
        }
        if (operation == '!') {
            return sequenceCal;
        }
        num1Str = sequenceCal.substring(0, splitIndex);
        num2Str = sequenceCal.substring(splitIndex + 1, sequenceCal.length());
        System.out.println(num1Str + " - " + num2Str);
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double res = -1;
        switch (operation) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }
        return Double.toString(res);
    }

}