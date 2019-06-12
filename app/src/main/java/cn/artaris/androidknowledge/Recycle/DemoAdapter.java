package cn.artaris.androidknowledge.Recycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.Recycle
 * AndroidKnowledge
 * 2019.05.12  21:46
 *
 * @author : artairs
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoViewHolder> {

    private List<Item> data = new ArrayList<>();

    public void swapData(List<Item> newList, boolean diff) {
        if (diff) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ItemDiffUtilCallback(data, newList), false);
            data = newList;
            diffResult.dispatchUpdatesTo(this);
        } else {
            data = newList;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DemoViewHolder(View.inflate(viewGroup.getContext(), R.layout.fragment_test, null));
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            Bundle payload = (Bundle) payloads.get(0);
            for (String s : payload.keySet()) {
                switch (s) {
                    case "name":
                        break;
                    case "content":
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder demoViewHolder, int i) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull DemoViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }
}
