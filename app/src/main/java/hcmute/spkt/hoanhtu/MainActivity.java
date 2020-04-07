package hcmute.spkt.hoanhtu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edScreen;
    private TextView num1,num2,num3,num4,num5,num6,num7,num8,num9,num0;
    private TextView dot,cong,tru,nhan,chia,bang,txtC;

    private String firstNum="";
    private String secondNum="";
    private String result="";
    private String current="";
    private String dau="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();

    }
    private void findID() {
        edScreen = (EditText) findViewById(R.id.screen);
        num0 = (TextView) findViewById(R.id.num0);
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        num3 = (TextView) findViewById(R.id.num3);
        num4 = (TextView) findViewById(R.id.num4);
        num5 = (TextView) findViewById(R.id.num5);
        num6 = (TextView) findViewById(R.id.num6);
        num7 = (TextView) findViewById(R.id.num7);
        num8 = (TextView) findViewById(R.id.num8);
        num9 = (TextView) findViewById(R.id.num9);
        dot = (TextView) findViewById(R.id.dot);
        cong = (TextView) findViewById(R.id.sumation);
        tru = (TextView) findViewById(R.id.subtraction);
        nhan = (TextView) findViewById(R.id.multiplication);
        chia = (TextView) findViewById(R.id.division);
        bang = (TextView) findViewById(R.id.equal);

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="0";
                edScreen.setText(current);
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="1";
                edScreen.setText(current);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="2";
                edScreen.setText(current);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="3";
                edScreen.setText(current);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="4";
                edScreen.setText(current);
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="5";
                edScreen.setText(current);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="6";
                edScreen.setText(current);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="7";
                edScreen.setText(current);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="8";
                edScreen.setText(current);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current+="9";
                edScreen.setText(current);

            }
        });
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNum=current;
                Log.d("TEST",firstNum);
                dau="+";
                current="";
                edScreen.setText(current);
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNum=current;
                Log.d("TEST",firstNum);
                dau="-";
                current="";
                edScreen.setText("");
            }
        });
        nhan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                firstNum=current;
                dau="*";
                current="";
                edScreen.setText("");
            }
        });
        chia.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                firstNum=current;
                dau="/";
                current="";
                edScreen.setText("");
            }
        });
        bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondNum=current;
                Caculator caculator=new Caculator();
                String result="";
                if(dau.equals("+")==true){
                    result=caculator.Add(firstNum,secondNum);
                }
                if(dau.equals("-")==true){
                    result=caculator.Subtract(firstNum,secondNum);
                }
                if(dau.equals("*")==true){
                    result=caculator.Multiple(firstNum,secondNum);
                }
                if(dau.equals("/")==true){
                    result=caculator.Divide(firstNum,secondNum);
                }
                edScreen.setText(result);
                firstNum="";
                secondNum="";
                current="";
            }
        });
    }
}
