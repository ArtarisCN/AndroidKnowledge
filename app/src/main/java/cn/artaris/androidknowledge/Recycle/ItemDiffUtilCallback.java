package cn.artaris.androidknowledge.Recycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * cn.artaris.androidknowledge.Recycle
 * AndroidKnowledge
 * 2019.05.12  23:35
 *
 * @author : artairs
 */
public class ItemDiffUtilCallback  extends DiffUtil.Callback {

    private List<Item> oldList;
    private List<Item> newList;

    public ItemDiffUtilCallback(List<Item> oldList, List<Item> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return newList.get(i).getName().equals(oldList.get(i1).getName());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return newList.get(i).getContent().equals(oldList.get(i1).getContent());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Item OldItem = oldList.get(oldItemPosition);
        Item newItem = newList.get(oldItemPosition);

        Bundle bundle = new Bundle();
        if(OldItem.getName().equals(newItem.getName())){
            bundle.putString("name",newItem.getName());
        }

        if(OldItem.getContent().equals(newItem.getContent())){
            bundle.putString("content",newItem.getContent());
        }

        return bundle;
    }

}
