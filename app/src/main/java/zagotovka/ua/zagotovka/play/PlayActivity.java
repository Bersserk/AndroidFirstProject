package zagotovka.ua.zagotovka.play;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import zagotovka.ua.zagotovka.R;


public class PlayActivity extends AppCompatActivity implements View.OnClickListener  {

    TextView textView, textView2, textView3;
    ImageView pole00, pole01, pole02, pole10, pole11, pole12, pole20, pole21, pole22;
    Button buttonUp, buttonLeft, buttonRigth, buttonDown;
    ImageView[][] arr = new ImageView[3][3];
    int x = 1;
    int y = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        pole00 = (ImageView) findViewById(R.id.pole00);
        pole01 = (ImageView) findViewById(R.id.pole01);
        pole02 = (ImageView) findViewById(R.id.pole02);
        pole10 = (ImageView) findViewById(R.id.pole10);
        pole11 = (ImageView) findViewById(R.id.pole11);
        pole12 = (ImageView) findViewById(R.id.pole12);
        pole20 = (ImageView) findViewById(R.id.pole20);
        pole21 = (ImageView) findViewById(R.id.pole21);
        pole22 = (ImageView) findViewById(R.id.pole22);

        buttonUp = (Button) findViewById(R.id.buttonUp); buttonUp.setOnClickListener(this);
        buttonLeft = (Button) findViewById(R.id.buttonLeft); buttonLeft.setOnClickListener(this);
        buttonRigth = (Button) findViewById(R.id.buttonRight); buttonRigth.setOnClickListener(this);
        buttonDown = (Button) findViewById(R.id.buttonDown); buttonDown.setOnClickListener(this);

    }

    // метод принимает адрес старт ячейки и возвращает выбранное поле
    ImageView pol (int x, int y){
        if (x == 0 && y == 0) {return pole00;
        } else if (x == 0 && y == 1){return pole01;
        } else if (x == 0 && y == 2){return pole02;
        } else if (x == 1 && y == 0){return pole10;
        } else if (x == 1 && y == 1){return pole11;
        } else if (x == 1 && y == 2){return pole12;
        } else if (x == 2 && y == 0){return pole20;
        } else if (x == 2 && y == 1){return pole21;
        } else if (x == 2 && y == 2){return pole22;
    }
        return null;
    }

    // обработчик нажатия кнопок курсора
    @Override
    public void onClick (View v){

        switch (v.getId()){
            case R.id.buttonUp:
                if(y==1) {
                    pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    y = y-1;
                }else if(y==2){
                    pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    y = y-1;
                }
                break;
            case R.id.buttonLeft:
                if(x==1) {
                    pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    x = x-1;
                }else if(x==2){
                    pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    x = x-1;
                }
                break;
            case R.id.buttonRight:
                if(x==1) {
                    pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    x = x+1;
                }else if(x==0){
                    pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    x = x+1;
                }
                break;
            case R.id.buttonDown:
                if(y==1) {
                    pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    y = y+1;
                }else if(y==0){
                    pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubramka));
                    pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                    y = y+1;
                }
                break;
        }
    }
}
