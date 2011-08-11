package com.pp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DataTable {
	
	private boolean sortDataAscending=true;
	
	private boolean oldSortDataAscending=true;
	
	private String sortColumn = "c1";
	
	private String oldSortColumn = "c2";
	
	private List<Object[]> data;

	
	public DataTable() {
		super();
	}
	
	
	public DataTable(boolean sortDataAscending, boolean oldSortDataAscending,
			String sortColumn, String oldSortColumn) {
		super();
		this.sortDataAscending = sortDataAscending;
		this.oldSortDataAscending = oldSortDataAscending;
		this.sortColumn = sortColumn;
		this.oldSortColumn = oldSortColumn;
	}


	
	/**
	 * Agrega un registro al data table 
	 * @param reg
	 */
	public void addReg(Object... reg) {
		if(data==null){
			data = new ArrayList<Object[]>();
		}
		data.add(reg);
	}

	
	/**
	 * Retorna el indice basado en el nombre de la columna
	 * las columas deben denominarse con el siguiente formato
	 * c0
	 * c1
	 * c2
	 * c...
	 * 
	 * @param columnName
	 * @return
	 */
	private int getColumnIndex(String columnName){
		if(columnName==null||columnName.charAt(0)!='c'){
			throw new IllegalArgumentException();
		}else{
			return Integer.parseInt(columnName.substring(1));
		}
	}
	
	
	public List<Object[]> getData() {
		if(data!=null)
		if(!oldSortColumn.equals(sortColumn)||
				oldSortDataAscending!=sortDataAscending){
			sort(sortDataAscending, 
					getColumnIndex(sortColumn), data);
			oldSortColumn = sortColumn;
			oldSortDataAscending = sortDataAscending;
		}
		return data;
	}


		
	
	public String getOldSortColumn() {
		return oldSortColumn;
	}


	public String getSortColumn() {
		return sortColumn;
	}


	public boolean isOldSortDataAscending() {
		return oldSortDataAscending;
	}


	public boolean isSortDataAscending() {
		return sortDataAscending;
	}


	public void setOldSortColumn(String oldSortColumn) {
		this.oldSortColumn = oldSortColumn;
	}


	public void setOldSortDataAscending(boolean oldSortDataAscending) {
		this.oldSortDataAscending = oldSortDataAscending;
	}


	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}


	public void setSortDataAscending(boolean sortDataAscending) {
		this.sortDataAscending = sortDataAscending;
	}


	/**
	 * Ordenaci�n de datos contenidos en una
	 * lista de datos tipo Object[]
	 * cada elemento del Object[] es una columna
	 * @param asc Ascendente
	 * @param columnIndex indice de fila
	 * @param data datos
	 */
	
	@SuppressWarnings("unchecked")
	private  void sort(final boolean asc,final int columnIndex, List<Object[]> data){
		
		Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                Object[] c1 = (Object[]) o1;
                Object[] c2 = (Object[]) o2;
                 
                if(c1[columnIndex]==null) return -1;
                if(c2[columnIndex]==null) return 1;
                
                if(c1[columnIndex] instanceof Long ){
                	Long int1 = (Long)c1[columnIndex];
                	Long int2 = (Long)c2[columnIndex];
                	return asc ? int1.compareTo(int2):int2.compareTo(int1);
                }
                
                if(c1[columnIndex] instanceof Double ){
                	Double dou1 = (Double)c1[columnIndex];
                	Double dou2 = (Double)c2[columnIndex];
                	return asc ? dou1.compareTo(dou2):dou2.compareTo(dou1);
                }
                if(c1[columnIndex] instanceof String ){
                	String str1 = (String)c1[columnIndex];
                	String str2 = (String)c2[columnIndex];
                	return asc ? str1.compareTo(str2):str2.compareTo(str1);
                }
                
            return 0;
            }
        };
        Object[] dataArray = data.toArray();
        Arrays.sort(dataArray, comparator);
        data.clear();
        //data.
        List list =  Arrays.asList(dataArray);
        data.addAll(list);
	}
	
	
	
	
	
}
