package info.juanmendez.md.befamiliar.app;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import info.juanmendez.md.befamiliar.R;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main_menu)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @AfterViews
    void afterViews(){

        setSupportActionBar( toolbar );
        toolbar.setTitle("Welcome!");
        toolbar.setSubtitle("Folks!");
        setupRecyclerView();
    }

    private void setupRecyclerView(){

    }

    @OptionsItem
    void discard(){
        toastForMe( "discard" );
    }

    @OptionsItem
    void search(){
        toastForMe( "search" );
    }

    @OptionsItem
    void settings(){
        toastForMe( "settings" );
    }

    @OptionsItem
    void edit(){
        toastForMe( "edit" );
    }

    @OptionsItem
    void exit(){
        toastForMe( "exit" );
    }

    private void toastForMe( String msg ){
        Toast.makeText( this, msg, Toast.LENGTH_LONG ).show();
    }
}