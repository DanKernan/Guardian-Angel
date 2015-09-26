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

/**
 * Created by Rick on 9/26/2015.
 */
public class accel extends Activity implements SensorEventListener{


    private SensorManager sensorManager;
    private Sensor accelerometer;
    sensorManager = (sensorManager) getSystemService(Context.SENSOR_SERVICE);
    accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);





}
