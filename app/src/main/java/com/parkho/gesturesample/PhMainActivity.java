package com.parkho.gesturesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class PhMainActivity extends AppCompatActivity
{
    // 출력
    private TextView mTvOutput;
    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvOutput = findViewById(R.id.tv_output);
        mScrollView = findViewById(R.id.scroll_view);

        // 일반적인 제스처
        final GestureDetector detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent a_event) {
                mTvOutput.append("[onDown]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
                return false;
            }

            @Override
            public void onShowPress(MotionEvent a_event) {
                mTvOutput.append("[onShowPress]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent a_event) {
                mTvOutput.append("[onSingleTapUp]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent a_event1, MotionEvent a_event2, float a_distanceX, float a_distanceY) {
                mTvOutput.append("[onScroll]" + "[x:" + a_distanceX + "][y:" + a_distanceY + "]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent a_event) {
                mTvOutput.append("[onLongPress]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
            }

            @Override
            public boolean onFling(MotionEvent a_event1, MotionEvent a_event2, float a_velocityX, float a_velocityY) {
                mTvOutput.append("[onFling]" + "[x:" + a_velocityX + "][y:" + a_velocityY + "]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
                return false;
            }
        });

        // 두 번 터치 제스처
        final OnDoubleTapListener doubleTapListener = new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent a_event) {
                mTvOutput.append("[onSingleTapConfirmed]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent a_event) {
                mTvOutput.append("[onDoubleTap]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent a_event) {
                mTvOutput.append("[onDoubleTapEvent]" + "\n");

                final int bottom = mTvOutput.getBottom();
                mScrollView.scrollTo(0, bottom);
                return false;
            }
        };
        detector.setOnDoubleTapListener(doubleTapListener);

        // GestureDetector 가 event 를 분류 할 수 있게 touch event 를 detector 에게 보냄
        final View gestureView = findViewById(R.id.gesture_view);
        gestureView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View a_view, MotionEvent a_motionEvent) {
                detector.onTouchEvent(a_motionEvent);
                return true;
            }
        });
    }
}
