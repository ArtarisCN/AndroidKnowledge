package cn.artaris.androidknowledge.Socket;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.Socket
 * AndroidKnowledge
 * 2019.05.15  11:35
 *
 * @author : artairs
 */
public class SocketServerActivity extends AppCompatActivity {

    LinearLayout mShowLinear;

    EditText mMessageEditText;

    private ServerSocket mServerSocket;
    private PrintWriter mPrintWriter;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 0){
                TextView textView = new TextView(SocketServerActivity.this);
                textView.setText((String)msg.obj);
                mShowLinear.addView(textView);
            }
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_scoket_server);
        mMessageEditText = findViewById(R.id.msg_edit_text);
        mShowLinear = findViewById(R.id.show_linear);
        findViewById(R.id.send_btn).setOnClickListener(mOnClickListener);

        try {
            mServerSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new AcceptClient()).start();
    }
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String msg = mMessageEditText.getText().toString();
            if (!TextUtils.isEmpty(msg) && mPrintWriter != null) {
                //将消息写入到流中
                mPrintWriter.println(msg);
                mMessageEditText.setText("");
                String time = getTime(System.currentTimeMillis());
                final String showedMsg = "server " + time + ":" + msg;
                TextView textView = new TextView(SocketServerActivity.this);
                textView.setText(showedMsg);
                mShowLinear.addView(textView);
            }
        }
    };


        @Override
    public void onDestroy() {
        if (mServerSocket != null){
            try {
                mServerSocket.close();
                mServerSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }

    private String getTime(long time) {
        return new SimpleDateFormat("(HH:mm:ss)").format(new Date(time));
    }

    class AcceptClient implements Runnable{

        @Override
        public void run() {
            try {
                Socket clientSocket = null;
                while (clientSocket == null){
                    clientSocket = mServerSocket.accept();
                    mPrintWriter = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(clientSocket.getOutputStream())), true);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));
                while (!SocketServerActivity.this.isFinishing()) {
                    //读取客户端发来的消息
                    String msg = bufferedReader.readLine();
                    if (msg != null) {
                        String time = getTime(System.currentTimeMillis());
                        final String showedMsg = "client " + time + ":" + msg;
                        mHandler.obtainMessage(0, showedMsg)
                                .sendToTarget();
                    }
                }
                bufferedReader.close();
                clientSocket.close();
                mPrintWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
