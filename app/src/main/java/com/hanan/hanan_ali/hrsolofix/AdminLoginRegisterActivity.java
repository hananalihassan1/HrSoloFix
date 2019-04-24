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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class AdminLoginRegisterActivity extends AppCompatActivity
{
    private Button admin_lon,register_admin;
    private TextView register_linkadmin,adminstatus;
    private EditText email_admin,password_admin;
     private FirebaseAuth mAuth;
     private ProgressDialog loadingBar;
     public FirebaseDatabase firebaseDatabase;
    FirebaseUser user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_register);
        firebaseDatabase=FirebaseDatabase.getInstance();



        mAuth=FirebaseAuth.getInstance();

        admin_lon=findViewById(R.id.admin_lon);
        register_admin=findViewById(R.id.register_admin);
        loadingBar=new ProgressDialog(this);
        register_linkadmin=findViewById(R.id.register_linkadmin);
        adminstatus=findViewById(R.id.adminstatus);
        email_admin=findViewById(R.id.email_admin);
        password_admin=findViewById(R.id.password_admin);
        register_admin.setVisibility(View.INVISIBLE);
        register_admin.setEnabled(false);
        register_linkadmin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                admin_lon.setVisibility(View.INVISIBLE);
                register_linkadmin.setVisibility(View.INVISIBLE);
                register_admin.setVisibility(View.VISIBLE);
                register_admin.setEnabled(true);
                adminstatus.setText("Register Admin");



            }
        });
        register_admin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email=email_admin.getText().toString();
                String password=password_admin.getText().toString();
                if (email.length() == 0 || password.length() == 0)

                {

                    Toast.makeText(getApplicationContext(), "please enter email and password", Toast.LENGTH_SHORT).show();

                } else

                {

                    RegisterAdmin(email,password);




                }

            }
        });
        admin_lon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email=email_admin.getText().toString();
                String password=password_admin.getText().toString();
                if (email.length() == 0 || password.length() == 0)

                {

                    Toast.makeText(getApplicationContext(), "please enter email and password", Toast.LENGTH_SHORT).show();

                } else

                {

                    SignInAdmin(email,password);




                }





            }
        });
    }

    private void SignInAdmin(String email, String password)
    {
        loadingBar.setTitle("Admin LogIn ...");
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

                                    loadingBar.dismiss();




                                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);

                                    startActivity(intent);

                                } else

                                {

                                    loadingBar.dismiss();




                                    Toast.makeText(getApplicationContext(), "Please Verify Your Email", Toast.LENGTH_SHORT).show();

                                }

                            }

                        } else

                        {
                            loadingBar.dismiss();





                            Toast.makeText(getApplicationContext(), "wrong email or password", Toast.LENGTH_SHORT).show();

                        }

                    }

                });


    }


    private void RegisterAdmin(String email, String password)
    {
        loadingBar.setTitle("Admin Registration...");
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



                                Intent intent = new Intent(getApplicationContext(), StartActivity.class);

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
