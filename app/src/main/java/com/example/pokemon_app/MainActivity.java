package com.example.pokemon_app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pokemon_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private View sview;
    private Spinner spinner;
    private ListView listView;

    private void setAllTextColors(int color) { //aqui
        setViewTextColors(findViewById(android.R.id.content), color);
    }

    private void setViewTextColors(View view, int color) { //aqui
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(color);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setViewTextColors(viewGroup.getChildAt(i), color);
            }
        }
    }

    private void setAllTextSizes(int size) {
        setViewTextSizes(findViewById(android.R.id.content), size);
    }

    private void setViewTextSizes(View view, int size) {
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(size);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setViewTextSizes(viewGroup.getChildAt(i), size);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sview = findViewById(R.id.view1);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listImagens);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tamanhos, R.layout.spinner_text);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        if (position!=0) {
            int fontSize = Integer.parseInt(selectedItem);
            setAllTextSizes(fontSize);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Método necessário para a implementação da interface AdapterView.OnItemSelectedListener
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.op_lightmode) {
            sview.setBackgroundColor(getResources().getColor(R.color.white));
            listView.setBackgroundColor(getResources().getColor(R.color.white));
            //setAllTextColors(getResources().getColor(R.color.black)); //aqui
            return true;
        }

        if (id == R.id.op_darkmode) {
            sview.setBackgroundColor(getResources().getColor(R.color.dark_grey1));
            listView.setBackgroundColor(getResources().getColor(R.color.dark_grey1));
            setAllTextColors(getResources().getColor(R.color.white)); //aqui
            return true;
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
