package zagotovka.ua.zagotovka.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import zagotovka.ua.zagotovka.R;
import zagotovka.ua.zagotovka.menu.MenuActivity;

public class AnimActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Убираем заголовок
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Убираем панель уведомлений
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.anim_activity);
        startAnimating();
    }
    private void startAnimating() {
        // Fade in top title
        // анимация

        final TextView textView1=(TextView) findViewById(R.id.textView);

        Animation alpha = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.alpha);
        textView1.startAnimation(alpha);

        alpha.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                perehod();// переход в следующее активити по окончании анимации
            }
            public void onAnimationRepeat(Animation animation) {      }
            public void onAnimationStart(Animation animation) {      }
        });
    }
    void perehod()  {
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
        final TextView textView1=(TextView) findViewById(R.id.textView);
        textView1.clearAnimation();
    }
    @Override
    protected void onResume() {
        super.onResume();
        startAnimating();
    }
}
