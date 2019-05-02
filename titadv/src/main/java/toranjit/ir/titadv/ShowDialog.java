//package toranjit.ir.titadv;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.BitmapFactory;
//import android.graphics.Typeface;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.Environment;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.CardView;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//
//import java.io.BufferedInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.DecimalFormat;
//
///**
// * Created by Hossein Ahmadi on 19/02/2019.
// * meysam34am@gmail.com
// */
//
//public class ShowDialog extends Activity {
//    private CardView box1;
//
//    private RelativeLayout box2;
//    public static String content;
//    public static String title;
//    public static String Url;
//    public static String Url2;
//    public ImageView cover;
//    private Typeface typeface;
//    DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        finish();
//    }
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_new_message);
//        box1 = findViewById(R.id.cv_box1);
//        box2 = findViewById(R.id.cv_box2);
//
////        setTitle("Setting");
//
//        TextView tv_content = findViewById(R.id.tv_content);
//        Button close = findViewById(R.id.btn_close);
//        cover = findViewById(R.id.iv_cover);
//
//
//        if (Url != null) {
//            tv_content.setText(Environment.getExternalStorageDirectory().toString());
//            box1.setVisibility(View.GONE);
//            box2.setVisibility(View.VISIBLE);
//            Glide.with(getApplicationContext()).load(Url).diskCacheStrategy(DiskCacheStrategy.NONE)
//                    .skipMemoryCache(true).into(cover);
//
//            ImageView iv_close = findViewById(R.id.iv_close);
//            iv_close.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    finish();
//                }
//            });
//
//            TextView t1 = findViewById(R.id.t1);
//            TextView t2 = findViewById(R.id.t2);
//            TextView t3 = findViewById(R.id.t3);
//            TextView tv_now_price = findViewById(R.id.tv_now_price);
//            TextView tv_total_price = findViewById(R.id.tv_total_price);
//            t1.setTypeface(typeface);
//            t2.setTypeface(typeface);
//            t3.setTypeface(typeface);
//            tv_now_price.setTypeface(typeface);
//            tv_total_price.setTypeface(typeface);
//            tv_now_price.setText(String.valueOf(decimalFormat.format(200))+" تومان");
//            tv_total_price.setText(String.valueOf(decimalFormat.format(14200))+" تومان");
//
//            cover.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(Url2));
//                    startActivity(i);
//                }
//            });
////            new DownloadFileFromURL().execute(Url);
//
//
//        } else {
//            box1.setVisibility(View.VISIBLE);
//            box2.setVisibility(View.GONE);
//            tv_content.setText(content);
//            tv_content.setTypeface(typeface);
//            close.setTypeface(typeface);
//            close.setPadding(15, 3, 15, 3);
//            close.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    finish();
//                }
//            });
//        }
//
//
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    class DownloadFileFromURL extends AsyncTask<String, String, String> {
//
//        /**
//         * Before starting background thread
//         */
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            System.out.println("Starting download");
//            Log.v("utyrtrtrrt", "2");
////            pDialog = new ProgressDialog(MainActivity.this);
////            pDialog.setMessage("Loading... Please wait...");
////            pDialog.setIndeterminate(false);
////            pDialog.setCancelable(false);
////            pDialog.show();
//        }
//
//        /**
//         * Downloading file in background thread
//         */
//        @Override
//        protected String doInBackground(String... f_url) {
//            int count;
//            try {
//                String root = Environment.getExternalStorageDirectory().toString();
//                Log.v("utyrtrtrrt", "1");
//                System.out.println("Downloading");
//                URL url = new URL(f_url[0]);
//
//                URLConnection conection = url.openConnection();
//                conection.connect();
//                // getting file length
//                int lenghtOfFile = conection.getContentLength();
//
//                // input stream to read file - with 8k buffer
//                InputStream input = new BufferedInputStream(url.openStream(), 8192);
//
//                // Output stream to write file
//                Log.v("utyrtrtrrt", "6");
//
//                OutputStream output = new FileOutputStream(root + "/test.jpg");
//                byte data[] = new byte[1024];
//                Log.v("utyrtrtrrt", "7");
//                long total = 0;
//                while ((count = input.read(data)) != -1) {
//                    total += count;
//
//                    // writing data to file
//                    output.write(data, 0, count);
//
//                }
//                Log.v("utyrtrtrrt", "8");
//                // flushing output
//                output.flush();
//
//                // closing streams
//                output.close();
//                input.close();
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
////                Log.e("Error: ", e.getMessage());
//                Log.v("utyrtrtrrt", "3");
//            }
//
//            return null;
//        }
//
//
//        /**
//         * After completing background task
//         **/
//        @Override
//        protected void onPostExecute(String file_url) {
////            System.out.println("Downloaded");
//            Log.v("utyrtrtrrt", "done");
//            cover.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().toString() + "/test.jpg"));
//
////            pDialog.dismiss();
//        }
//
//    }
//}