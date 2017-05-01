package leet.com.welcomepagedemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;

public class MainActivity extends Activity {
    private EditText name;
    private EditText age;
    private EditText height;
    private EditText weight;
    private RippleView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        name.getBackground().setAlpha(125);
        age= (EditText) findViewById(R.id.age);
        age.getBackground().setAlpha(125);
        height= (EditText) findViewById(R.id.height);
        height.getBackground().setAlpha(125);
        weight= (EditText) findViewById(R.id.weight);
        submit= (RippleView) findViewById(R.id.submit);
        weight.getBackground().setAlpha(125);
        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + 3);
                        height.setText(s);
                        height.setSelection(s.length());
                    }
                }
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    height.setText(s);
                    height.setSelection(2);
                }

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        height.setText(s.subSequence(0, 1));
                        height.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

        });
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + 3);
                        weight.setText(s);
                        weight.setSelection(s.length());
                    }
                }
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    weight.setText(s);
                    weight.setSelection(2);
                }

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        weight.setText(s.subSequence(0, 1));
                        weight.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

        });
//        SharedPreferences share=this.getSharedPreferences("shared",MODE_PRIVATE);
//        boolean isFirstRun=share.getBoolean("isFirstRun",true);
//        SharedPreferences.Editor editor=share.edit();
//        if(isFirstRun){
//           // Toast.makeText(this,"是第一次运行",Toast.LENGTH_SHORT).show();
//            editor.putBoolean("isFirstRun",false);
//            editor.commit();
//        }else{
//            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//            startActivity(intent);
//            //Toast.makeText(this,"不是第一次运行",Toast.LENGTH_SHORT).show();
//        }
    }
}
