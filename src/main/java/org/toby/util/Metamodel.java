package org.toby.util;

import org.toby.annotation.Column;
import org.toby.annotation.PrimaryKey;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Metamodel<T> {

    private Class<T> clss;

    public static <S> Metamodel<S> of(Class<S> clss) {
        return new Metamodel<>(clss);
    }

    private Metamodel(Class<T> clss) {
        this.clss = clss;
    }

    public List<PrimaryKeyField> getPrimaryKeyFields() {
        List<PrimaryKeyField> primaryKeys = new ArrayList<>();
        for(Field field : clss.getDeclaredFields()){
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if(primaryKey != null){
                primaryKeys.add(new PrimaryKeyField(field));
            }
        }
        if(primaryKeys.isEmpty()) {
            throw new IllegalArgumentException("Class: " + clss.getSimpleName() + " has no Primary Key.");
        }
        return primaryKeys;
    }

    public List<ColumnField> getColumnFields() {
        List<ColumnField> columns = new ArrayList<>();
        for(Field field : clss.getDeclaredFields()){
            Column columnField = field.getAnnotation(Column.class);
            if(columnField != null){
                columns.add(new ColumnField(field));
            }
        }
        return columns;
    }
}
