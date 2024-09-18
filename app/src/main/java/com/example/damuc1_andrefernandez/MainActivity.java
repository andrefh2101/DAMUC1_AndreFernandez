package com.example.damuc1_andrefernandez;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up clickable link for "Más información"
        TextView textView2 = findViewById(R.id.textView2);
        SpannableString spannableString2 = new SpannableString(textView2.getText());

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/help"));
                startActivity(intent);
            }
        };

        int start2 = textView2.getText().toString().indexOf("Más información");
        if (start2 != -1) {
            int end2 = start2 + "Más información".length();
            spannableString2.setSpan(clickableSpan2, start2, end2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView2.setText(spannableString2);
            textView2.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        }

        // Set up clickable links for "Condiciones", "Política de privacidad" and "Política de cookies"
        TextView textView3 = findViewById(R.id.textView3);
        SpannableString spannableString3 = new SpannableString(textView3.getText());

        ClickableSpan conditionsSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/terms"));
                startActivity(intent);
            }
        };

        ClickableSpan privacyPolicySpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/privacy"));
                startActivity(intent);
            }
        };

        ClickableSpan cookiesPolicySpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/cookies"));
                startActivity(intent);
            }
        };

        String text3 = textView3.getText().toString();
        int startConditions = text3.indexOf("Condiciones");
        if (startConditions != -1) {
            int endConditions = startConditions + "Condiciones".length();
            spannableString3.setSpan(conditionsSpan, startConditions, endConditions, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        int startPrivacyPolicy = text3.indexOf("Política de privacidad");
        if (startPrivacyPolicy != -1) {
            int endPrivacyPolicy = startPrivacyPolicy + "Política de privacidad".length();
            spannableString3.setSpan(privacyPolicySpan, startPrivacyPolicy, endPrivacyPolicy, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        int startCookiesPolicy = text3.indexOf("Política de cookies");
        if (startCookiesPolicy != -1) {
            int endCookiesPolicy = startCookiesPolicy + "Política de cookies".length();
            spannableString3.setSpan(cookiesPolicySpan, startCookiesPolicy, endCookiesPolicy, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        textView3.setText(spannableString3);
        textView3.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }
}
