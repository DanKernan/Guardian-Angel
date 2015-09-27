package rick.guardianangel;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {
    private Handler accelHandler = new Handler();
    private double currentAvg;

//    private Runnable checkAccel = new Runnable() {
//        @Override
//        public void run() {
//            currentAvg = sensor.getAvg();
//            accelHandler.postDelayed(checkAccel,300);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentAvg = 0;
        //Intent startaccel = new Intent(this,accel.class);
        //this.startActivity(startaccel);
        //accelHandler.post(checkAccel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



            //Toast.makeText(this, "Baby pls", Toast.LENGTH_LONG).show();

            new AlertDialog.Builder(this).setTitle("Fall Detected").setMessage("ARE YOU OKAY??").setNegativeButton("I'm Okay.", null).show();

//            final int NOTIF_ID = 1234;
//
//            NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//            Notification note = new Notification(R.mipmap.ic_launcher, "Get up Bitch", System.currentTimeMillis());
//
//            PendingIntent intentp = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
//
//            //note.setLatestEventInfo(this, "New E-mail", "You have one unread message.", intentp);
//
//
//            notifManager.notify(NOTIF_ID, note);




//            Intent intent = new Intent(Intent.ACTION_CALL);
//            intent.setData(Uri.parse("tel:2165369645"));
//            startActivity(intent);
            //Intent intent = new Intent(this,SettingsActivity.class);
            //startActivity(intent);
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
