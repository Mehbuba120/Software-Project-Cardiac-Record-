package com.example.cardiacrecorder;

import java.util.ArrayList;

public class DataList {
    private ArrayList<DataModel> records= new ArrayList<>();

    /**
     * add a data to records (a recordlist)
     * @param data datatype is ContactModel type
     */
    public void add(DataModel data)
    {
        if(records.contains(data))
        {
            throw new IllegalArgumentException();
        }
        records.add(data);
    }

    /**
     * delete a particular data from database if data is
     * exist on that particular database or else if not then
     * throw an exception
     * @param data ContactModel type
     */
    public void delete(DataModel data)
    {
        if(!records.contains(data))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            records.remove(data);
        }
    }

    /**
     * update a particular record with new value
     * @param record_old
     * @param record_new
     */
    public void update(DataModel record_old, DataModel record_new) {
        if (records.contains(record_old)) {
            records.remove(record_old);
            if (records.contains(record_new)) {
                throw new IllegalArgumentException();
            }
            records.add(record_new);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * this will show the size of RecordList
     * @return
     * size of RecordList
     */
    public int countRecords() {
        return records.size();
    }

    /**
     * this will return a List of records (a recordlist)
     * @return
     * ArrayList<ContactModel>
     */
    public ArrayList<DataModel> getRecords()
    {
        ArrayList<DataModel> recordlist= records;
        return recordlist;
    }
}
