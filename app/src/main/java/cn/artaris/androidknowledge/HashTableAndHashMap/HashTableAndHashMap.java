package cn.artaris.androidknowledge.HashTableAndHashMap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * cn.artaris.androidknowledge
 * AndroidKnowledge
 * 2019.05.09  18:49
 *
 * @author : artairs
 */
public class HashTableAndHashMap  extends AppCompatActivity {

    private Hashtable<String,Object> mHashtable = new Hashtable<>();
    private HashMap<String,Object> mHashMap = new HashMap<>();
    private ConcurrentHashMap<String,Object> mConcurrentHashMap = new ConcurrentHashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHashtable.put("1",new Object());
        mHashMap.put("1",new Object());

        mHashtable.contains(new Object());
        Map<String,Object> map = Collections.synchronizedMap(mHashMap);

    }
}
