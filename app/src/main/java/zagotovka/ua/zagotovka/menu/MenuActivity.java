package zagotovka.ua.zagotovka.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import zagotovka.ua.zagotovka.R;
import zagotovka.ua.zagotovka.help.HelpActivity;
import zagotovka.ua.zagotovka.play.PlayActivity;
import zagotovka.ua.zagotovka.set.SetActivity;

import static android.R.attr.animation;
import static android.R.attr.button;
import static android.R.attr.inAnimation;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    Button buttonPlay, buttonSet, buttonHelp, buttonQuit;
    Context context;
    Animation animationPlay, animationSet, animationHelp, animationQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);  buttonPlay.setOnClickListener(this);
            animationPlay = AnimationUtils.loadAnimation(this, R.anim.formenuplay);
            buttonPlay.startAnimation(animationPlay);
        buttonSet = (Button) findViewById(R.id.buttonSet); buttonSet.setOnClickListener(this);
            animationSet = AnimationUtils.loadAnimation(this, R.anim.formenu2);
            buttonSet.startAnimation(animationSet);
        buttonHelp = (Button) findViewById(R.id.buttonHelp); buttonHelp.setOnClickListener(this);
            animationHelp = AnimationUtils.loadAnimation(this, R.anim.formenu3);
            buttonHelp.startAnimation(animationHelp);
        buttonQuit = (Button) findViewById(R.id.buttonQuit); buttonQuit.setOnClickListener(this);
            animationQuit = AnimationUtils.loadAnimation(this, R.anim.formenu4);
            buttonQuit.startAnimation(animationQuit);
        context = getBaseContext();
    }


    // создание меню
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // метод выбора пунктов меню
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
            Intent intent;
        switch(v.getId())  {
            case R.id.buttonPlay:
                intent=new Intent(this,PlayActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonSet:
                intent=new Intent(this,SetActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonHelp:
                intent=new Intent(this,HelpActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonQuit:    finish();       break;
        }
    }
}
