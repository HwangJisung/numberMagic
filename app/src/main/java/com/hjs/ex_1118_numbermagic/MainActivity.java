package com.hjs.ex_1118_numbermagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView show_num;
    Button btn_yes, btn_no, btn_restart;

    int result = 0; // 결과 출력용 변수
    int phase = 1; // 단계를 저장하는 변수

    // final 키워드는 [상수]
    // : 한번 값을 넣으면 프로그램 종료까지 절대로 값을 바꿀 수 없는 수
    final int YES = 1;
    final int NO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_num = findViewById(R.id.show_num);
        btn_yes = findViewById(R.id.btn_yes);
        btn_no = findViewById(R.id.btn_no);
        btn_restart = findViewById(R.id.btn_restart);

        btn_yes.setOnClickListener( click );
        btn_no.setOnClickListener( click );
        btn_restart.setOnClickListener( click );

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_yes :
                    showPhase(YES);
                    break;

                case R.id.btn_no :
                    showPhase(NO);
                    break;

                case R.id.btn_restart :
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                    break;
            }
        }
    };

    // 단계 구별용 메서드 showPhase()
    public void showPhase(int n){

        String str = "";

        switch ( phase ){
            case 1 :
                if(n == YES) result += 4;
                str = "16 17 18 19 20\n21 22 23 24 25\n26 27 28 29 30";
                break;
            case 2 :
                if(n == YES) result += 16;
                str = "01 03 05 07 09\n11 13 15 17 19\n21 23 25 27 29";
                break;
            case 3 :
                if(n == YES) result += 1;
                str = "08 09 10 11 12\n13 14 15 24 25\n26 27 28 29 30";
                break;
            case 4 :
                if(n == YES) result += 8;
                str = "02 03 06 07 10\n11 14 15 18 19\n22 23 26 27 30";
                break;
            case 5 :
                if(n == YES) result += 2;

                str = "당신이 생각한 숫자는\n" + result + "\n입니다!!";

                // 다시하기 버튼을 활성화
                btn_restart.setVisibility(View.VISIBLE);
                btn_yes.setVisibility(View.INVISIBLE);
                btn_no.setVisibility(View.INVISIBLE);

                break;
        }

        show_num.setText(str);
        phase++;
    }
}
