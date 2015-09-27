package rick.guardianangel;

import android.app.AlertDialog;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private Handler accelHandler = new Handler();
    private accel accelClass;
    private double currentAvg;

    private void vibrateAlert(){
        Vibrator vibrate;
        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        new AlertDialog.Builder(this).setTitle("Fall Detected").setMessage("ARE YOU OKAY?? GET UP BIIIIITCH").setNegativeButton("I'm Okay.", null).show();
        int vibby = 5000;
        vibrate.vibrate(vibby);
    }

    private Runnable checkAccel = new Runnable() {
        @Override
        public void run() {
            //Log.v("","i got here");
            currentAvg = accelClass.getAvg();
            Log.v("accel log: ",""+currentAvg);
            if (currentAvg >10){
                vibrateAlert();
            }
            else {
                accelHandler.postDelayed(checkAccel, 300);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.v("", "hi there");
        Handler accelHandler = new Handler();
        setContentView(R.layout.activity_main);
        currentAvg = 0;
        accelClass = new accel((SensorManager)getSystemService(SENSOR_SERVICE),this);
        //Intent startaccel = new Intent(this,accel.class);
        //this.startActivity(startaccel);
        accelHandler.post(checkAccel);



    }

    @Override
    protected void onResume(){
        super.onResume();
        accelClass.onResume();
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

            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;

//            Intent intent = new Intent(Intent.ACTION_CALL);
//            intent.setData(Uri.parse("tel:2165369645"));
//            startActivity(intent);
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
