package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "C:\\JavaRushTasks\\Tests\\src\\T2022.txt";
        String serialFileName = "C:\\JavaRushTasks\\Tests\\src\\T2022a.txt";

        Solution solution = new Solution(fileName);
        solution.writeObject("Hello Java");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(serialFileName));
        out.writeObject(solution);


        ObjectInputStream in = new ObjectInputStream(new FileInputStream(serialFileName));

        Solution solution1 = (Solution) in.readObject();
        solution1.writeObject("I'm a superman");
    }
}
