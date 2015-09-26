package rick.guardianangel;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;
import java.lang.Math;

/**
 * Created by Rick on 9/26/2015.
 */
public class accel extends Activity implements SensorEventListener{
    public final int SAMPLERATE_US = 10;

    private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;
    private double[] accelData;
    private int counter;

    public accel() {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        accelData = new double[5000000/SAMPLERATE_US];

    }



    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SAMPLERATE_US);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        double magnitude= Math.sqrt(Math.pow(event.values[0],2)+
                                    Math.pow(event.values[1],2)+
                                    Math.pow(event.values[2],2))-9.8;


    }




}
