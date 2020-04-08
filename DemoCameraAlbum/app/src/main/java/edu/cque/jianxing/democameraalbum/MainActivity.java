package edu.cque.jianxing.democameraalbum;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_PHOTO = 0x01;
    private final int REQUEST_ALBUM = 0x02;
    private final int REQUEST_WRITE_EXTERNAL_STORGE = 0X03;

    private ImageView ivPhoto;
    private Button btnCamera, btnAlbum;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPhoto = findViewById(R.id.iv_photo);
        btnCamera = findViewById(R.id.btn_camera);
        btnAlbum = findViewById(R.id.btn_album);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //定义文件实例
                File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                //创建文件
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 将File转换成uri
                if (Build.VERSION.SDK_INT >= 24) {
                    imageUri = FileProvider.getUriForFile(MainActivity.this, "edu.cque.jianxing.democameraalbum", outputImage);
                }else{
                    imageUri = Uri.fromFile(outputImage);
                }
                // 启动相机
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, REQUEST_PHOTO);
            }
        });

        btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 运行时检查读写外部存储器的权限，没有就申请一个
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Log.d("MainActivity", "request permission");
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORGE);
                } else {
                    openAlbum();
                }
            }
        });

    }

    /**
     * 其它Activity返回结果回调方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream((imageUri)));
                        ivPhoto.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case REQUEST_ALBUM:
                Log.d("MainActivity", "Activity Result: REQUEST_ALBUM");
                if (resultCode == RESULT_OK) {
                    if (Build.VERSION.SDK_INT >= 19) { // 判断当前 android 版本信息
                        //handleImageOnKitKat(data);
                        Uri uri = data.getData();
                        ivPhoto.setImageURI(uri);
                    } else {
                        //handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:

                break;
        }
    }

    /**
     * 请求权限返回结果回调方法
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_WRITE_EXTERNAL_STORGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    Toast.makeText(this, "You haven't the permission to access external storage", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    private void openAlbum() {
        Log.d("MainActivity", "openAlbum()");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);  //通过类型选择数据
        intent.setType("image/*");  //其它类型有 video, 也可以指定具体扩展名  image/jpg   image/png 等
        startActivityForResult(intent, REQUEST_ALBUM);
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        Log.d("MainActivity", "handImageOnKitKat()");
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if (uri.getAuthority().equals("com.android.provider.media.documents")) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if (uri.getAuthority().equals("com.android.providers.downloads.documents")) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            } else if (uri.getScheme().equalsIgnoreCase("content")) {
                imagePath = getImagePath(uri, null);
            } else if (uri.getScheme().equalsIgnoreCase("file")) {
                imagePath = uri.getPath();
            }
        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Log.d("MainActivity", "handleImageBeforeKitKat()");
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);;
    }

    private String getImagePath(Uri uri, String selection) {
        Log.d("MainActivity", "getImagePath");
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        Log.d("MainActivity", "displayImage()");
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            ivPhoto.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "failed to load image", Toast.LENGTH_LONG).show();
        }
    }
}
