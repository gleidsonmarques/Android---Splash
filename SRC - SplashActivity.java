import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class SplashActivity extends Activity {
    private boolean ativa = true; // Controla se foi pressionado o Touch
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        // Thread para mostrar a Splash
        new Thread() {
            @Override
            public void run() {
                int espera = 0;
                try {
                    // Ou acontece o TouchScreen ou tempo de 5 segs
                    while(ativa && (espera < 5000)) {
                        sleep(100);
                        if(ativa) {
                        	espera += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    startActivity(new Intent("Principal"));
                    stop();
                }
            }
        }.start();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    //Programa Restaurante Opcional aqui
      //  if (event.getAction() == MotionEvent.ACTION_DOWN) {
            ativa = false;
      //  }
        return true;
    }
}
