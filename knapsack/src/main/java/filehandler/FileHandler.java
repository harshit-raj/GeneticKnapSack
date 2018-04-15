package filehandler;

import java.util.List;

import filehandler.CSVData;

public interface FileHandler<T extends CSVData> {
	public boolean writecsv(String colName,String fileName,List<T> data);

}
