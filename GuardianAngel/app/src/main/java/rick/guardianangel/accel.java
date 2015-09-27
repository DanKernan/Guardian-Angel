package rick.guardianangel;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.TextView;
import java.lang.Math;

/**
 * Created by Rick on 9/26/2015.
 */
public class accel  implements SensorEventListener{
    public final int SAMPLERATE_US = 10000;
    public final int SAMPLETIME = 2000000;
    private int dataSize;

    private  SensorManager mSensorManager;
    private  Sensor mAccelerometer;
    private double[] accelData;
    private int counter;



    protected accel(SensorManager sm, MainActivity ma) {
        mSensorManager = sm;
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        dataSize =  SAMPLETIME/SAMPLERATE_US;
        accelData = new double[dataSize];
        counter = 0;
        Log.v("","constructed sm");
    }



    public void onResume() {
        mSensorManager.registerListener(this, mAccelerometer, SAMPLERATE_US);
    }

//    protected void onPause() {
//        //mSensorManager.unregisterListener(this);
//        //never stops listening
//    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        double magnitude= Math.sqrt(Math.pow(event.values[0],2)+
                                    Math.pow(event.values[1],2)+
                                    Math.pow(event.values[2],2))-9.8;

        accelData[counter]= magnitude;
        //Log.v("mag",""+magnitude);
        counter++;
        counter = counter % dataSize;

    }

    public double[] getData(){
        return accelData;
    }
    public int getDataSize(){
        return dataSize;
    }

    public double getAvg(){
        double total = 0;
        for (int i = 0; i < dataSize; i++){
            total += Math.abs(accelData[i]);
        }
        double avg = total/(double)dataSize;
        return avg;
    }



}
