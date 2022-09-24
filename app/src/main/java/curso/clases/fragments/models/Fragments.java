package curso.clases.fragments.models;

import curso.clases.fragments.DataChangeFragment;
import curso.clases.fragments.NewsFragment;
import curso.clases.fragments.ScienceFragment;
import curso.clases.fragments.SportsFragment;

public class Fragments {

    NewsFragment newsFragment;
    SportsFragment sportsFragment;
    ScienceFragment scienceFragment;
    DataChangeFragment dataChangeFragment;

    public Fragments(NewsFragment newsFragment, SportsFragment sportsFragment, ScienceFragment scienceFragment, DataChangeFragment dataChangeFragment) {
        this.newsFragment = newsFragment;
        this.sportsFragment = sportsFragment;
        this.scienceFragment = scienceFragment;
        this.dataChangeFragment = dataChangeFragment;
    }

    public NewsFragment getNewsFragment() {
        return newsFragment;
    }

    public void setNewsFragment(NewsFragment newsFragment) {
        this.newsFragment = newsFragment;
    }

    public SportsFragment getSportsFragment() {
        return sportsFragment;
    }

    public void setSportsFragment(SportsFragment sportsFragment) {
        this.sportsFragment = sportsFragment;
    }

    public ScienceFragment getScienceFragment() {
        return scienceFragment;
    }

    public void setScienceFragment(ScienceFragment scienceFragment) {
        this.scienceFragment = scienceFragment;
    }

    public DataChangeFragment getDataChangeFragment() {
        return dataChangeFragment;
    }

    public void setDataChangeFragment(DataChangeFragment dataChangeFragment) {
        this.dataChangeFragment = dataChangeFragment;
    }


}
