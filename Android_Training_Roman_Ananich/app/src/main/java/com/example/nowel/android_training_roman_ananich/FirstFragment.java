package com.example.nowel.android_training_roman_ananich;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by Nowel on 31.03.2017.
 */

public class FirstFragment extends Fragment {
    WebView videoView;

    String name ;
    String email;
    Uri photoUrl;
    TextView textEamil;
    TextView textPass;
    TextView textValid;
    TextView emailText;
    TextView passwordText;
    private FirebaseAuth mAuth;

    boolean emailVerified;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      final View view = inflater.inflate(R.layout.fragment_first, container, false);

        textEamil=(TextView) view.findViewById(R.id.textView_profileEmail);
        textPass=(TextView) view.findViewById(R.id.textView_profilePass);
        textValid=(TextView) view.findViewById(R.id.textView_profileValid);

        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        Button buttonRegister=(Button) view.findViewById(R.id.email_create_button);
        Button buttonSignIn=(Button) view.findViewById(R.id.email_sign_in_button);
        emailText=(TextView) view.findViewById(R.id.email);
        passwordText=(TextView) view.findViewById(R.id.password);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    String email = emailText.getText().toString();
                    String password = passwordText.getText().toString();
                    createUser(email,password);
                }

                // createUser();
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    String email = emailText.getText().toString();
                    String password = passwordText.getText().toString();
                    loginUser(email,password);

                }

                // createUser();
            }
        });



        checkUser();


        return view;
    }

    public void checkUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            textEamil.setText(name);
            textPass.setText(email);

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Check if user is signed in (non-null) and update UI accordingly.
        checkUser();
        // updateUI(currentUser);
    }




    public void createUser(String email, String password){
        if ((email!= "")&&(password!="")) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //  Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                //   updateUI(user);
                            } else {
                                Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }

                            // ...
                        }
                    });
        }
    }

    public void loginUser(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });

    }

    public  void getUserInfo(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
        }
    }



    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void updateUI(FirebaseUser user){

    }


}
