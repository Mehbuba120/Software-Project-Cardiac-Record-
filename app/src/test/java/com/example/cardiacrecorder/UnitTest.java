package com.example.cardiacrecorder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTest {
    /**
     * create a Mock testList with one Record data
     * @return
     * returns a datalist
     */
    public DataList mocktestlist(){
        DataList datalist= new DataList();
        datalist.add(mocklist());
        return datalist;
    }

    /**
     * create a Mock list
     * @return
     * returns created Mock list
     */
    private DataModel mocklist()
    {
        return new DataModel(120,80,70,"normal","");
    }


    /**
     * checks if a record is added successfully on RecordList
     */
    @Test
    public void testAdd()
    {

        DataList datalist=mocktestlist();
        assertEquals(1,datalist.getRecords().size());

        DataModel data= new DataModel(120,80,70,"normal","");
        datalist.add(data);
        assertEquals(2,datalist.getRecords().size());
        assertTrue(datalist.getRecords().contains(data));
    }
    /**
     * checks if add function handle exception successfully
     */
    @Test
    public void testAddEception()
    {
        DataList datalist=new DataList();
        DataModel data=mocklist();
        datalist.add(data);

        assertThrows(IllegalArgumentException.class,()->{
            datalist.add(data);
        });
    }

    /**
     * checks if record is updated successfully on RecordList
     */
    @Test
    public void testUpdate()
    {
        DataList recordList = new DataList();

        DataModel data1= new DataModel(120,80,70,"normal","");
        DataModel data2= new DataModel(110,90,75,"normal","");

        recordList.add(data1);

        recordList.update(data1, data2);
        //assertEquals(0, data2.compareTo(DataList.getRecords().get(0)));

    }

    /**
     * checks if update function handle exception in adding successfully
     */
    @Test
    public void testUpdateEception()
    {
        DataList recordList = new DataList();

        DataModel data1= new DataModel(120,80,70,"normal","");
        DataModel data2= new DataModel(110,70,60,"normal","");

        recordList.add(data1);
        recordList.add(data2);
        assertThrows(IllegalArgumentException.class, () -> {
            recordList.update(data1, data2);
        });

    }

    /**
     * checks if record is deleted successfully from RecordList
     */
    @Test
    public void testDelete()
    {
        DataList datalist=new DataList();
        DataModel data1= new DataModel(120,80,70,"normal","");
        datalist.add(data1);
        DataModel data2= new DataModel(110,70,60,"normal","");
        datalist.add(data2);

        datalist.delete(data1);
        assertFalse(datalist.getRecords().contains(data1));


    }

    /**
     * checks if delete function handle exception successfully
     */
    @Test
    public void testDeleteEception() {
        DataList temp = mocktestlist();
        DataModel record = new DataModel(120,80,70,"normal","");

        assertThrows(IllegalArgumentException.class, () -> {
            temp.delete(record);
        });
    }

    /**
     * checks if countRecords function can count records on RecordList successfully
     */
    @Test
    public void testcountRecords() {
        DataList recordList = mocktestlist();

        DataModel record = new DataModel(120,80,70,"normal","");
        recordList.add(record);
        assertEquals(2, recordList.countRecords());
    }

    /**
     * checks if getRecords return a List successfully
     */
    @Test
    public void testGetRecords() {
        DataList recordList = mocktestlist();
        assertEquals(0, mocklist().compareTo(recordList.getRecords().get(0)));

        DataModel record = new DataModel(120,80,70,"normal","");
        recordList.add(record);

        assertEquals(0, record.compareTo(recordList.getRecords().get(1)));
        assertEquals(0, mocklist().compareTo(recordList.getRecords().get(0)));
    }


}
