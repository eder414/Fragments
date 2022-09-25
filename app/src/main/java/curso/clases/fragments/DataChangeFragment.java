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

import curso.clases.fragments.Interface.IChangeText;
import curso.clases.fragments.models.Fragments;


public class DataChangeFragment<T extends IChangeText> extends Fragment {
    private DataChangeFragment.FragmentAListener listener;
    Button btnChangeText;
    EditText editTextChange;
    T  fragment;

    public DataChangeFragment(){

    }

    public T getFragment() {
        return fragment;
    }

    public void setFragment(T fragment) {
        this.fragment = fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_change, container, false);
        editTextChange = view.findViewById(R.id.editTextChange);
        // Inflate the layout for this fragment
        btnChangeText = view.findViewById(R.id.btnChangeText);
        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editTextChange.getText();
                listener.onInputASent(input,fragment);
            }
        });

        return view;
    }
    public void ChangeText(CharSequence charSequence){
        editTextChange.setText(charSequence);
    }
    public interface FragmentAListener{
        <T> void  onInputASent(CharSequence input,T fragmento);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof DataChangeFragment.FragmentAListener){
            listener = (DataChangeFragment.FragmentAListener) context;
        }else{
            throw  new RuntimeException(context.toString() + "must implement FragmentAListener");
        }
    }
    public void updateEditText(CharSequence newText){
        editTextChange.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}