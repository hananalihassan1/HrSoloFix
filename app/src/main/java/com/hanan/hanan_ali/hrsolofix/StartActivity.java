package com.hanan.hanan_ali.hrsolofix;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity
{
    FloatingActionButton fab;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EmployeeAdapter employeeAdapter;
    List<EmployeesList> employeesLists;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ProgressBar progressbar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        fab = findViewById(R.id.fab);
        recyclerView=findViewById(R.id.recyclerview);
        progressbar=findViewById(R.id.progressbar);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        employeesLists=new ArrayList<>();
        progressDialog = new ProgressDialog(StartActivity.this);

        progressDialog.setMessage("getting employees ...");

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        progressDialog.show();

        progressDialog.setCancelable(false);

        employeeAdapter=new EmployeeAdapter(getApplicationContext(),employeesLists);
        recyclerView.setAdapter(employeeAdapter);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("allemplyees");
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)

            {
                employeesLists.clear();

                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {


                    EmployeesList employeesList2=snapshot.getValue(EmployeesList.class);
                    employeesLists.add(employeesList2);

                }
                employeeAdapter.notifyDataSetChanged();
                progressbar.setVisibility(View.GONE);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                progressbar.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext() , databaseError.getMessage() , Toast.LENGTH_SHORT).show();




                progressDialog.dismiss();


            }
        });


        fab.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v)

            {

                Intent intent = new Intent(getApplicationContext(), AddNewEmployeeActivity.class);

                startActivity(intent);

            }

        });

    }

    @Override
    public void onBackPressed() {

        finish();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {

            case R.id.sign_out:

                FirebaseAuth.getInstance().signOut();

                Intent n = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(n);

                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }




}





