package org.toby;

import org.toby.model.Person;
import org.toby.util.ColumnField;
import org.toby.util.Metamodel;
import org.toby.util.PrimaryKeyField;
import java.util.List;


public class Client
{
    public static void main( String[] args ) {
        /*
        Metamodel<Person> metamodel = Metamodel.of(Person.class);

        List<PrimaryKeyField> primaryKeyFields = metamodel.getPrimaryKeyFields();
        List<ColumnField> columnFields = metamodel.getColumnFields();

        for (ColumnField field : columnFields) {
            System.out.println(field.getName());
        }

        for (PrimaryKeyField field : primaryKeyFields) {
            System.out.println(field.getType().getSimpleName());
        }
         */
    }
}
