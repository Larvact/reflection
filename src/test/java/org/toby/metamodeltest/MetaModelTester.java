package org.toby.metamodeltest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.toby.model.Person;
import org.toby.util.Metamodel;
import org.toby.util.PrimaryKeyField;
import java.util.List;
import java.util.stream.Collectors;

public class MetaModelTester {

    private static Metamodel<Person> personMetaModel;
    private final int numberOfPrimaryKeyFields = 1;
    private final int numberOfColumns = 2;
    private final String idFieldName = "id";

    @BeforeClass
    public static void setupMetaModel(){
        personMetaModel = Metamodel.of(Person.class);
    }

    @Test
    public void ensureCorrectNumberOfPrimaryKeys(){
        Assert.assertEquals(numberOfPrimaryKeyFields, personMetaModel.getPrimaryKeyFields().size());
    }

    @Test
    public void ensureCorrectNumberOfColumnFields(){
        Assert.assertEquals(numberOfColumns, personMetaModel.getColumnFields().size());
    }

    @Test
    public void ensureIdIsAPrimaryKey(){
        List<PrimaryKeyField> primaryKeyFields = personMetaModel.getPrimaryKeyFields();
        List<String> primaryKeyFieldNames = primaryKeyFields.stream().map(PrimaryKeyField::getName).collect(Collectors.toList());
        Assert.assertTrue(primaryKeyFieldNames.contains(idFieldName));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    //Remove all primary key annotations in the person class before running this test (see how to deactivate annotation via code alter)
    public void ensureExceptionIsRaisedIfPOJOHasNoPrimarykeys(){
        List<PrimaryKeyField> primaryKeyFields = personMetaModel.getPrimaryKeyFields();
    }





}
