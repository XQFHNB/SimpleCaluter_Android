package com.example.calculater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity implements OnClickListener  {

    /*   Button bt;
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            Log.d("MainActivity","jgjhththkhkytj");
            setContentView(R.layout.activity_main);
            bt=(Button) findViewById(R.id.btn_0);

            bt.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "I lovr ", Toast.LENGTH_SHORT).show();
                }
            });
        }*/

      Button btn_0;
      Button btn_1;
      Button btn_2;
      Button btn_3;
      Button btn_4;
      Button btn_5;
      Button btn_6;
      Button btn_7;
      Button btn_8;
      Button btn_9;
      Button btn_clear;
      Button btn_del;
      Button btn_div;
      Button btn_multi;
      Button btn_equal;
      Button btn_minus;
      Button btn_point;
      Button btn_plus;
      EditText eText;
    boolean needclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button)findViewById(R.id.btn_0);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9=(Button) findViewById(R.id.btn_9);
        btn_clear=(Button) findViewById(R.id.btn_clear);
        btn_del=(Button) findViewById(R.id.btn_del);
        btn_div=(Button) findViewById(R.id.btn_div);
        btn_multi=(Button) findViewById(R.id.btn_multi);
        btn_point=(Button) findViewById(R.id.btn_point);
        btn_equal=(Button) findViewById(R.id.btn_equal);
        btn_minus=(Button)findViewById(R.id.btn_minus);
        eText=(EditText)findViewById(R.id.et_input);
        btn_plus=(Button) findViewById(R.id.btn_plus);
     
        Log.d("MainActivity", "I love you");
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_plus.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        String str=eText.getText().toString();
        switch (v.getId()) {
        case R.id.btn_0:
        case R.id.btn_1:
        case R.id.btn_2:
        case R.id.btn_3:
        case R.id.btn_4:
        case R.id.btn_5:
        case R.id.btn_6:
        case R.id.btn_7:
        case R.id.btn_8:
        case R.id.btn_9:
        case R.id.btn_point:
            if(needclear) {
                str = "";
                eText.setText("");
            }
            eText.setText(str+((Button)v).getText());
            break;
        case R.id.btn_plus:
        case R.id.btn_minus:
        case R.id.btn_multi:
        case R.id.btn_div:
            if(needclear) {
                eText.setText("");
            }
            eText.setText(str+" "+((Button)v).getText()+" ");
            break;
        case R.id.btn_clear:
            eText.setText(" ");
            break;
        case R.id.btn_del:
            if(str!=null&&str.equals(" ")) {
                eText.setText(str.substring(0,str.length()-1));
            }
            break;
        case R.id.btn_equal:
            getResult();
            break;
        default:
            break;
        }
    }
     private void getResult() {
        needclear=true;
        String str=eText.getText().toString();
        double r=0;
        int space=str.indexOf(' ');
        String s1=str.substring (0,space);
        String op=str.substring(space+1,space+2);
        String s2=str.substring(space+3);
        double a=Double.parseDouble(s1);
        double b=Double.parseDouble(s2);
        if(op.equals("+")) {
            r=a+b;
        } else if(op.equals("-")) {
            r=a-b;
        } else if(op.equals("*")) {
            r=a*b;
        } else if(op.equals("/")) {
            if(b==0) {
                r=0;
            } else {
                r=a/b;
            }
        }
        if(!s1.contains(".")&&!s2.contains(".")) {
            int result=(int )r;
            eText.setText(result+"");
        } else {
            eText.setText(r+"");
        }
    }
}
