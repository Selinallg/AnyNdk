package com.dds.anyndk;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dds.opengl.DouCameraActivity;
import com.dds.opengl.utils.Consumer;
import com.dds.opengl.utils.Permissions;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
//        tv.setText(AnyNdk.stringFromJNI());

        // 测试3
        //  AnyNdk.native3();

        // 测试4
        //AnyNdk.native4();


        // 测试11

        // 普通测试
//        String hello = AnyNdk.native11(100, "hello", 100.123f);
//        tv.setText(hello);

        // 数组测试
//        AnyNdk.native11_2(new String[]{"test1", "test2", "test3"}, new int[]{112, 113, 114});

        // c/++反射调用java方法
        // AnyNdk.native11_3();

        // c/c++反射修改变量值
//        JavaHelper javaHelper = new JavaHelper();
//        javaHelper.testReflect(javaHelper);

        // 动态注册Java方法
//        AnyNdk.dynamicNative();
//        AnyNdk.dynamicNative(12);
//        JavaHelper javaHelper = new JavaHelper();
//        AnyNdk.native11_5(javaHelper);
//
//        Log.e("dds_native", "我先执行");


        // c++ 面向对象编程

//        AnyNdk.native5();


    }


    // openGL显示摄像头
    public void onDouyinCamera(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Permissions.request(this, new String[]{Manifest.permission.CAMERA,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) {
                    if (integer == PackageManager.PERMISSION_GRANTED) {
                        DouCameraActivity.openActivity(MainActivity.this);
                    }

                }
            });
        }


    }
}
