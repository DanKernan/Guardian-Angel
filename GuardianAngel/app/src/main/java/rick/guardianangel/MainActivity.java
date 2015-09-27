package rick.guardianangel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Handler accelHandler = new Handler();
    private accel accelClass;
    private double currentAvg;
    private int alarm;
    private int eContact;
    private boolean awake;
    private Vibrator vibrate;

    public void alert()
    {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.rickastley_artists);//music
        mp.start();
        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);//vibration
        int vibby = 10000;
        vibrate.vibrate(vibby);
        new AlertDialog.Builder(this)
                .setTitle("Fall Detected")
                .setMessage("Are you ok? Do you need assistance?")
                .setPositiveButton("I'm Okay.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {//stops vibration and music
                        mp.stop();
                        vibrate.cancel();
                        awake = true;
                    }
                })
                .setNegativeButton("HELP ME!", new DialogInterface.OnClickListener() {//calls rick
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:4405914066"));//hard coded rick's number
                        startActivity(intent);
                        mp.stop();
                        awake = true;
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                //Log.v("OnTick log: ",""+awake);
                //if we want to do something every tick
            }

            public void onFinish() {
                if(awake==false){
                    mp.stop();
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:4405914066"));//hard coded rick's number
                    startActivity(intent);
                }
            }
        }.start();

    }

    public int geteContact() {
        return eContact;
    }

    public void seteContact(int eContact) {
        this.eContact = eContact;
    }



    public int getAlarm() {
        return alarm;
    }

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }


//    private void vibrateAlert(){
//        Vibrator vibrate;
//        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);
//        new AlertDialog.Builder(this).setTitle("Fall Detected").setMessage("ARE YOU OKAY?? GET UP BIIIIITCH").setNegativeButton("I'm Okay.", null).show();
//        int vibby = 5000;
//        vibrate.vibrate(vibby);
//    }

    private Runnable checkAccel = new Runnable() {
        @Override
        public void run() {
            //Log.v("","i got here");

            //Log.v("accel log: ",""+currentAvg);
            if (accelClass.getScore() >15){
                alert();
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

//  On click, start settings view
    public void sendMessage(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
