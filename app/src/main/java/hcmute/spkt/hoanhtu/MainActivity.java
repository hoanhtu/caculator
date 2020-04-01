package hcmute.spkt.hoanhtu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edScreen;
    private TextView num1,num2,num3,num4,num5,num6,num7,num8,num9,num0;
    private TextView dot,cong,tru,nhan,chia,bang,txtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        
    }

    private void findID()
    {
        edScreen=(EditText)findViewById(R.id.screen);
        num0=(TextView)findViewById(R.id.num0);
        num1=(TextView)findViewById(R.id.num1);
        num2=(TextView)findViewById(R.id.num2);
        num3=(TextView)findViewById(R.id.num3);
        num4=(TextView)findViewById(R.id.num4);
        num5=(TextView)findViewById(R.id.num5);
        num6=(TextView)findViewById(R.id.num6);
        num7=(TextView)findViewById(R.id.num7);
        num8=(TextView)findViewById(R.id.num8);
        num9=(TextView)findViewById(R.id.num9);
        dot=(TextView)findViewById(R.id.dot);
        cong=(TextView)findViewById(R.id.sumation);
        tru=(TextView)findViewById(R.id.subtraction);
        nhan=(TextView)findViewById(R.id.multiplication);
        chia=(TextView)findViewById(R.id.division);

    }
}
