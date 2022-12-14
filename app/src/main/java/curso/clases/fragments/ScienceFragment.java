package curso.clases.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import curso.clases.fragments.Interface.FragmentAListener;
import curso.clases.fragments.Interface.IChangeText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScienceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScienceFragment extends Fragment implements IChangeText {
    private EditText editTextScience;
    private FragmentAListener listener;
    Button btnChange;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScienceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScienceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScienceFragment newInstance(String param1, String param2) {
        ScienceFragment fragment = new ScienceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_science, container, false);
        editTextScience = view.findViewById(R.id.editTextScience);
        // Inflate the layout for this fragment
        btnChange = view.findViewById(R.id.changeNews);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editTextScience.getText();
                listener.onInputASent(input);
            }
        });

        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            listener = (FragmentAListener) context;
        }else{
            throw  new RuntimeException(context.toString() + "must implement FragmentAListener");
        }
    }
    public void updateEditText(CharSequence newText){
        editTextScience.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void ChangeText(String texto) {
        editTextScience.setText(texto);
    }
}