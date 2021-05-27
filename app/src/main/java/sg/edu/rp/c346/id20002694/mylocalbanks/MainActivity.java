package sg.edu.rp.c346.id20002694.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView bankDBS;
    TextView bankOCBC;
    TextView bankUOB;
    String clicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bankDBS = findViewById(R.id. bankDBS);
        bankOCBC = findViewById(R.id. bankOCBC);
        bankUOB = findViewById(R.id. bankUOB);

        registerForContextMenu(bankDBS);
        registerForContextMenu(bankOCBC);
        registerForContextMenu(bankUOB);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v==bankDBS){
            clicked= "dbs";
        }
        else if(v==bankOCBC){
            clicked= "ocbc";
        }
        else if(v==bankUOB){
            clicked= "uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(clicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0) { //website
                Toast.makeText(MainActivity.this, "Redirecting to website...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //contact

                Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel:"+1800+1111111));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
        }
        else if(clicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0) { //website
                Toast.makeText(MainActivity.this, "Redirecting to website...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //contact

                Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel:"+ 1800+3633333));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
        }
        else if(clicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0) { //website
                Toast.makeText(MainActivity.this, "Redirecting to website...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //contact

                Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel:"+1800+2222121));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.english) {
            bankDBS.setText("DBS");
            bankUOB.setText("UOB");
            bankOCBC.setText("OCBC");
            return true;
        } else if (id == R.id.chinese) {
            bankDBS.setText("星展银行");
            bankUOB.setText("大华银行");
            bankOCBC.setText("华侨银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}