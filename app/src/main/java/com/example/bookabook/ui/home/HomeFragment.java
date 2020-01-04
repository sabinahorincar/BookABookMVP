package com.example.bookabook.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookabook.R;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        final EditText book = root.findViewById(R.id.et_SearchBook);
        Button searchButton = root.findViewById(R.id.b_searchBook);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (book.getText().toString().isEmpty()) {
                    Log.d("a", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    Snackbar.make(view, "Please insert a book", Snackbar.LENGTH_LONG);
                } else {
                    Log.d("b","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                    Snackbar.make(view, "hahahahahahhahahaha", Snackbar.LENGTH_LONG);
//                    getMenuInflater().inflate(R.menu.main, menu);
                }

            }
        });
        return root;
    }
}