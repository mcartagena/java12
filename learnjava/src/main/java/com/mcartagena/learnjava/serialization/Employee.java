package com.mcartagena.learnjava.serialization;

import lombok.Data;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Employee implements Serializable {
    private String name;
    private String ssn;
    private int age;

    private static Map<String, Employee> pool = new ConcurrentHashMap<>();

    public synchronized static Employee getEmployee(String name, String ssn) {
        if (pool == null || pool.isEmpty()) {
            System.out.println("Adding employee");
            var e = new Employee();
            e.name = name;
            e.ssn = ssn;
            pool.put(name, e);
        }
        return pool.get(name);
    }

    private static final ObjectStreamField[] serialPersistentFields =
            {new ObjectStreamField("name", String.class),
                    new ObjectStreamField("ssn", String.class)};

    private static String encrypt(String input) {
        return input + "ecrypt";
    }

    private static String decrypt(String input) {
        return input + "decrypt";
    }

    private void writeObject(ObjectOutputStream s) throws Exception {
        ObjectOutputStream.PutField fields = s.putFields();
        fields.put("name", name);
        fields.put("ssn", encrypt(ssn));
        s.writeFields();
    }

    private void readObject(ObjectInputStream s) throws Exception {
        ObjectInputStream.GetField fields = s.readFields();
        this.name = (String) fields.get("name", null);
        this.ssn = decrypt((String) fields.get("ssn", null));
    }

    public synchronized Object readResolve() throws ObjectStreamException {
        var existingEmployee = pool.get(name);
        if (pool.get(name) == null) {
            // New employee not in memory
            pool.put(name, this);
            return this;
        } else {
            // Existing user already in memory
            existingEmployee.name = this.name;
            existingEmployee.ssn = this.ssn;
            return existingEmployee;
        }
    }

    public Object writeReplace() throws ObjectStreamException{
        var e = pool.get(name);
        return e != null ? e : this;
    }

}
