package com.example.pawsupapplication.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.ui.login.LoginViewModel;
import com.example.pawsupapplication.ui.login.LoginViewModelFactory;
import com.example.pawsupapplication.ui.apply.ApplyPage;
import com.example.pawsupapplication.databinding.ActivityLoginBinding;
import com.example.pawsupapplication.ui.petcard.AddCard;

/**
 * Class responsible for carrying out the action of the interface when someone "login".
 * @author Android Studio, Wader
 * @version 1.1
 * @since Oct 1st 2021
 */

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final TextView applyButton = findViewById(R.id.apply);
        final ProgressBar loadingProgressBar = binding.loading;

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                    finish();
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                //finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(LoginActivity.this, ApplyPage.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    //Temporary button launcher for pet card activity
    public void launchAddPetCard(View v){

        Intent i = new Intent(this, AddCard.class);
        startActivity(i);
    }

    //Moves from login page to register page when register button is clicked
    public void showRegister(View view) {
        setContentView(R.layout.activity_register);
    }

    //Moves from register page to login page when register button is clicked
    public void returnRegister(View view) {
        setContentView(R.layout.activity_login);
    }

    //Gets email, password, and confirm password fields, and verifies that password
    //inputs are valid. If valid, a toast is shown to the user.
    public void registerAccount(View view){
        EditText registerEmail = findViewById(R.id.createEmail);
        EditText registerPassword = findViewById(R.id.createPassword);
        EditText registerConfirmPassword = findViewById(R.id.confirmCreatePassword);

        boolean validUpperCase=false;
        boolean validLowerCase=false;
        boolean validSymbol=false;
        boolean validNumber=false;

        String stringRegPass=registerPassword.getText().toString();
        String stringRegPassConfirm=registerConfirmPassword.getText().toString();

        boolean validConfirm=(stringRegPassConfirm.equals(stringRegPass));

        if (stringRegPass.length()>=6) {
            for (int i = 0; i < stringRegPass.length(); i++) {
                char currentChar = stringRegPass.charAt(i);
                if (Character.isLetter(currentChar) && currentChar == Character.toUpperCase(currentChar)) {
                    validUpperCase = true;
                } else if (Character.isLetter(currentChar) && currentChar == Character.toLowerCase(currentChar)) {
                    validLowerCase = true;
                } else if (!Character.isLetterOrDigit(currentChar)) {
                    validSymbol = true;
                } else if (Character.isDigit(currentChar)) {
                    validNumber = true;
                }

            }
            if (validUpperCase && validLowerCase && validSymbol && validNumber && validConfirm) {
                Toast.makeText(getApplicationContext(), "Account Created!", Toast.LENGTH_SHORT).show();

            }
        }
        TextView testText = findViewById(R.id.testText);
        testText.setText(String.valueOf(validUpperCase)+String.valueOf(validLowerCase)+String.valueOf(validSymbol)+ String.valueOf(validNumber) + String.valueOf(validConfirm) +"||"+ stringRegPass +"||"+stringRegPassConfirm);
    }


}