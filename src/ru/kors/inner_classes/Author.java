package ru.kors.inner_classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Author {
    private ArrayList<String> roles = new ArrayList<>();

    public void addRole(String role) {
        roles.add(role);
    }

    public Iterator<String> roleIterator() {
        return new Iterator<String>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < roles.size();
            }

            @Override
            public String next() {
                return roles.get(count++);
            }
        };
    }
}
