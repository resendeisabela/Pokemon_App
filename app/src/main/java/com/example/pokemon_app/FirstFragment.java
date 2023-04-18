package com.example.pokemon_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemon_app.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;

    private List<ItemListView> itens=new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itens.add(0, new ItemListView("Bulbassauro", R.drawable.bulbasaur, "Grama"));
        itens.add(1, new ItemListView("Butterfree", R.drawable.butterfree, "Inseto"));
        itens.add(2, new ItemListView("Charmander", R.drawable.charmander, "Fogo"));
        itens.add(3, new ItemListView("Cyndaquil", R.drawable.cyndaquil, "Fogo"));
        itens.add(4, new ItemListView("Eevee", R.drawable.eevee, "Normal"));
        itens.add(5, new ItemListView("Pikachu", R.drawable.pikachu, "Elétrico"));
        itens.add(6, new ItemListView("Snorlax", R.drawable.snorlax, "Normal"));
        itens.add(7, new ItemListView("Squirtle", R.drawable.squirtle, "Água"));

        binding.listImagens.setAdapter(new AdapterListView(getContext(),itens));
        binding.listImagens.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                ItemListView selectedItem = itens.get(position);

                Bundle bundle = new Bundle();
                bundle.putInt("image", selectedItem.getImage());
                bundle.putString("name", selectedItem.getName());
                bundle.putString("type", selectedItem.getType());

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });
        binding.buttonGotoThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment);
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}