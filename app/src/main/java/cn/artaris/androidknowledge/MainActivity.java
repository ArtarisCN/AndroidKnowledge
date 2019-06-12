package cn.artaris.androidknowledge;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.artaris.androidknowledge.AIDL.AIDLActivity;
import cn.artaris.androidknowledge.IntentService.IntentServiceActivity;
import cn.artaris.androidknowledge.Service.StartServiceActivity;
import cn.artaris.androidknowledge.Socket.SocketServerActivity;
import cn.artaris.androidknowledge.TouchEvent.test.TestBActiviy;
import io.reactivex.ObservableEmitter;

public class MainActivity extends BaseActivity {

    private TextView mTextView;
    private Button mButton;

    private List<Action> mActions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mTextView = findViewById(R.id.text_view);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadTest();
            }
        });


        initAction();


//        RecyclerView recyclerView = findViewById(R.id.recycle_view);
//        StartAdapter adapter = new StartAdapter();
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
    }

    private void initAction() {
        mActions.add(new Action("IntentService", IntentServiceActivity.class));
        mActions.add(new Action("Service", StartServiceActivity.class));
        mActions.add(new Action("AIDL", AIDLActivity.class));
        mActions.add(new Action("Socket", SocketServerActivity.class));
        mActions.add(new Action("Touch", TestBActiviy.class));
    }

    private class StartAdapter extends RecyclerView.Adapter<StartViewHolder> {
        @NonNull
        @Override
        public StartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_start,parent,false);
            return new StartViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StartViewHolder startViewHolder, int i) {
            startViewHolder.bindTo(mActions.get(i));
        }

        @Override
        public int getItemCount() {
            return mActions.size();
        }
    }

    ObservableEmitter<String> mStringObservableEmitter;

    private class StartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Class mClass;
        private Button mButton;

        public StartViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.button);
            mButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }

        private void bindTo(Action action) {
            mClass = action.clazz;
            mButton.setText(action.mButtonName);
        }
    }


    private class Action<T extends AppCompatActivity> {
        String mButtonName;
        Class<T> clazz;

        public Action(String buttonName, Class<T> clazz) {
            mButtonName = buttonName;
            this.clazz = clazz;
        }
    }

    Handler mHandler;

    private void threadTest() {
        Log.d("MainActivity", Looper.myLooper().toString());
        Log.d("MainActivity", Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {

                mTextView.setText("测试成功");
                Log.d("MainActivity", Thread.currentThread().getName());
            }
        }).start();
    }

    @Override
    protected void onClick(View view) {
    }
}
