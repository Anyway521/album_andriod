package drsn.pk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private ImageView Image;
    private TextView mtext;
    private int num;
    private int index;
    private String[] title;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

        title = new String[]{"第1张图片","第2张图片","第3张图片","第4张图片","第5张图片"};

        images = new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5};
        Image.setImageResource(images[0]);
        mtext.setText(title[0]);
        num = title.length;
        index = 0;
    }

    private void initView() {
        Image = findViewById(R.id.show);
        mtext = findViewById(R.id.tshow);
        findViewById(R.id.btn_pre).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pre:
                if(index == 0){
                    index = title.length-1;
                }else{
                    index--;
                }

                break;
            case R.id.btn_next:
                if(index == title.length-1){
                    index = 0;
                }else{
                    index++;
                }
                break;
        }
        updateImageandTitle();
    }

    private void updateImageandTitle() {
         Image.setImageResource(images[index]);
         mtext.setText(title[index]);

    }

}
