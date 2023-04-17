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

        itens.add(0, new ItemListView("Bulbassauro", R.drawable.bulbasaur));
        itens.add(1, new ItemListView("Butterfree", R.drawable.butterfree));
        itens.add(2, new ItemListView("Charmander", R.drawable.charmander));
        itens.add(3, new ItemListView("Cyndaquil", R.drawable.cyndaquil));
        itens.add(4, new ItemListView("Eevee", R.drawable.eevee));
        itens.add(5, new ItemListView("Pikachu", R.drawable.pikachu));
        itens.add(6, new ItemListView("Snorlax", R.drawable.snorlax));
        itens.add(7, new ItemListView("Squirtle", R.drawable.squirtle));

        binding.listImagens.setAdapter(new AdapterListView(getContext(),itens));
        binding.listImagens.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                // Get the selected item from the list
                ItemListView selectedItem = itens.get(position);

                // Create a bundle to pass the data to the second fragment
                Bundle bundle = new Bundle();
                bundle.putInt("image", selectedItem.getImage());
                bundle.putString("name", selectedItem.getName());

                // Navigate to the second fragment
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}