package com.example.marcos.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

/**
 * Created by Pantufa on 24/11/2016.
 */
public class PlacePickerActivity extends Activity {
    private TextView get_place;
    int PLACE_PICKER_REQUEST = 1;
    int status = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (status != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(status)) {
                GooglePlayServicesUtil.getErrorDialog(status, this, 100).show();
            }
        }

        if(status == ConnectionResult.SUCCESS){
            PLACE_PICKER_REQUEST = 199;
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            Context context = this;
            try{
                startActivityForResult(builder.build((Activity) context), PLACE_PICKER_REQUEST);
            }catch (GooglePlayServicesRepairableException e){
                e.printStackTrace();
            }catch (GooglePlayServicesNotAvailableException e){
                e.printStackTrace();
            }
        }
        get_place = (TextView) findViewById(R.id.textView); // inserir no xml
       // get_place.setOnClickListener(new View.OnClickListener() {


           /* @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                Intent intent;
                intent = builder.build(getApplicationContext());
                Context context = intent;

                try{
                    startActivityForResult(builder.build(context), PLACE_PICKER_REQUEST);
                    System.out.print("");

                }catch (GooglePlayServicesRepairableException e){
                    e.printStackTrace();
                }catch (GooglePlayServicesNotAvailableException e){
                    e.printStackTrace();
                }
            }
            }*/
        //});
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100){
            status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        }
        if (requestCode == 199){

            //process Intent......
            Place place = PlacePicker.getPlace(data, this);
            String toastMsg = String.format("Place: %s", place.getName());
            Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            String address = String.format("Local : %s",place.getAddress());
            get_place.setText(address);
        }

        /*if(requestCode == PLACE_PICKER_REQUEST){
            if(resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(data, this);
                String address = String.format("Local : %s",place.getAddress());
                get_place.setText(address);
            }
        }*/
    }
/*
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
*/

}
