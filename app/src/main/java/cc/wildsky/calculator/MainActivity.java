package cc.wildsky.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String displayNum = "";
    int num1 = 0;
    String tmpNum2 = "";
    int num2 = 0;
    String opt = "";
    boolean optIsExist = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(View v) {
        num1 = 0;
        num2 = 0;
        tmpNum2 = "";
        opt = "";
        optIsExist = false;
        TextView t = (TextView)findViewById(R.id.display);
        displayNum = "";
        t.setText("歸零囉！");
    }

    public void clickNum(View v) {
        String theNum = v.getTag().toString();
        if(Objects.equals(displayNum, "0")) {
            Toast.makeText(v.getContext(), "零不能作為數字開頭 :(", Toast.LENGTH_LONG).show();
            displayNum = "";
        }
        TextView t = (TextView)findViewById(R.id.display);
        if(optIsExist) {
            tmpNum2 += theNum;
        }
        displayNum += theNum;
        t.setText(displayNum);
    }

    public void clickOPT(View v) {
        Button b = (Button) v;
        opt = b.getText().toString();
        TextView t = (TextView)findViewById(R.id.display);
        num1 = Integer.parseInt(displayNum);
        displayNum += opt;
        optIsExist = true;
        t.setText(displayNum);
    }

    public void calAns(View v) {
        num2 = Integer.parseInt(tmpNum2);
        int answer = 0;
        boolean err = false;
        switch (opt) {
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                if(num2 != 0) {
                    answer = num1 / num2;
                }
                else {
                    Toast.makeText(v.getContext(), "不能除以零… :(", Toast.LENGTH_LONG).show();
                    err = true;
                }
                break;
            default:
                Toast.makeText(v.getContext(), "出問題了… :(", Toast.LENGTH_LONG).show();
                err = true;
        }

        num1 = 0;
        num2 = 0;
        tmpNum2 = "";
        opt = "";
        optIsExist = false;

        TextView t = (TextView)findViewById(R.id.display);
        displayNum = "";
        if(err) {
            t.setText("(✘﹏✘ა)");
        }
        else {
            t.setText(Integer.toString(answer));
        }
    }
    public void smile(View v) {
        Toast.makeText(v.getContext(), "希望今天的你一切順遂 :D", Toast.LENGTH_LONG).show();
    }


}
