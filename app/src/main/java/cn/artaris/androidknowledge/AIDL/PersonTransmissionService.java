package cn.artaris.androidknowledge.AIDL;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.artaris.androidknowledge.AIDL.Model.Person;
import cn.artaris.androidknowledge.PersonTransmissionInterface;

/**
 * cn.artaris.androidknowledge.AIDL
 * AndroidKnowledge
 * 2019.05.14  16:52
 *
 * @author : artairs
 */
public class PersonTransmissionService extends Service {

    PersonTransmissionImpl mBinder = new PersonTransmissionImpl();
    int count = 0;
    String[] name = new String[]{"张一","张二","张三","张四","张五","张六","张七","张九","张十"};

    private List<Person> mPeople = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("PersonService", "### Transmission service created");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("PersonService", "### Transmission service bind");
        return mBinder;
    }

    class PersonTransmissionImpl extends PersonTransmissionInterface.Stub {
        @Override
        public void addPerson(Person person) throws RemoteException {
            mPeople.add(person);
            Intent intent = new Intent(AIDLActivity.AIDL_INTENT_ACTION);
            intent.putExtra("name",person.getName());
            sendBroadcast(intent);
            Log.d("PersonService", person.getName());
        }

        @Override
        public Person getPerson() throws RemoteException {
            Person person = new Person(name[count]);
            count++;
            count %= name.length;
            return person;
        }
    }
}
