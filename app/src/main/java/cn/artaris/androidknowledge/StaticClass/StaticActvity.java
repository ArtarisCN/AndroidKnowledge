package cn.artaris.androidknowledge.StaticClass;

import android.view.View;
import android.widget.Button;

import cn.artaris.androidknowledge.BaseActivity;

/**
 * cn.artaris.androidknowledge.StaticClass
 * AndroidKnowledge
 * 2019.05.15  17:35
 *
 * @author : artairs
 */
public class StaticActvity extends BaseActivity {

    private InnerClass mInnerClass = new InnerClass();
    private StaticInnerClass mStaticInnerClass = new StaticInnerClass();

    private String out;

    @Override
    protected void onClick(View view) {

        new Button(this).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }
        });

    }


    private class InnerClass{
        private String innerName;

        private void test(){
            innerName = out;
        }
    }


    private static class StaticInnerClass{
        private String staticName;

        private void test(){
        }
    }

}
