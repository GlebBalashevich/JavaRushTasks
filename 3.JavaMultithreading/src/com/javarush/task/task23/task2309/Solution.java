package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubscriptions());
        print(solution.getSubjects());
    }

    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>(){
            @Override
            public List<User> execute() {
                return super.execute();
            }

            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }
    public List<Subscription> getSubscriptions(){
        return new AbstractDbSelectExecutor<Subscription>(){
            @Override
            public List<Subscription> execute() {
                return super.execute();
            }

            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }
    public List<Subject> getSubjects(){
        return new AbstractDbSelectExecutor<Subject>(){
            @Override
            public List<Subject> execute() {
                return super.execute();
            }

            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        }.execute();
    }
    public List<Server> getServers(){
        return new AbstractDbSelectExecutor<Server>(){
            @Override
            public List<Server> execute() {
                return super.execute();
            }

            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        }.execute();
    }
    public List<Location> getLocations(){
        return new AbstractDbSelectExecutor<Location>(){
            @Override
            public List<Location> execute() {
                return super.execute();
            }

            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}