package org.toby.util;

import java.lang.reflect.Field;

public class ColumnField {

    private Field columnField;

    public ColumnField(Field columnField) {
        this.columnField = columnField;
    }

    public String getName() {
        return columnField.getName();
    }

    public Class<?> getType(){
        return columnField.getType();
    }
}
