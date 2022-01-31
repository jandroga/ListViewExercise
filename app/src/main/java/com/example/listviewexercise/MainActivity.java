package com.example.listviewexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3;
    private ListView listView;
    private TextView selection;
    private static final String[] items={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.icon);
        imageView2 = findViewById(R.id.icon2);
        imageView3 = findViewById(R.id.icon3);
        listView = findViewById(R.id.list);
        listView.setAdapter(new IconicAdapter());
        selection=(TextView)findViewById(R.id.selection);
    }

    public void asdiop(View imageView){
        imageView.setOnClickListener(v -> ((ImageView) imageView).setImageDrawable(getDrawable(android.R.drawable.btn_star_big_on)));
    }

    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        selection.setText(items[position]);
    }

    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(MainActivity.this, R.layout.list_item, items);
        }

        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View row=convertView;

            if (row==null) {
                LayoutInflater inflater=getLayoutInflater();

                row=inflater.inflate(R.layout.list_item, parent, false);
            }

            TextView label=(TextView)row.findViewById(R.id.textView);

            label.setText(items[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.icon);



            return(row);
        }
    }

}