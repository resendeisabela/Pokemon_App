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

//        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });

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
//                switch (position){
//                    case 0:
//                        itens.remove(0);
//                        break;
//                    case 1:
//                        itens.remove(1);
//                        break;
//                    case 2:
//                        itens.remove(2);
//                        break;
//                }
//                binding.listImagens.setAdapter(new AdapterListView(getContext(),itens));
                Bundle bundle = new Bundle();
                ItemListView item = itens.get(position);
                bundle.putString("name", item.getName());
                bundle.putInt("image", item.getImage());

                // Crie uma instância do Fragment PokemonFragment e defina o Bundle como argumento
//                SecondFragment secondFragment = new SecondFragment();
//                secondFragment.setArguments(bundle);

                // Use o NavController para navegar para o Fragment PokemonFragment
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}