package sg.edu.np.mad.week2project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    final String title = "List Activity"; // differentiate Main Activity from List Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView startImage = findViewById(R.id.startImg);

        // when image is clicked start the alert dialogue
        startImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random num = new Random();
                Integer randNum = num.nextInt(999999999);

                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        // going to main activity and throwing over random number
                        Intent ToMainIntent = new Intent(ListActivity.this, MainActivity.class);
                        ToMainIntent.putExtra("rNumber", randNum);
                        startActivity(ToMainIntent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                    }
                });

                builder.show();
            }
        });
    }
}