package sg.edu.np.mad.week2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    final String title = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(title, "Create!");
        // make user object
        User u = new User("MAD", "Description", 00, false);

        // find and connect to the txtName text view and set as user name
        TextView Name = findViewById((R.id.txtName));
        Name.setText(u.name);

        Button followButton = findViewById(R.id.followBtn);

        // toast message for follow and unfollow
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (u.followed){
                    u.followed = false;
                    followButton.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    u.followed = true;
                    followButton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // challenge for message button fragment
        Button messageButton =findViewById(R.id.MessageBtn);

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });

        // to fragment 2
        Intent intentFrag2 = getIntent();
        Integer number = intentFrag2.getIntExtra("rNumber", -1);

        String text = u.name + number;
        Name.setText(text);

    }
}