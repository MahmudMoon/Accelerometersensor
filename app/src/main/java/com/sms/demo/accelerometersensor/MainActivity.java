package com.sms.demo.accelerometersensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView tv_X,tv_Y,tv_Z;
    Sensor accelerometer;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_X = (TextView)findViewById(R.id.tv_x);
        tv_Y = (TextView)findViewById(R.id.tv_y);
        tv_Z = (TextView)findViewById(R.id.tv_z);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tv_X.setText(Double.toString(event.values[0]));
        tv_Y.setText(Double.toString(event.values[1]));
        tv_Z.setText(Double.toString(event.values[2]));

        Log.d("TagOne","X : "+event.values[0] + "Y : " + event.values[1] + " Z : "+ event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
