package curso.clases.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataChangeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataChangeFragment extends Fragment {

    EditText editTextChange;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_change, container, false);
        editTextChange = view.findViewById(R.id.editTextChange);
        return view;
    }
    public void ChangeText(CharSequence charSequence){
        editTextChange.setText(charSequence);
    }
}