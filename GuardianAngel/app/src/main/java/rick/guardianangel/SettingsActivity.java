package rick.guardianangel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {


    protected long lastSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


    }
    //On Click will store the contact number in an intent
    public void setContact(View view) {
        Button btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View v){
                                       EditText userEntry = (EditText) findViewById(R.id.editText);
                                       String userData = userEntry.getText().toString();
                                       int userNumber= Integer.parseInt(userData);

                                       Intent intent = new Intent(SettingsActivity.this, SettingsActivity.class);
                                       intent.putExtra("contact", userNumber);
                                   }
                               }
        );
    }
    //On Click will store the alarm in an intent
    public void setAlarm(View view) {
        Button btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       EditText userEntry = (EditText) findViewById(R.id.editText2);
                                       String userData = userEntry.getText().toString();
                                       int userNumber2 = Integer.parseInt(userData);

                                       Intent intent = new Intent(SettingsActivity.this, SettingsActivity.class);
                                       intent.putExtra("alarm", userNumber2);
                                   }
                               }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
