package post.com.boxes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import post.com.boxes.model.Box3;
import post.com.boxes.model.Box5;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private EditText editLenght;
    private EditText editWidth;
    private EditText editHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        editLenght = findViewById(R.id.editMainLength);
        editWidth = findViewById(R.id.editMainWidth);
        editHeight = findViewById(R.id.editMainHeight);
        Button btnCheck = findViewById(R.id.btnMainCheck);
        btnCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMainCheck:
                if (editLenght.getText().toString().isEmpty() ||
                        editWidth.getText().toString().isEmpty() ||
                        editHeight.getText().toString().isEmpty()) {
                    Toast.makeText(this, "長、寬、高，請完整輸入", Toast.LENGTH_SHORT).show();
                    return;
                }
                double length = Double.parseDouble(editLenght.getText().toString());
                double width = Double.parseDouble(editWidth.getText().toString());
                double height = Double.parseDouble(editHeight.getText().toString());
                checkBox(length, width, height);
                break;
        }
    }

    private void checkBox(double length, double width, double height) {
        Box3 box3 = new Box3();
        Box5 box5 = new Box5();
        Intent intent = new Intent(this, ResultActivity.class);
        if (box3.check(length, width, height)) {
            intent.putExtra("BOX", box3);
        } else if (box5.check(length, width, height)) {
            intent.putExtra("BOX", box5);
        }
        startActivity(intent);
    }
}
