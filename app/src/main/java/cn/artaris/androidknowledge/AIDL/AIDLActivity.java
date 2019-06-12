package cn.artaris.androidknowledge.AIDL;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.artaris.androidknowledge.BaseActivity;
import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.AIDL
 * AndroidKnowledge
 * 2019.05.14  16:51
 *
 * @author : artairs
 */
public class AIDLActivity extends BaseActivity {

    public static final String AIDL_INTENT_ACTION = "cn.artaris.androidknowledge.AIDL.local.message";

    private NameAdapter mNameAdapter = new NameAdapter();
    private List<String> mReceiveName = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mNameAdapter);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("AIDLActivity",intent.getStringExtra("name"));
                String name = intent.getStringExtra("name");
                if(!TextUtils.isEmpty(name)) {
                    mReceiveName.add(name);
                    mNameAdapter.notifyDataSetChanged();
                }
            }
        },new IntentFilter(AIDL_INTENT_ACTION));
    }

    @Override
    protected void onClick(View view) {

    }



    public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {

        @NonNull
        @Override
        public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aidl, parent, false);
            return new NameViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int i) {
            nameViewHolder.bindTo(mReceiveName.get(i));
        }

        @Override
        public int getItemCount() {
            return mReceiveName.size();
        }
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {
        TextView content;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.tv);
        }

        private void bindTo(String name) {
            content.setText(name);
        }
    }
}
