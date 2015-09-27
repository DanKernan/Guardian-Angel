package rick.guardianangel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity {

    protected Vibrator vibrate;
    protected long lastSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


    }

    public void alert()
    {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.rickastley_artists);//music
        mp.start();
        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);//vibration
        int vibby = 10000;
        vibrate.vibrate(vibby);

        new AlertDialog.Builder(this)
                .setTitle("Fall Detected")
                .setMessage("ARE YOU OKAY?? GET UP BIIIIITCH?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {//stops vibration and music
                        mp.stop();
                        vibrate.cancel();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {//calls rick
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:2165369645"));//hard coded rick's number
                        startActivity(intent);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
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
