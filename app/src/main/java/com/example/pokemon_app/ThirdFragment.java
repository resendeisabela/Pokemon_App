package com.example.pokemon_app;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.pokemon_app.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater,
                container, false);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),
                R.array.pokemons, android.R.layout.simple_spinner_item);
        binding.spinnerPokemons.setAdapter(adapter);
        binding.spinnerPokemons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(mediaPlayer!=null){
                    mediaPlayer.release();
                }
                switch (position){
                    case 1:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.bulbasaur);
                        break;
                    case 2:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.butterfree);
                        break;
                    case 3:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.charmander);
                        break;
                    case 4:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.cyndaquil);
                        break;
                    case 5:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.eevee);
                        break;
                    case 6:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.pikachu);
                        break;
                    case 7:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.snorlax);
                        break;
                    case 8:
                        mediaPlayer=MediaPlayer.create(getContext(),R.raw.squirtle);
                        break;
                }
                if(mediaPlayer!=null){
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.release();
                        }
                    });
                }
            }
        });

        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}