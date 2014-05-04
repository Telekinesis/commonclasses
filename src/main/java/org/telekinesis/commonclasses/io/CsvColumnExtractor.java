package org.telekinesis.commonclasses.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telekinesis.commonclasses.io.LineParser;

public class CsvColumnExtractor implements LineParser
{
    private final Map<Integer, List<String>> extractedColumns = new HashMap<Integer, List<String>>();;
    private final int[] columnIndices;
    private int recordCount = 0;
    
    public CsvColumnExtractor(int... columnIndices){
	this.columnIndices = columnIndices;
	for (int i : columnIndices)
        {
	    extractedColumns.put(i, new ArrayList<String>());
        }
    }

    @Override
    public void parse(String line)
    {
	String[] terms = line.split(",");
	for (int i : columnIndices)
        {
	    extractedColumns.get(i).add(terms[i]);
        }
	recordCount++;
    }

    @Override
    public void onEnd()
    {	
    }

    public Map<Integer, List<String>> getExtractedColumns()
    {
        return extractedColumns;
    }

    public int getRecordCount()
    {
        return recordCount;
    }
    
}