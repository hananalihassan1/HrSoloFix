package com.hanan.hanan_ali.hrsolofix;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeLoginRegisterActivity extends AppCompatActivity
{
    Button employ_lon,register_employee;
    TextView register_linkemployee,employeestatuse;
    EditText email_employee,password_employee;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;
    public FirebaseDatabase firebaseDatabase;
    FirebaseUser user;
     ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login_register);
        firebaseDatabase=FirebaseDatabase.getInstance();



        mAuth=FirebaseAuth.getInstance();
        loadingBar=new ProgressDialog(this);

        employ_lon=findViewById(R.id.employ_lon);
        register_employee=findViewById(R.id.register_employee);
        register_linkemployee=findViewById(R.id.register_linkemployee);
        employeestatuse=findViewById(R.id.employeestatuse);
        email_employee=findViewById(R.id.email_employee);
        password_employee=findViewById(R.id.password_employee);
        register_employee.setVisibility(View.INVISIBLE);
        register_employee.setEnabled(false);
        register_linkemployee.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                employ_lon.setVisibility(View.INVISIBLE);
                register_linkemployee.setVisibility(View.INVISIBLE);
                register_employee.setVisibility(View.VISIBLE);
                register_employee.setEnabled(true);
                employeestatuse.setText("Register Employee");



            }
        });
        register_employee.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email=email_employee.getText().toString();
                String password=password_employee.getText().toString();
                if (email.length() == 0 || password.length() == 0)

                {

                    Toast.makeText(getApplicationContext(), "please enter email and password", Toast.LENGTH_SHORT).show();

                } else

                {
                    RegisterEmployee(email,password);





                }

            }
        });

        employ_lon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email=email_employee.getText().toString();
                String password=password_employee.getText().toString();
                if (email.length() == 0 || password.length() == 0)

                {

                    Toast.makeText(getApplicationContext(), "please enter email and password", Toast.LENGTH_SHORT).show();

                } else

                {

                    SignInEmployee(email,password);




                }










            }
        });

    }

    private void SignInEmployee(String email, String password)
    {
        loadingBar.setTitle("Employee LogIn ...");
        loadingBar.setMessage("Please Wait ,while we are  checking your credientials   ");
        loadingBar.show();
        mAuth.signInWithEmailAndPassword(email, password)

                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task)

                    {

                        if (task.isSuccessful())

                        {

                            user = mAuth.getCurrentUser();



                            if (user != null)

                            {

                                if (user.isEmailVerified())

                                {

                                    //progressBar.setVisibility(View.INVISIBLE);
                                    loadingBar.dismiss();




                                    Intent intent = new Intent(getApplicationContext(), LeavesActivity.class);

                                    startActivity(intent);

                                } else

                                {

                                   // progressBar.setVisibility(View.INVISIBLE);
                                    loadingBar.dismiss();




                                    Toast.makeText(getApplicationContext(), "Please Verify Your Email", Toast.LENGTH_SHORT).show();

                                }

                            }

                        } else

                        {

                           // progressBar.setVisibility(View.INVISIBLE);
                            loadingBar.dismiss();




                            Toast.makeText(getApplicationContext(), "wrong email or password", Toast.LENGTH_SHORT).show();

                        }

                    }

                });


    }

    private void RegisterEmployee(String email, String password)
    {
        loadingBar.setTitle("Employee Registration...");
        loadingBar.setMessage("Please Wait ,while we are register your data ");
        loadingBar.show();
        mAuth.createUserWithEmailAndPassword(email, password)

                .addOnCompleteListener(new OnCompleteListener<AuthResult>()

                {

                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task)

                    {

                        if (task.isSuccessful())

                        {

                            user = mAuth.getCurrentUser();



                            if (user != null)

                            {

                                user.sendEmailVerification();
                                loadingBar.dismiss();




                                Intent intent = new Intent(getApplicationContext(), LeavesActivity.class);

                                startActivity(intent);

                            }

                        } else

                        {
                            loadingBar.dismiss();


                            Toast.makeText(getApplicationContext(), "this email has been signed up", Toast.LENGTH_SHORT).show();

                        }

                    }

                });

    }
}

