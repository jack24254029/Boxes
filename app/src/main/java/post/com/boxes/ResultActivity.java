package post.com.boxes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import post.com.boxes.model.BaseBox;

public class ResultActivity extends AppCompatActivity {

    private BaseBox box;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        box = getIntent().getParcelableExtra("BOX");
        initView();
    }

    private void initView() {
        TextView textBoxName = findViewById(R.id.textResultBoxName);
        if (box == null) {
            textBoxName.setText("No box can use.");
            return;
        }
        textBoxName.setText(box.getName());
        TextView textDimension = findViewById(R.id.textResultDimensionValue);
        textDimension.setText(box.toString());
        TextView textPrice = findViewById(R.id.textResultPriceValue);
        textPrice.setText(String.valueOf(box.getPrice()));
    }
}
