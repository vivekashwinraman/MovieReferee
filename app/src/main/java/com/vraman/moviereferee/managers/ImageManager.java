package com.vraman.moviereferee.managers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.InputStream;
import java.lang.ref.WeakReference;

public class ImageManager {

    private LruCache<String, Bitmap> imageCache;
    private Context context;

    public ImageManager(Context context){
        this.context = context;
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() /1024);
        final int cacheSize = maxMemory/8;
        imageCache = new LruCache<String, Bitmap>(cacheSize){
          @Override
          protected  int sizeOf(String key, Bitmap bitmap){
              return bitmap.getByteCount()/1024;
          }
        };
    }

    public void loadImage(ImageView imageView, String uri) {
        new BitmapWorkerTask(imageView, uri).execute();
    }

    public Bitmap getBitmapFromCache(String key) {
        return imageCache.get(key);
    }

    private void addBitmapToCache(String key, Bitmap bitmap) {
        if (getBitmapFromCache(key) == null) {
            imageCache.put(key, bitmap);
        }
    }

    private class BitmapWorkerTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewWeakReference;
        private String imageUri;

        public BitmapWorkerTask(ImageView imageView, String imageUri) {
            imageViewWeakReference = new WeakReference<ImageView>(imageView);
            this.imageUri = imageUri;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            InputStream stream = null;
            try {
                stream = context.getAssets().open(imageUri);
                return BitmapFactory.decodeStream(stream);
            } catch (Exception e) {
                Log.i("bitmaptask", "error occurred");
                return null;
            } finally {
                try {
                    if (stream != null) {
                        stream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewWeakReference != null && bitmap != null) {
                final ImageView imageView = imageViewWeakReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                    addBitmapToCache(imageUri, bitmap);
                }
            }
        }
    }
}
