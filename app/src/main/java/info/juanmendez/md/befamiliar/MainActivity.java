package info.juanmendez.md.befamiliar;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @AfterViews
    void afterViews(){

        setSupportActionBar( toolbar );
        getSupportActionBar().setIcon( R.drawable.good_day);
        getSupportActionBar().setTitle("Welcome!");
        getSupportActionBar().setSubtitle("Folks!");
        toolbar.setNavigationIcon( R.drawable.navigation_back);

        /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
        }else{
        }*/
    }
}