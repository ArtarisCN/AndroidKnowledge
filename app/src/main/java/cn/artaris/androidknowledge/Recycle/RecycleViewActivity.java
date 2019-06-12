package cn.artaris.androidknowledge.Recycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge
 * AndroidKnowledge
 * 2019.05.12  21:22
 *
 * @author : artairs
 */
public class RecycleViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    private DiffUtil mDiffUtil;
    LinearLayoutManager manager;
    DemoAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        mRecyclerView = findViewById(R.id.view);
        manager = new LinearLayoutManager(this);
        manager.setInitialPrefetchItemCount(3);
        mRecyclerView.setLayoutManager(manager);
        manager.onSaveInstanceState();


        mAdapter = new DemoAdapter();
        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = recyclerView.getChildCount();
                int totalItemCount = manager.getItemCount();
                int firstVisibleItem = manager.findFirstVisibleItemPosition();
//                if(loading) {
//                    if (totalItemCount > previousTotal) {
//                        //说明数据已经加载结束
//                        loading = false;
//                        previousTotal = totalItemCount;
//                    }
//                }
//                if (!loading && totalItemCount-visibleItemCount <= firstVisibleItem){
//                    currentPage ++;
//                    onLoadMore(currentPage);
//                    loading = true;
//                }
            }
        });
    }
}
