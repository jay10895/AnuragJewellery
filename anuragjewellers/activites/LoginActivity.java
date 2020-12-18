package com.example.anuragjewellers.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.anuragjewellers.model.Details;
import com.example.anuragjewellers.model.Login;
import com.example.anuragjewellers.network.GetDataService;
import com.example.anuragjewellers.network.RetrofitClientInstance;
import com.example.anuragjewellers.utils.PrefManager;
import com.example.anuragjewellery.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView Forget_password;
    CheckBox checkBoxRememberMe;
    TextInputEditText Password;
    TextInputEditText Username;

    AwesomeValidation awesomeValidation;
    ProgressDialog loadingBar;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefManager = new PrefManager(this);

        Initialized();

        loadingBar = new ProgressDialog(LoginActivity.this);
        loadingBar.setMessage("Loading....");
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    public void callLoginApi() {
        loadingBar.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Login> call = service.login(Username.getText().toString(), Password.getText().toString());
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                loadingBar.dismiss();
                if (response.isSuccessful()) {
                    prefManager.saveLoginDetails(Username.getText().toString(),Password.getText().toString(),true);
                    String UserDetail=new Gson().toJson(response.body().getDetails());
                    prefManager.saveUserDetail(UserDetail);
                    Details userDetail=new Gson().fromJson(prefManager.getUserDetail(),Details.class);
                    userDetail.getID();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(), "From Validate Succesfull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                loadingBar.dismiss();
                Toast.makeText(LoginActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Initialized() {
        Username = findViewById(R.id.editTextUsername);
        Password = findViewById(R.id.editTextPassword);
        Forget_password = findViewById(R.id.forget_pass);

        Forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });

    }

    public void confirmInput(View V) {

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation For Username
        awesomeValidation.addValidation(this, R
                .id.editTextUsername, RegexTemplate.NOT_EMPTY, R.string.invalid_user);

        if (awesomeValidation.validate()) {
            callLoginApi();


        } else {
            Toast.makeText(getApplicationContext(), "Validation Failed", Toast.LENGTH_SHORT).show();

        }

        //Add Validation For Password
        awesomeValidation.addValidation(this, R.id.editTextPassword, ".{6,}", R.string.invalid_password);
        if (awesomeValidation.validate()) {
            // On success
            Toast.makeText(getApplicationContext(), "From Validate Succesfull", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Validation Failed", Toast.LENGTH_SHORT).show();

        }
    }


    public void onBackPressed() {
        finish();
    }


}

