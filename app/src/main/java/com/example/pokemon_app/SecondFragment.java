package com.example.pokemon_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemon_app.databinding.FragmentSecondBinding;

import java.util.List;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        Bundle args = getArguments();

        if (args != null) {
            String pokemonName = args.getString("name");
            int imageResId = args.getInt("image");
            String pokemonType = args.getString("type");

            binding.pokemonName.setText(pokemonName);
            binding.pokemonImage.setImageResource(imageResId);
            binding.tipoPokemon.setText(pokemonType);
        }

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
