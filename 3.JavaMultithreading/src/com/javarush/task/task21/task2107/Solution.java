package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution cloneSolution = new Solution();
        for(Map.Entry<String, User> pair : users.entrySet()){
            cloneSolution.users.put(pair.getKey(), (User) pair.getValue().clone());
        }
        return cloneSolution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;

        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User cloneUser = new User(age, name);
            return cloneUser;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            if (age != user.age) return false;
            if (name != null ? !name.equals(user.name) : user.name != null) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
