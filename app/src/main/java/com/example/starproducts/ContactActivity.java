package com.example.starproducts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContactActivity extends AppCompatActivity {
    TextView linkText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PhoneFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.frag_phone:
                    selectedFragment = new PhoneFragment();
                    break;
                case R.id.frag_email:
                    selectedFragment = new EmailFragment();
                    break;
                case R.id.frag_feedback:
                    selectedFragment = new FeedbackFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    public void feed(View view) {
        linkText = (TextView) findViewById(R.id.emailLink);
        linkText.setText(Html.fromHtml("<a href=\"mailto:imi7111990@gmail.com\">" +
                "Click here for Feedback</a>"));
        linkText.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
