package com.example.bookabook.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookabook.R;
import com.example.bookabook.ui.Singleton;
import com.example.bookabook.ui.gallery.GalleryFragment;
import com.example.bookabook.ui.myCart.MyCartFragment;
import com.example.bookabook.ui.register.RegisterFragment;
import com.google.android.material.snackbar.Snackbar;

import static com.example.bookabook.ui.Singleton.getInstance;


public class LogInFragment extends Fragment {

    private LogInViewModel logInViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        logInViewModel =
                ViewModelProviders.of(this).get(LogInViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        final EditText email = root.findViewById(R.id.et_emailFromLogin);
        final EditText pass = root.findViewById(R.id.et_passFromLogin);

        Button login = root.findViewById(R.id.b_LoginFromLogin);
        Button register = root.findViewById(R.id.b_RegisterFromLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().isEmpty() && pass.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please write your login credentials", Snackbar.LENGTH_SHORT).show();
                } else if (email.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please write the email", Snackbar.LENGTH_SHORT).show();
                } else if (pass.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please write the password", Snackbar.LENGTH_SHORT).show();
                }
                else {
                    getInstance().username = email.getText().toString();
                    getInstance().logedIn = true;

                    if (getInstance().book.equals("Your card is empty")) {
                        Fragment fragment = new GalleryFragment();
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.commit();
                    } else{
                        Fragment fragment = new MyCartFragment();
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.commit();
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new RegisterFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                fragmentTransaction.commit();
            }

        });

        return root;
    }
}