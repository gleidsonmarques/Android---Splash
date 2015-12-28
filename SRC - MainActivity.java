import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

  private Dialog dialog;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findViewById(R.id.btEsperar).setOnClickListener(new View.OnClickListener(){
          public void onClick(View v){
          esperar();
          }
        });
    }
    
    private void esperar(){
      Runnable motor = new Runnable(){
        public void run(){
          try { Thread.sleep(1000*30); } catch (Exception e){ }
          dialog.dismiss();
        }
      };
      dialogo = ProgressDialog.show(
        this, "Espere", "Vou ficar parado por 30 segs...", false);
      Thread t = new Thread(motor);
      t.start();
    }
}
