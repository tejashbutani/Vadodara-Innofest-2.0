package vadodarainnofest.paruluniversity.ac.in.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import vadodarainnofest.paruluniversity.ac.in.R;

public class MainActivity extends AppCompatActivity {

    int screenHeight;
    int screenWidth;
    int screenDensity;

    RelativeLayout mainLayout;
    CardView wmsCardView, vssCardView, vhCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //--------------------------------------------

        mainLayout = findViewById(R.id.mainLayout);
        wmsCardView = findViewById(R.id.wmsCardView);
        vssCardView = findViewById(R.id.vssCardView);
        vhCardView = findViewById(R.id.vhCardView);

        //-------------------------------------------

        getScreenSize();
        setDisplaySizeElements();
    }

    public void getScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenDensity  = (int) getResources().getDisplayMetrics().density;

        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;

        Log.d("width",String.valueOf(screenWidth));
        Log.d("height",String.valueOf(screenHeight));
    }

    public void setDisplaySizeElements(){
        int cardWidth = screenWidth - (60*screenDensity);
        int cardHeight = (screenWidth-(60*screenDensity))/2;

        FrameLayout.LayoutParams mainLayoutParams = new FrameLayout.LayoutParams(screenWidth,screenHeight);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(cardWidth,cardHeight);
        mainLayout.setLayoutParams(mainLayoutParams);
        wmsCardView.setLayoutParams(cardParams);
        vssCardView.setLayoutParams(cardParams);
        vhCardView.setLayoutParams(cardParams);
    }
}