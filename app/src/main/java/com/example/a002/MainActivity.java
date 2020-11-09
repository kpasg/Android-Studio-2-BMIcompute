package com.example.a002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText H;
    EditText W;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        H = (EditText)findViewById(R.id.editTextTextPersonName);
        W = (EditText)findViewById(R.id.editTextTextPersonName2);
        Button submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                if ( !("".equals(H.getText().toString())
                        || "".equals(W.getText().toString())) )
                {
                    float h = Float.parseFloat(H.getEditableText().toString());
                    float w = Float.parseFloat(W.getEditableText().toString());
                    float fre;
                    TextView result = (TextView)findViewById(R.id.textView05);
                    h = h/100;
                    h = h*h;

                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    fre = w/h;
                    result.setText(nf.format(w/h) +"");
                    TextView dia = (TextView)findViewById(R.id.textView06);

                    if (fre<18.5)
                        dia.setText("過輕");
                    else if (18.5 <= fre && fre< 24)
                        dia.setText("正常");
                    else if (24 <=fre && fre < 27)
                        dia.setText("過    重");
                    else if (27 <=fre && fre < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fre && fre < 35)
                        dia.setText("中度肥胖");
                    else if (fre >= 35)
                        dia.setText("重度肥胖        ");
                }
            }
        });
    }
}