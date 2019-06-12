// PersonTransmissionInterface.aidl
package cn.artaris.androidknowledge;

// Declare any non-default types here with import statements
import cn.artaris.androidknowledge.AIDL.Model.Person;
import java.util.List;

interface PersonTransmissionInterface {
   void addPerson(in Person person);

    Person getPerson();
}
