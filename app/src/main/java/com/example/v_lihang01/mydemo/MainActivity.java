package com.example.v_lihang01.mydemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private String[] mARName;
    private String[] mARDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        initData();
        initView();


    }

    private void initData() {
        mARName = getResources().getStringArray(R.array.ar_name);
        mARDescription = getResources().getStringArray(R.array.ar_description);
    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        myAdapter = new MyAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,1, false);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                gotoARActivity(position);
            }
        });
    }


    private void gotoARActivity(int position) {
        Intent intent = new Intent(this, ARActivity.class);
        intent.putExtra("name", mARName[position]);
        startActivity(intent);
    }

    public void requestPermission(){
        String[] shouldRequestPermissions;
        ArrayList<String> shouldRequestPermissionsList = new ArrayList<String>();
        final String[] ALL_PERMISSIONS = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
        };
        if (Build.VERSION.PREVIEW_SDK_INT > Build.VERSION_CODES.M) {
            for (String permission: ALL_PERMISSIONS) {
                if(checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                    shouldRequestPermissionsList.add(permission);
                }
            }
        }
        if (shouldRequestPermissionsList.size() > 0) {
            shouldRequestPermissions = shouldRequestPermissionsList.toArray(new String[shouldRequestPermissionsList.size()]);
            requestPermissions(shouldRequestPermissions,1);
        }
    }

    private class ItemBean {
        String mARKey;
        int mARType;
        String mName;
        String mDescription;
        public ItemBean (int arType, String arKey, String name, String description) {
            mARKey = arKey;
            mARType = arType;
            mName = name;
            mDescription = description;
        }

        public String getARKey() {
            return mARKey;
        }

        public int getARType() {
            return mARType;
        }

        public String getName() {
            return mName;
        }

        public String getDescription() {
            return mDescription;
        }
    }
}
