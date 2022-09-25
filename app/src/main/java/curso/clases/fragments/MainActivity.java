package curso.clases.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import curso.clases.fragments.Interface.FragmentAListener;
import curso.clases.fragments.Interface.IChangeText;
import curso.clases.fragments.models.Fragments;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,  FragmentAListener,
                            DataChangeFragment.FragmentAListener{
    Button btnNews,btnSport,btnScience;
    FragmentManager fragmentManager;
    /*NewsFragment newsFragment;
    DataChangeFragment dataChangeFragment;*/
    Fragments fragments;
    FragmentTransaction transaction;
    /*Fragment changeFragment, sport, news, science;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNews = findViewById(R.id.btnNews);
        btnSport = findViewById(R.id.btnSports);
        btnScience = findViewById(R.id.btnScience);

        btnNews.setOnClickListener(this);
        btnSport.setOnClickListener(this);
        btnScience.setOnClickListener(this);


        fragments = new Fragments(new NewsFragment() , new SportsFragment(),new  ScienceFragment() , new DataChangeFragment());
        fragments.getDataChangeFragment().setFragment(fragments.getNewsFragment());
        /*changeFragment = new DataChangeFragment();

        sport = new SportsFragment();
        news = new NewsFragment();
        science = new ScienceFragment();*/



        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,fragments.getNewsFragment(),null)
                .replace(R.id.fragmentModify,fragments.getDataChangeFragment(),null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }

    @Override
    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
        case R.id.btnNews:
            //NewsFragment newsFragment = new NewsFragment();
            ChangeFragment(fragments.getNewsFragment());
            break;
        case R.id.btnSports:
            //SportsFragment sportsFragment = new SportsFragment();
            ChangeFragment(fragments.getSportsFragment());
            break;
        case R.id.btnScience:
            //ScienceFragment scienceFragment = new ScienceFragment();
            ChangeFragment(fragments.getScienceFragment());
            break;
        }
    }
    public <T extends IChangeText> void ChangeFragment(T fragment1){
        //fragments.setDataChangeFragment(new DataChangeFragment(fragment1));
        fragments.getDataChangeFragment().setFragment(fragment1);
        fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, (Fragment) fragment1,null)
                        .replace(R.id.fragmentModify,fragments.getDataChangeFragment(),null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

    }

    @Override
    public <T> void onInputASent(CharSequence input,T fragmento) {
        Toast.makeText(MainActivity.this,
                        fragments.getDataChangeFragment().fragment.getClass().toString(),
                        Toast.LENGTH_SHORT).show();
        CambiarByInterface(fragments.getDataChangeFragment().fragment,input.toString());
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragments.getDataChangeFragment().ChangeText(input);
    }

    public <T extends IChangeText> void CambiarByInterface(T instancia,String texto){
        instancia.ChangeText(texto);
    }
}