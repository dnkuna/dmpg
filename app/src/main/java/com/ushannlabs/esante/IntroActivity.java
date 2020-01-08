package com.ushannlabs.esante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;


public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position=0;
    Button btnGetStarted;
    Animation btnAnim;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make the activity in the full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (restorPrefData()){
            Intent mainActivity = new Intent(getApplicationContext(),Login.class);
            startActivity(mainActivity);
            finish();
        }

        setContentView(R.layout.activity_intro);

        //hide the actionbar

        //getSupportActionBar().hide();

        // init view
        tabIndicator = findViewById(R.id.tab_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_started);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btn_animation);

        //fill the list

        final List<ScreenItem>mList=new ArrayList<>();
        mList.add(new ScreenItem("Votre canet de santé numérique","Le Dossier Médical Partagé Gabonais (DMPG) est un carnet de santé numérique qui conserve et sécurise vos informations de santé: traitements,résultats d'examens, allergies...",R.drawable.onboardt));
        mList.add(new ScreenItem("Documents conservés et toujours accessibles où que vous soyez","Ajouter vos documents médicaux,les personnes à prévenir en cas d'urgence, et toute autre information que vous souhaitez partager avec les professionnels de santé qui vous suivent.",R.drawable.onboardp));
        mList.add(new ScreenItem("Vous gardez le controle de votre dossier","Gérer l'acces à votre DMP : vous pouvez visualiser les accès des professionnels de santé et mettre fin à tout moment à une autorisation de données",R.drawable.onboardd));
        //setup pager
        screenPager=findViewById(R.id.screen_viewpager);
        introViewPagerAdapter= new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //setup layout with viewpager
        tabIndicator.setupWithViewPager(screenPager);


        //Next button click Listener

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();

                if (position<mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if(position==mList.size()-1){ //when the rech to the last screen
                    // TODO : show the get started button and hide the indicator and the next button
                    loaddLastScreen();
                }
            }
        });

        //tab layout add change listner
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==mList.size()-1){

                    loaddLastScreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Login.class);
                startActivity(mainActivity);
                savePrefsData();
                finish();

            }
        });
    }//fin oncreate

    private boolean restorPrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore=pref.getBoolean("isIntroOpnend",false);
        return isIntroActivityOpnendBefore;

    }

    private void savePrefsData() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();
    }


    //show the get started button and hide the indicator and the next button
    private void loaddLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        // TODO : add an animation the getStarted button
        //setup animation
        btnGetStarted.setAnimation(btnAnim);
    }
}
