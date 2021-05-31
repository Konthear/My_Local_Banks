package sg.edu.rp.c346.id20003116.mylocalbanks;

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
    boolean dbsCol, ocbcCol, uobCol;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        dbsCol = true;
        ocbcCol = true;
        uobCol = true;

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, getString(R.string.website));
        menu.add(0, 1, 1, getString(R.string.contactBank));
        menu.add(0, 2, 2, getString(R.string.colour));

        if (v == tvDBS) {
            wordClicked = getString(R.string.dbs);
        } else if (v == tvOCBC) {
            wordClicked = getString(R.string.ocbc);
        } else if (v == tvUOB) {
            wordClicked = getString(R.string.uob);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase(getString(R.string.dbs))) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel + R.string.dbsCN)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (dbsCol == true) {
                    tvDBS.setTextColor(Color.parseColor("#FF0000"));
                    dbsCol = false;
                } else if (dbsCol == false) {
                    tvDBS.setTextColor(Color.parseColor("#808080"));
                    dbsCol = true;
                }
            }

        } else if (wordClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel + R.string.ocbcCN)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (ocbcCol == true) {
                    tvOCBC.setTextColor(Color.parseColor("#FF0000"));
                    ocbcCol = false;
                } else if (ocbcCol == false) {
                    tvOCBC.setTextColor(Color.parseColor("#808080"));
                    ocbcCol = true;
                }
            }

        } else if (wordClicked.equalsIgnoreCase(getString(R.string.uob))) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel + R.string.uobCN)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (uobCol == true) {
                    tvUOB.setTextColor(Color.parseColor("#FF0000"));
                    uobCol = false;
                } else if (uobCol == false) {
                    tvUOB.setTextColor(Color.parseColor("#808080"));
                    uobCol = true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.english) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.chinese) {
            tvDBS.setText(getString(R.string.dbsInChi));
            tvOCBC.setText(getString(R.string.ocbcInChi));
            tvUOB.setText(getString(R.string.uobInChi));
            return true;
        } else {
            tvDBS.setText(getString(R.string.error));
            tvOCBC.setText(getString(R.string.error));
            tvUOB.setText(getString(R.string.error));
        }
        return super.onOptionsItemSelected(item);
    }
}
