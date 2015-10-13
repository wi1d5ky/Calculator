package cc.wildsky.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(View v) {
        TextView t = (TextView)findViewById(R.id.display);
        t.setText("歸零囉！");
    }

    public void showNum(Number num) {
        TextView t = (TextView)findViewById(R.id.display);
        String s = num.toString();
        t.setText(s);
    }
}
