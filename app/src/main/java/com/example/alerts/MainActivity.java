package com.example.alerts;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toast)
    Button mtoast;
    @BindView(R.id.dialoge)
    Button mdialoge;
    @BindView(R.id.notification)
    Button mnotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.toast)
    public void onMtoastClicked() {
        Toast t = Toast.makeText(MainActivity.this, "thanks", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP, 0, 0);
        t.show();
    }

    @OnClick(R.id.dialoge)
    public void onMdialogeClicked() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Welcom");
        dialog.setMessage("Do you beleive ?");
        dialog.setIcon(R.drawable.ic_launcher_background);
        dialog.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("negative buutom", "onClick: thanks god   ");
            }
        });
        dialog.setPositiveButton("Canel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("positive buutom", "onClick: thanks god veru much ");
            }
        });
        dialog.show();
    }

    @OnClick(R.id.notification)
    public void onMnotificationClicked() {
        Intent intent = new Intent(MainActivity.this, Second.class);
        @SuppressLint("WrongConstant") PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
        Notification.Builder notification = new Notification.Builder(MainActivity.this);
        notification.setContentTitle("Welcom in my live ");
        notification.setContentText("Subject");
        notification.setContentIntent(pendingIntent);
        notification.setSmallIcon(android.R.drawable.dark_header);
        notification.addAction(android.R.drawable.ic_media_play, "Play", pendingIntent);
        notification.addAction(android.R.drawable.ic_media_pause, "pause", pendingIntent);
        Notification noti = notification.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0 , noti);
    }
}
