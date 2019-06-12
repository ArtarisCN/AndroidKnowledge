package cn.artaris.androidknowledge.IO;

/**
 * cn.artaris.androidknowledge.IO
 * AndroidKnowledge
 * 2019.06.02  20:34
 *
 * @author : artairs
 */
public class JavaIO {
    //    inPut
//    outPut
    public static void main(String[] args) {

        double d = Math.random();

        System.out.println(d * 1000);
        System.out.println((int)(d * 1000));
        System.out.println(~((int) (d * 1000)));
        System.out.println(~~((int) (d * 1000)));

//        File file = new File("file.text");
//        OutputStream outputStream = null;
//
//        try {
//            outputStream = new FileOutputStream("./app/java_io.txt");
//            outputStream.write('b');
//            outputStream.write('e');
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


}
