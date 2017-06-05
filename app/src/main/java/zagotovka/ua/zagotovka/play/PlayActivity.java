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
    int x = 1;      // x координата бегунка
    int y = 1;      // у координата бегунка
    int rrx = 0;        // х координата красной рамки
    int rry = 1;        // у координата красной рамки
    int brx = 2;        // х координата синей рамки
    int bry = 0;        // у координата синей рамки


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
                if (rry+1==y && rrx==x){break;}
                if (bry+1==y && brx==x){break;}
                else
                if (brx == x && bry == y){
                    upKubBlueramka();
                }else
                if (y == rry && x == rrx){
                    upKub();  // выход бегунка из красной рамки
                }else
                    up();  // передвижение бегунка вверх
                break;
            case R.id.buttonLeft:
                if (rrx+1==x && rry==y){break;}
                if (brx+1==x && bry==y){break;}
                if (rrx == x && rry == y){
                    leftKubRedramka(); // передвижение бегунка с красной рамкой влево
                }else
                if (x == brx && y == bry){
                    leftKub();
                }else
                    left();  // передвижение бегунка влево
                break;
            case R.id.buttonRight:
                if (rrx == x && rry == y && rrx+1==brx && rry == bry){
                    rigthRedKubInBlueKub();

                }else
                if (rrx==x && rry==y) {
                    rightKubRedramka();  // передвижение бегунка с красной рамкой вправо
                }else
                if (x+1 == brx && bry == y){
                    rigthKubInBlueramka();  // передвижение бегунка в синюю рамку
                }else
                    right();  // передвижение бегунка вправо
                break;
            case R.id.buttonDown:
                if (bry-1==y && brx==x){break;}
                    downKubRedramka();  // передвижения бегунка с красной рамкой
                if (y+1 == rry && rrx == x){
                    downKubInRedramka();  // передвижения бегунка в красную рамку
                }else
                if (brx == x && bry == y){
                    downKubBlueramka();
                }else
                    down();  // передвижения бегунка вниз
                break;
        }

    }


    private void upKub(){
        if(y==1) {
            pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.redramka));
            y = y-1;

        }else if(y==2){
            pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.redramka));
            y = y-1;
        }
    }
    private void upKubBlueramka(){
        if (brx==x && bry==y){
            if(y==1) {
                pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubblueramka));
                pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                y = y-1;
            }else if(y==2){
                pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubblueramka));
                pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                y = y-1;
            }
            bry = y;
            brx = x;
        }
    }
    private void up (){
        if(y==1) {
            pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            y = y-1;
        }else if(y==2){
            pol(x,y-1).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            y = y-1;
        }
    }

    private void leftKub(){
        if(x==1) {
            pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.blueramka));
            x = x-1;
        }else if(x==2){
            pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.blueramka));
            x = x-1;
        }
    }
    private void leftKubRedramka(){
        if(x==1) {
            pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubredramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x-1;
        }else if(x==2){
            pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubredramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x-1;
        }
        rrx = x;
        rry = y;
    }
    private void left (){
        if(x==1) {
            pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x-1;
        }else if(x==2){
            pol(x-1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x-1;
        }
    }

    private void rigthRedKubInBlueKub(){
        if(x==1) {
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.rezult));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
        }else if(x==0){
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.rezult));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            finish();
        }
    }
    private void rightKubRedramka (){
        if(x==1) {
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubredramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x+1;
        }else if(x==0){
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubredramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x+1;
        }
        rrx=x;
        rry=y;

    }
    private void rigthKubInBlueramka(){
        if(x==1) {
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubblueramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x+1;
        }else if(x==0){
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubblueramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x+1;
        }
        brx = x;
    }
    private void right (){
        if(x==1) {
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x+1;
        }else if(x==0){
            pol(x+1,y).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            x = x+1;
        }
    }

    private void downKubRedramka (){
        if (rrx==x && rry==y){
            if(y==1) {
                pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubredramka));
                pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                y = y+1;
            }else if(y==0){
                pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubredramka));
                pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                y = y+1;
            }
            rry = y;
            rrx = x;
        }
    }
    private void downKubBlueramka (){
        if (brx==x && bry==y){
            if(y==1) {
                pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubblueramka));
                pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                y = y+1;
            }else if(y==0){
                pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubblueramka));
                pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
                y = y+1;
            }
            bry = y;
            brx = x;
        }
    }
    private void downKubInRedramka (){
        if(y==1) {
            pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubredramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            y = y+1;
        }else if(y==0){
            pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubredramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            y = y+1;
        }
        rry = y;
    }
    private void down (){
        if(y==1) {
            pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            y = y+1;
        }else if(y==0){
            pol(x,y+1).setBackground(getResources().getDrawable(R.drawable.kubramka));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));
            y = y+1;
        }
    }

    private void pobeda(int rbx, int rby, int rrx, int rry){

            if (rbx == rrx && rby == rry)
            pol(rbx,rby).setBackground(getResources().getDrawable(R.drawable.rezult));
            pol(x,y).setBackground(getResources().getDrawable(R.drawable.ramka));



    }
}
