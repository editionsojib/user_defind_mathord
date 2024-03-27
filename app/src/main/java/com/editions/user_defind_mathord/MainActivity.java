package com.editions.user_defind_mathord;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;

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

        button= findViewById(R.id.btn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (checkInternet()){
                   ShowText("Internet is connected");
               }else {
                   ShowText("No Internet");
               }


            }
        });



    } // onCreate end here===========================================

    private void ShowText(String message){
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }// Toast end here===========================================

    private void alartDialog(){

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Title")
                .setMessage("AlertDialog Builder is working")
                .show();
    }// lertDialog end here===========================================

    private void addValue(int a, int b, int c){
        int sum = a+b+c;

        Toast.makeText(this, ""+sum, Toast.LENGTH_SHORT).show();
    } // addValue end here===========================================

    private boolean checkInternet(){

        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo !=null && networkInfo.isConnected()){

            return true;
        }else {
            return false;
        }

    }


}
