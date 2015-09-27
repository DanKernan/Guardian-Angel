package rick.guardianangel;

import android.content.Intent;

/**
 * Created by Rick on 9/26/2015.
 */
public class fft {
    private accel a;
    public fft(){
        //Intent start = new Intent(MainActivity.this,accel.class);
    }

    public double getAvg(){
        double total = 0;
        for (int i = 0; i < a.getDataSize(); i++){
            total += a.getData()[i];
        }
        double avg = total/(double)a.getDataSize();
        return avg;
    }
}
