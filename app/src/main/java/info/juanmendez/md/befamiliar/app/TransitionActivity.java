package info.juanmendez.md.befamiliar.app;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

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

}
