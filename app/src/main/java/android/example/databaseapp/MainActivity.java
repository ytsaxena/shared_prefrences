package android.example.databaseapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;



public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        SharedPreferences sp = getSharedPreferences("mysp", MODE_PRIVATE);
        String editval= sp.getString("text","nothing"); //for retrieve data
        textView.setText(editval);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = editText.getText().toString();
                SharedPreferences sp = getSharedPreferences("mysp", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("text",val);
                editor.apply();
                textView.setText(val);
                
            }
        });



    }


}
