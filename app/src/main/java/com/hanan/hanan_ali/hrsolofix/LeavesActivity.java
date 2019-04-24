package com.hanan.hanan_ali.hrsolofix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class LeavesActivity extends AppCompatActivity
{
    Button it_req;
    TextView leave_txt;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaves);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(LeavesActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.select_leaves));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                String leave_txt=((TextView)view).getText().toString();
                if (leave_txt.equals("Emergencies"))
                    startActivity(new Intent(view.getContext(),EmergenciesActivity.class));
                if (leave_txt.equals("Attendance/Amendment"))
                    startActivity(new Intent(view.getContext(),AttendanceActivity.class));
                if (leave_txt.equals("Government Relation"))
                    startActivity(new Intent(view.getContext(),GovernmentActivity.class));
                if (leave_txt.equals("Cash Advance"))
                    startActivity(new Intent(view.getContext(),CashAdvanceActivity.class));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.requests_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.try_r:
                break;
            case R.id.it_req:
                Intent intent=new Intent(getApplicationContext(),ITActivity.class);
                startActivity(intent);


                break;

            case R.id.Company_c:
                Intent i=new Intent(getApplicationContext(),StampActivity.class);
                startActivity(i);



                //finish();
                break;
            case R.id.sign_out:
                Intent signintint=new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(signintint);



                //finish();
                break;
            case R.id.holiday_leaves:
                Intent holidayintint=new Intent(getApplicationContext(),HoldayLeavesActivity.class);
                startActivity(holidayintint);



                //finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }






}

