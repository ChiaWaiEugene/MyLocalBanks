package sg.edu.rp.c346.id20041877.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String optionClicked = "";
    String url = "";
    String phoneNo = "";

    boolean toggleFavDBS=false;
    boolean toggleFavOCBC=false;
    boolean toggleFavUOB=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.bankmenu_main, menu);

        menu.setHeaderTitle("Options");

        if(v == tvDBS){
            optionClicked = "dbs";
        }
        else if(v == tvOCBC) {
            optionClicked = "ocbc";
        }
        else if(v == tvUOB) {
            optionClicked = "uob";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (optionClicked.equalsIgnoreCase("DBS")) {
            url = "https://www.dbs.com.sg";
            phoneNo = "18001111111";

            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
            else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+ phoneNo));
                startActivity(intentCall);
                return true;
            }
            else if (id == R.id.toggleFav) {
                if (!toggleFavDBS) {
                    toggleFavDBS = true;
                    tvDBS.setTextColor(Color.RED);
                }
                else {
                    toggleFavDBS = false;
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
        }
        else if (optionClicked.equalsIgnoreCase("OCBC")) {
            url = "https://www.ocbc.com";
            phoneNo = "18003633333";

            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
            else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+ phoneNo));
                startActivity(intentCall);
                return true;
            }
            else if (id == R.id.toggleFav) {
                if (!toggleFavOCBC) {
                    toggleFavOCBC = true;
                    tvOCBC.setTextColor(Color.RED);
                }
                else {
                    toggleFavOCBC = false;
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }
        }
        else if (optionClicked.equalsIgnoreCase("UOB")) {
            url = "https://www.uob.com.sg";
            phoneNo = "18002222121";

            if (id == R.id.websiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
            else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+ phoneNo));
                startActivity(intentCall);
                return true;
            }
            else if (id == R.id.toggleFav) {
                if (!toggleFavUOB) {
                    toggleFavUOB = true;
                    tvUOB.setTextColor(Color.RED);
                }
                else {
                    toggleFavUOB = false;
                    tvUOB.setTextColor(Color.BLACK);
                }
            }
        }
        else {
            url = "";
            phoneNo = "";
        }


        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getTitle().equals("English")) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        }

        else if(item.getTitle().equals("Chinese")) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);

    }

}