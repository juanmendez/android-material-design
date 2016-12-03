package info.juanmendez.md.befamiliar.app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import info.juanmendez.md.befamiliar.R;
import info.juanmendez.md.befamiliar.model.Constants;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main_menu)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @ViewById( R.id.explodeJava )
    Button btnExplodeJava;

    @ViewById( R.id.explodeXML )
    Button btnExplodeXML;

    @ViewById( R.id.slideJava )
    Button btnSlideJava;

    @ViewById( R.id.slideXML )
    Button btnSlideXML;

    @ViewById( R.id.fadeJava )
    Button btnFadeJava;

    @ViewById( R.id.fadeXML )
    Button btnFadeXML;

    @ViewById( R.id.shared_element )
    LinearLayout layoutSharedElement;

    @ViewById( R.id.txvRippleWithBorder )
    TextView txvRippleWithBorder;

    @ViewById( R.id.txvRippleWithoutBorder )
    TextView txvRippleWithoutBorder;

    @ViewById( R.id.txvCustomRippleWithBorder )
    TextView txvCustomRippleWithBorder;

    @ViewById( R.id.txvCustomRippleWithoutBorder )
    TextView txvCustomRippleWithoutBorder;

    @ViewById( R.id.imgStarSharedElement )
    ImageView imgStar;

    @ViewById( R.id.txvSharedElement )
    TextView txvShared;

    @AfterViews
    void afterViews(){
        setupToolbar();
        setupDrawer();
        bindControl();
    }

    private void setupToolbar(){
        setSupportActionBar( toolbar );
        toolbar.setTitle("Welcome!");
        toolbar.setSubtitle("Folks!");
    }

    private void setupDrawer(){
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
        drawerFragment.setUpDrawer(drawerLayout, toolbar);
    }

    private void bindControl() {

        btnExplodeJava.setOnClickListener(this);
        btnExplodeXML.setOnClickListener(this);
        btnSlideJava.setOnClickListener(this);
        btnSlideXML.setOnClickListener(this);
        btnFadeJava.setOnClickListener(this);
        btnFadeXML.setOnClickListener(this);
        layoutSharedElement.setOnClickListener(this);

        txvRippleWithBorder.setOnClickListener(this);
        txvRippleWithoutBorder.setOnClickListener(this);
        txvCustomRippleWithBorder.setOnClickListener(this);
        txvCustomRippleWithoutBorder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.explodeJava: {

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i = new Intent(MainActivity.this, TransitionActivity_.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeJava);
                i.putExtra(Constants.KEY_TITLE, "Explode Animation");
                i.putExtra(Constants.KEY_NAME, getString(R.string.explode_java));
                startActivity(i, options.toBundle());

                break;
            }

            case R.id.explodeXML: {

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i = new Intent(MainActivity.this, TransitionActivity_.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeXML);
                i.putExtra(Constants.KEY_TITLE, "Explode Animation");
                i.putExtra(Constants.KEY_NAME, getString(R.string.explode_xml));
                startActivity(i, options.toBundle());

                break;
            }

            case R.id.slideJava : {

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i = new Intent(MainActivity.this, TransitionActivity_.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideJava);
                i.putExtra(Constants.KEY_TITLE, "Slide Animation");
                i.putExtra(Constants.KEY_NAME, getString(R.string.slide_java));
                startActivity(i, options.toBundle());

                break;
            }

            case R.id.slideXML : {

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i = new Intent(MainActivity.this, TransitionActivity_.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideXML);
                i.putExtra(Constants.KEY_TITLE, "Slide Animation");
                i.putExtra(Constants.KEY_NAME, getString(R.string.slide_xml));
                startActivity(i, options.toBundle());

                break;
            }

            case R.id.fadeJava : {

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i = new Intent(MainActivity.this, TransitionActivity_.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeJava);
                i.putExtra(Constants.KEY_TITLE, "Fade Animation");
                i.putExtra(Constants.KEY_NAME, getString(R.string.fade_java));
                startActivity(i, options.toBundle());

                break;
            }

            case R.id.fadeXML : {

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i = new Intent(MainActivity.this, TransitionActivity_.class);
                i.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeXML);
                i.putExtra(Constants.KEY_TITLE, "Fade Animation");
                i.putExtra(Constants.KEY_NAME, getString(R.string.fade_xml));
                startActivity(i, options.toBundle());

                break;
            }

            case R.id.shared_element : {

                /*Pair[] pair = new Pair[2];

                pair[0] = new Pair<View, String>(imgStar, "star");
                pair[1] = new Pair<View, String>(txvShared, "text_shared");

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
                Intent i = new Intent(MainActivity.this, SharedElementActivity.class);
                startActivity(i, options.toBundle());*/

                break;
            }
        }
    }
}