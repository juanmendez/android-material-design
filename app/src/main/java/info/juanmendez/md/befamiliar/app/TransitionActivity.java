package info.juanmendez.md.befamiliar.app;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import info.juanmendez.md.befamiliar.R;
import info.juanmendez.md.befamiliar.model.Constants;


/**
 * Created by Juan Mendez on 12/3/2016.
 * www.juanmendez.info
 * contact@juanmendez.info
 */

@EActivity(R.layout.activity_transition)
public class TransitionActivity extends AppCompatActivity {
    Constants.AnimType type;
    String toolbarTitle, animName;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.animName)
    TextView mTxvAnimName;

    @ViewById(R.id.exit_button)
    Button exitButton;

    @AfterInject
    void afterInject(){
        getWindow().requestFeature( Window.FEATURE_CONTENT_TRANSITIONS );
        getWindow().setAllowEnterTransitionOverlap( false );

        type = (Constants.AnimType) getIntent().getSerializableExtra(Constants.KEY_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);
        animName = getIntent().getExtras().getString(Constants.KEY_NAME);
    }

    @AfterViews
    void afterViews(){

        mTxvAnimName.setText( animName );
        setUpAnimation();
        setupToolbar();
    }

    @Click(R.id.exit_button)
    void onExitButton(){
        finishAfterTransition();
    }

    private void setUpAnimation() {
        switch (type) {

            case ExplodeJava: { // For Explode By Code

                Explode enterTransition = new Explode();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                enterTransition.setInterpolator(new BounceInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case ExplodeXML: { // For Explode By XML

                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case SlideJava: { // For Slide By Code

                Slide enterTransition = new Slide();
                enterTransition.setSlideEdge(Gravity.RIGHT);
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case SlideXML: { // For Slide by XML

                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case FadeJava: { // For Fade By Code

                Fade enterTransition = new Fade();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case FadeXML: { // For Fade by XML

                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                getWindow().setEnterTransition(enterTransition);
                break;
            }
        }
    }

    private void setupToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);
    }

    /**
     * this helps the back button to apply the reverse animation;
     * otherwise, the current activity just leaves with no transition.
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }
}
