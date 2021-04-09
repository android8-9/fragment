package com.cheekupeeku.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.cheekupeeku.testfragment.databinding.HomeBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    HomeBinding binding;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("CHAT"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("STATUS"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("CALLS"));
        manager = getSupportFragmentManager();
        FragmentTransaction transaction;
        transaction = manager.beginTransaction();
        transaction.replace(R.id.ll,new ChatFragment());
        transaction.commit();
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               String selectedTab = tab.getText().toString();
               FragmentTransaction transaction = manager.beginTransaction();
               if(selectedTab.equals("CHAT")){
                   transaction.replace(R.id.ll,new ChatFragment());
               }
               else if(selectedTab.equals("STATUS")){
                   transaction.replace(R.id.ll,new StatusFragment());
               }
               else if(selectedTab.equals("CALLS")){
                   transaction.replace(R.id.ll,new CallsFragment());
               }
               transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}