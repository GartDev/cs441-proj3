package com.example.proj3;

import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;

    public MainThread(SurfaceHolder surfaceHolder, GameView gameView){
            super();
            this.surfaceHolder = surfaceHolder;
            this.gameView = gameView;
    }
    @Override
    public void run(){
        while(running){
            canvas = null;

            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder){
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            }catch (Exception e) {} finally{
                if (canvas!= null){
                    try{
                        surfaceHolder.unlockcanvasAndPost(canvas);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
