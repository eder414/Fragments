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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    private EditText editTextNews;
    private FragmentAListener listener;
    Button btnChange;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        editTextNews = view.findViewById(R.id.editTextNews);
        // Inflate the layout for this fragment
        btnChange = view.findViewById(R.id.changeNews);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CharSequence input = editTextNews.getText();
               listener.onInputASent(input);
            }
        });

        return view;
    }
    public interface FragmentAListener{
        void onInputASent(CharSequence input);
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
        editTextNews.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}