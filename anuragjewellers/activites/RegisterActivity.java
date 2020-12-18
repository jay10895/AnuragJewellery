package com.example.anuragjewellers.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.bumptech.glide.Glide;
import com.example.anuragjewellers.model.Register;
import com.example.anuragjewellers.network.GetDataService;
import com.example.anuragjewellers.network.RetrofitClientInstance;
import com.example.anuragjewellers.utils.PrefManager;
import com.example.anuragjewellery.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

public class RegisterActivity extends AppCompatActivity {

    ArrayList<String> Role= new ArrayList<>();
    ArrayList<String> Manu = new ArrayList<>();

    String rolespivalue="",menuspivalue="";
    private TextInputEditText username;
    private TextInputEditText mobile_number;
    private TextInputEditText email;
    private TextInputEditText password;
    private TextInputEditText confirm_password;
    private Spinner spinner;
    private Spinner spin_register;
    private ImageView imageView;
    private EditText role_regis_man;

    AwesomeValidation awesomeValidation;
    ProgressDialog progressDialog;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        prefManager = new PrefManager(this);



        Role.add("salesman");
        Role.add("manufacture");

        Manu.add("Vivek");
        Manu.add("sanjay");
        username = findViewById(R.id.edit_username);
        mobile_number = findViewById(R.id.edit_mobile);
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_password);
        confirm_password = findViewById(R.id.edit_confirm_password);

        /*role = findViewById(R.id.role_regis);*/
        imageView = findViewById(R.id.back);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));

            }
        });

        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setMessage("Loading....");

        awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation  = new AwesomeValidation(COLORATION);

        spinner = findViewById(R.id.spinner_regis);


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Role);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter SalesManData on the Spinner
        spinner.setAdapter(aa);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(getApplicationContext(),Role[position], Toast.LENGTH_SHORT).show();



                rolespivalue=Role.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        role_regis_man= findViewById(R.id.role_regis_man);
        role_regis_man.setVisibility(View.INVISIBLE);

        spin_register= findViewById(R.id.spin_register);
        spin_register.setVisibility(View.INVISIBLE);




        spin_register.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                menuspivalue=Manu.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void confirmInput(View view){
        String Username = username.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Phone_number = mobile_number.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String Confirm_password = confirm_password.getText().toString().trim();
        //  String Role = role.getText().toString().trim();

        if (Username.isEmpty()) {
            username.setError("Please enter username");
            username.requestFocus();
            return;
        }
        if (Phone_number.isEmpty()){
            mobile_number.setError("Please enter phone number");
            mobile_number.requestFocus();
            return;
        }
        if (!Patterns.PHONE.matcher(Phone_number).matches()){
            mobile_number.setError("Please enter valid phone number");
            mobile_number.requestFocus();
            return;
        }

        if (Email.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("Enter valid email address");
            email.requestFocus();
            return;
        }
        if (Password.isEmpty()){
            password.setError("Password required");
            password.requestFocus();
            return;
        }
        if (Password.length() < 6){
            password.setError("Password should be atleast 6 character long");
            password.requestFocus();
            return;
        }

        if (Confirm_password.isEmpty()){
            confirm_password.setError("Confirm password required");
            confirm_password.requestFocus();
            return;
        }

        /*if (Confirm_password.equals(Password)){
            confirm_password.setError("Confirm password and password does not match");
            confirm_password.requestFocus();
            return;
        }*/



        callRegisterApi();

    }

    public void callRegisterApi(){
        progressDialog.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Register> call = service.register(username.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                confirm_password.getText().toString(),
                mobile_number.getText().toString(),
                rolespivalue);

        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                progressDialog.dismiss();
                /*Register register = (Register) response;*/

                if(response.isSuccessful()){
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    prefManager.saveRegisterDetails(username.getText().toString(),mobile_number.getText().toString(),email.getText().toString());


                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    Toast.makeText(RegisterActivity.this, "User register successfully", Toast.LENGTH_SHORT).show();


                }
                if (response.code() == 200 && response.body().getCode() == 200) {

                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Something went wrong please try again later", Toast.LENGTH_SHORT).show();

            }
        });
    }

  /*  @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

}