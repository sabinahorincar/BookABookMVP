package com.example.bookabook.ui.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookabook.R;
import com.google.android.material.snackbar.Snackbar;

import static com.example.bookabook.ui.Singleton.getInstance;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    ListView simpleList;
    String booksList[] = {"Trust Exercise, by Susan Choi","Book about Romania", "Axiomatic, by Maria Tumarkin", "Alice in Wonderland", "Valerie, by Sara Stridsberg","Greenbook", "Dictionary", "Girl, Woman, Other","Book about France", "The book of names", "Sleeping Beauty", "Drums of Tombalku", "The Hand of Nergal"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        simpleList = (ListView) root.findViewById(R.id.simpleListView);
        CustomerAdapter customAdapter = new CustomerAdapter(root.getContext(), booksList);
        simpleList.setAdapter(customAdapter);

        final EditText searchAgainBook = root.findViewById(R.id.et_searchAgainBook);
        Button selectButton = root.findViewById(R.id.b_searchAgainBook);

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchAgainBook.getText().toString().isEmpty()){
                    Snackbar.make(view, "Please insert a book", Snackbar.LENGTH_LONG).show();
                } else {
                    Fragment fragment = new GalleryFragment();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                    fragmentTransaction.commit();
                }
            }

        });



        return root;
    }

}