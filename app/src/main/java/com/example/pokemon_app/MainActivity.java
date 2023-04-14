package com.example.pokemon_app;

import android.os.Bundle;

import com.example.pokemon_app.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private View sview;
    private Spinner spinner;
    private TextView txt;
    private Button btn_mudar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sview = findViewById(R.id.view1);
        spinner = findViewById(R.id.spinner);
        txt= sview.findViewById(R.id.textView2);
        btn_mudar = findViewById(R.id.button_change);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tamanhos, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn_mudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                int item = spinner.getSelectedItemPosition();
                switch (item) {
                    case 24:
                        txt.setTextSize(24);
                        break;
                        case 26:
                            txt.setTextSize(26);
                            break;
                            case 28:
                                txt.setTextSize(28);
                                break;
                                case 30:
                                    txt.setTextSize(30);
                                    break;
                                                 }
                                             }
                                         }
        ) ;}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.op_lightmode) {
            sview.setBackgroundColor(getResources().getColor(R.color.white));
        }
        if (id == R.id.op_darkmode) {
            sview.setBackgroundColor(getResources().getColor(R.color.dark_grey1));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}