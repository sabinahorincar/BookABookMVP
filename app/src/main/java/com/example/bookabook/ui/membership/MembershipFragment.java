package com.example.bookabook.ui.membership;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookabook.R;
import com.example.bookabook.ui.Singleton;
import com.example.bookabook.ui.myCart.MyCartFragment;
import com.example.bookabook.ui.register.RegisterViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MembershipFragment extends Fragment {

    private RegisterViewModel registerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registerViewModel =
                ViewModelProviders.of(this).get(RegisterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_membership, container, false);

        Button saveMembership = root.findViewById(R.id.b_saveMembership);
        final EditText address = root.findViewById(R.id.et_addressMembership);
        final EditText email = root.findViewById(R.id.et_emailMembership);
        final EditText phone = root.findViewById(R.id.et_phoneMembership);

        saveMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (address.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty() ) {
                    Snackbar.make(view, "Please complete all the fields", Snackbar.LENGTH_LONG).show();
                } else {
                    Singleton singleton = Singleton.getInstance();
                    singleton.hasMembership = true;

                    Fragment fragment = new MyCartFragment();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                    fragmentTransaction.commit();
                }

            }
        });

        return root;
    }
}