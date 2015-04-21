package org.hp.com.data.objects;


import org.hp.com.pojo.Entity;

/**
 * Created by ofer on 29/07/14.
 *
 */
public class SampleEntity implements Entity {
    private int id;
    private String name;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
