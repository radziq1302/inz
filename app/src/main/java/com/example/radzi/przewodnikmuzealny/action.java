package com.example.radzi.przewodnikmuzealny;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.data;

public class action extends AppCompatActivity {

    private static String abc;
    private static int TAKE_PICTURE = 1;
    private Uri imageUri;

    String mCurrentPhotoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        Button camButton = (Button) findViewById(R.id.button_camera);

        //camButton.setOnClickListener(cameraListener);

    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
            Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
/*            File photo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "picture.jpg");
            imageUri = Uri.fromFile(photo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(intent, TAKE_PICTURE);*/
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, TAKE_PICTURE);
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                }
                catch (IOException ex) {

                }
                if (photoFile!=null) {
                    Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(intent, TAKE_PICTURE);
                }
            }
        }
    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        ImageView imageV = (ImageView) findViewById(R.id.image_camera);
        if (resultCode == Activity.RESULT_OK && requestCode == TAKE_PICTURE) {
            Bundle extras = intent.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageV.setImageBitmap(imageBitmap);


/*            Uri selectedImage = imageUri;
            getContentResolver().notifyChange(selectedImage, null);

            ContentResolver cr = getContentResolver();
            Bitmap bitmap;

            try {
                bitmap = MediaStore.Images.Media.getBitmap(cr, selectedImage);
                imageV.setImageBitmap(bitmap);
            }
            catch (Exception e) {
                Log.e("Abc", e.toString());
            }*/
        }
    }
    }



