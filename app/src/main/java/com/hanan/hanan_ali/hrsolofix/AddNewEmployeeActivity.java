package com.hanan.hanan_ali.hrsolofix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewEmployeeActivity extends AppCompatActivity
{
    EditText name_emp, number_emp, j_date, Governorate, sec, regest_reason;
    Button regs_btn;
    String name, Governorat, section, regest_reas, date, number,kay;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_employee);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();


        name_emp = findViewById(R.id.name_emp);
        number_emp = findViewById(R.id.number_emp);
        j_date = findViewById(R.id.j_date);
        Governorate = findViewById(R.id.Governorate);
        sec= findViewById(R.id.sec);
        regest_reason = findViewById(R.id.regest_reason);
        regs_btn = findViewById(R.id.regs_btn);

        regs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = name_emp.getText().toString();
                Governorat = Governorate.getText().toString();
                section = sec.getText().toString();
                regest_reas = regest_reason.getText().toString();
                number = number_emp.getText().toString();
                date = j_date.getText().toString();


                if
                (name.length() == 0 || Governorat.length() == 0 || section.length() == 0 || regest_reas.length() == 0 || name_emp.length() == 0 || j_date.length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "please enter all the data! ", Toast.LENGTH_SHORT).show();
                }


                else
                {
                    writeSaveinDatabase(name, Governorat, section, regest_reas, number, date);
                    regs_btn.setEnabled(false);

                }







            }

        });



    }

    public void writeSaveinDatabase(String name, String Governorat, String section, String regest_reas, String number, String date)
    {
        EmployeesList employeesList = new EmployeesList(name, Governorat, section, regest_reas, number, date);





        String kay = databaseReference.child("allemplyees").push().getKey();
        databaseReference.child("allemplyees").child(kay).setValue(employeesList);



    }



}
