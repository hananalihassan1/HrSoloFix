package com.hanan.hanan_ali.hrsolofix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity
{
    Button welcom_admin_btn,welcom_employee_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        welcom_admin_btn=findViewById(R.id.welcom_admin_btn);
        welcom_employee_btn=findViewById(R.id.welcom_employee_btn);
        welcom_admin_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(),AdminLoginRegisterActivity.class);
                startActivity(i);

            }
        });
        welcom_employee_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(),EmployeeLoginRegisterActivity.class);
                startActivity(intent);

            }
        });


    }
}
