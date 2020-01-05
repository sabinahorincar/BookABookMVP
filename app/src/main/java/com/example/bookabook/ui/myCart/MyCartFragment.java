package com.example.bookabook.ui.myCart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookabook.R;
import com.example.bookabook.ui.Singleton;
import com.example.bookabook.ui.gallery.GalleryFragment;
import com.example.bookabook.ui.home.HomeFragment;
import com.example.bookabook.ui.home.HomeViewModel;
import com.example.bookabook.ui.login.LogInFragment;
import com.example.bookabook.ui.membership.MembershipFragment;
import com.google.android.material.snackbar.Snackbar;

public class MyCartFragment extends Fragment {

    public MyCartFragment(){}

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_mycart, container, false);

        TextView myCard = root.findViewById(R.id.tv_myCard);
        Singleton s = Singleton.getInstance();

        myCard.setText(s.book);

        TextView availability = root.findViewById(R.id.tv_bookavailability);
        if (s.book.equals("Your card is empty")) {
            availability.setVisibility(View.INVISIBLE);
        }else{
            availability.setVisibility(View.VISIBLE);
        }

        Button confirmOrder = root.findViewById(R.id.b_confirmOrder);
        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singleton singleton = Singleton.getInstance();

                if (singleton.book.equals("Your card is empty")) {
                    Snackbar.make(view, "Please select a book", Snackbar.LENGTH_LONG).show();
                    Fragment fragment = new GalleryFragment();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                    fragmentTransaction.commit();
                } else {

                    if (singleton.logedIn == false) {
                        Snackbar.make(view, "To place a command you have to be logged in", Snackbar.LENGTH_LONG).show();
                        Fragment fragment = new LogInFragment();
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.commit();
                    } else {
                        if ( singleton.hasMembership == true) {
                            Snackbar.make(view, "Your order has been placed", Snackbar.LENGTH_LONG).show();
                            singleton.book = "Your card is empty";

                            Fragment fragment = new HomeFragment();
                            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                            fragmentTransaction.commit();

                        } else {
                            Fragment fragment = new MembershipFragment();
                            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                            fragmentTransaction.commit();
                        }
                    }
                }
//


            }
        });

        return root;
    }
}