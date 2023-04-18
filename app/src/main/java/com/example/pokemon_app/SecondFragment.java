package com.example.pokemon_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.pokemon_app.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        Bundle args = getArguments();
        View view = binding.getRoot();

        if (args != null) {
            String pokemonName = args.getString("name");
            int imageResId = args.getInt("image");
            String pokemonType = args.getString("type");

            binding.pokemonName.setText(pokemonName);
            binding.pokemonImage.setImageResource(imageResId);
            binding.tipoPokemon.setText(pokemonType);
            TextView textView = view.findViewById(R.id.tipoPokemon);


            if (pokemonType.equals("Grama")) {
                textView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.label_background_grama));
            } else if (pokemonType.equals("Inseto")) {
                textView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.label_background_inseto));
            } else if (pokemonType.equals("Fogo")) {
                textView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.label_background_fogo));
            } else if (pokemonType.equals("Normal")) {
                textView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.label_background_normal));
            } else if (pokemonType.equals("Elétrico")) {
                textView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.label_background_eletrico));
            } else if (pokemonType.equals("Água")) {
                textView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.label_background_agua));
            }
        }

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
