package org.toby.util;

import java.lang.reflect.Field;

public class PrimaryKeyField {

    private Field primaryKeyField;

    public PrimaryKeyField(Field primaryKeyField) {
        this.primaryKeyField = primaryKeyField;
    }

    public String getName() {
        return primaryKeyField.getName();
    }

    public Class<?> getType(){
        return primaryKeyField.getType();
    }
}
