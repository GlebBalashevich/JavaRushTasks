package com.javarush.task.task20.task2002;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        try {
            File yourFile = new File("C:\\JavaRushTasks\\Tests\\src\\T2002.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(new User("Balashevich", "Elizabeth", new Date(90,5,27), false, User.Country.OTHER));
            javaRush.users.add(new User("Balashevich", "Glebchik", new Date(89,8,30), true, User.Country.OTHER));
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if (!users.isEmpty()){
                String newLine = "\n";

                outputStream.write(("hasUsers"+newLine).getBytes());
                outputStream.write((users.size()+newLine).getBytes());
                for (User user : users){
                    outputStream.write((user.getFirstName()+newLine).getBytes());
                    outputStream.write((user.getLastName()+newLine).getBytes());
                    outputStream.write((user.getBirthDate().getTime()+newLine).getBytes());
                    outputStream.write(((user.isMale() ? 1 : 0) + newLine).getBytes());
                    outputStream.write((user.getCountry()+newLine).getBytes());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            StringBuilder sb = new StringBuilder();

            if (inputStream.available() > 0) {
                while (inputStream.available() > 0){
                    sb.append((char) inputStream.read());
                }
                String inputData = sb.toString();
                if (inputData.contains("hasUsers")){
                    String[] usersArray = inputData.replace("hasUsers\n","").split("\n");
                    int index = 1;
                    for(int i = 0; i < Integer.parseInt(usersArray[0]); i++){
                        User user = new User();
                        user.setFirstName(usersArray[index]); index++;
                        user.setLastName(usersArray[index]); index++;
                        user.setBirthDate(new Date(Long.parseLong(usersArray[index]))); index++;
                        user.setMale(Integer.parseInt(usersArray[index]) > 0); index++;
                        user.setCountry(User.Country.valueOf(usersArray[index])); index++;
                        users.add(user);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
