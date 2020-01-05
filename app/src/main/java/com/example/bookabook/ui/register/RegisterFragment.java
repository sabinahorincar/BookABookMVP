package com.example.bookabook.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookabook.R;
import com.example.bookabook.ui.Singleton;
import com.example.bookabook.ui.gallery.GalleryFragment;
import com.example.bookabook.ui.home.HomeFragment;
import com.example.bookabook.ui.login.LogInFragment;
import com.google.android.material.snackbar.Snackbar;

import static com.example.bookabook.ui.Singleton.getInstance;


public class RegisterFragment extends Fragment {

    private RegisterViewModel registerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registerViewModel =
                ViewModelProviders.of(this).get(RegisterViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_register, container, false);


        final EditText name = root.findViewById(R.id.et_nameFromRegister);
        final EditText email = root.findViewById(R.id.et_emailFromRegister);
        final EditText pass1 = root.findViewById(R.id.et_pass1FromRegister);
        final EditText pass2 = root.findViewById(R.id.et_pass2FromRegister);

        Button login = root.findViewById(R.id.b_LoginFromRegister);
        Button register = root.findViewById(R.id.b_registerFromRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().isEmpty() || pass1.getText().toString().isEmpty() ||
                        pass2.getText().toString().isEmpty() ||  name.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please insert the data", Snackbar.LENGTH_SHORT).show();
                } else if (!(pass1.getText().toString().equals(pass2.getText().toString()))){
                    Snackbar.make(view, "Please reinsert your passwords", Snackbar.LENGTH_SHORT).show();
                }
                else {
                    getInstance().username = email.getText().toString();
                    getInstance().logedIn = true;

                    Fragment fragment = new GalleryFragment();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fragment);

                    fragmentTransaction.commit();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new LogInFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                fragmentTransaction.commit();
            }
        });

        return root;
    }
}