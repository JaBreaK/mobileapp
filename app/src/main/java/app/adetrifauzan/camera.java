    package app.adetrifauzan;

    import android.content.Intent;
    import android.graphics.Bitmap;
    import android.icu.text.SimpleDateFormat;
    import android.media.MediaScannerConnection;
    import android.os.Bundle;
    import android.os.Environment;
    import android.provider.MediaStore;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.Toast;

    import androidx.activity.EdgeToEdge;
    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    import java.io.File;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.Date;
    import java.util.Locale;

    public class camera extends AppCompatActivity {

        private final static int REQUEST_CODE = 22;
        Button btncamera;
        ImageView image;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_camera);

            btncamera = findViewById(R.id.btncamera);
            image = findViewById(R.id.imageview);

            btncamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, REQUEST_CODE);
                }
            });


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        private void saveImageToGallery(Bitmap bitmap) {
            String timeStamp = new SimpleDateFormat("yymmdd_HHmmss", Locale.getDefault()).format(new Date());
            String imageFileName = "JPEG_" + timeStamp + ".jpg";
            File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File imageFile = new File(storageDir, imageFileName);

            try {
                FileOutputStream fos = new FileOutputStream(imageFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fos);
                fos.flush();
                fos.close();

                MediaScannerConnection.scanFile(this,
                        new String[]{imageFile.getAbsolutePath()},
                        new String[]{"image/jpeg"},
                        null);
                Toast.makeText(this,"Gambar disimpan di galeri brokk",
                Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "GAGAL SIMPAN BROK",
                        Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        protected void onActivityResult(int requesCode, int resultCode,
                                        @Nullable Intent data){
            if (requesCode == REQUEST_CODE && resultCode == RESULT_OK && data != null)
            {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                image.setImageBitmap(photo);
                saveImageToGallery(photo);
            }
            super.onActivityResult(resultCode, resultCode, data);
        }

    }