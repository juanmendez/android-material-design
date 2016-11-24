package info.juanmendez.md.befamiliar.app;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import info.juanmendez.md.befamiliar.R;
import info.juanmendez.md.befamiliar.adapter.RecyclerAdapter;
import info.juanmendez.md.befamiliar.service.LandscapeService;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main_menu)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    RecyclerView recyclerView;

    @AfterViews
    void afterViews(){

        setSupportActionBar( toolbar );
        toolbar.setTitle("Welcome!");
        toolbar.setSubtitle("Folks!");
        setupRecyclerView();
    }

    private void setupRecyclerView(){
        RecyclerAdapter adapter = new RecyclerAdapter(this, LandscapeService.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this); // (Context context, int spanCount)
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator()); // Even if we dont use it then also our items shows default animation.
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