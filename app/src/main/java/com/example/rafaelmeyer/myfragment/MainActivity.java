package com.example.rafaelmeyer.myfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    private Fragment myFragmentA;
    private Fragment myFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.buttonFragmentA);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myFragmentA == null) {
                            if (myFragmentB != null) {
                                getSupportFragmentManager().beginTransaction()
                                        .remove(myFragmentB)
                                        .commit();

                                myFragmentB = null;
                            }
                            myFragmentA = new MainFragment();
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.contentContainerA, myFragmentA)
                                    .commit();
                        }
                    }
                }
        );

        Button button2 = (Button) findViewById(R.id.buttonFragmentB);
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myFragmentB == null) {
                            if (myFragmentA != null) {
                                getSupportFragmentManager().beginTransaction()
                                        .remove(myFragmentA)
                                        .commit();
                                myFragmentA = null;
                            }
                            myFragmentB = new SecondFragment();
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.contentContainerB, myFragmentB)
                                    .commit();
                        }

                    }
                }
        );

        Button buttonHideA = (Button) findViewById(R.id.buttonHideFragmentA);
        buttonHideA.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myFragmentA != null) {
                            getSupportFragmentManager().beginTransaction()
                                    .remove(myFragmentA)
                                    .commit();
                            myFragmentA = null;
                        }
                    }
                }
        );

        Button buttonHideB = (Button) findViewById(R.id.buttonHideFragmentB);
        buttonHideB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myFragmentB != null) {
                            getSupportFragmentManager().beginTransaction()
                                    .remove(myFragmentB)
                                    .commit();

                            myFragmentB = null;
                        }
                    }
                }
        );
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
