package com.floreantpos.report;

import com.floreantpos.POSConstants;
import com.floreantpos.main.Application;
import com.floreantpos.util.NumberUtil;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DailyTxnReportModel extends AbstractTableModel {

	private String currencySymbol;

	private String[] columnNames = {"TicketID",
            POSConstants.TOTAL};
	private List<ReportItem> items;
	private double grandTotal;

	public DailyTxnReportModel() {
		super();
		currencySymbol = Application.getCurrencySymbol();
	}

	public int getRowCount() {
		if(items == null) {
			return 0;
		}
		
		return items.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		ReportItem item = items.get(rowIndex);
		
		switch(columnIndex) {
			case 0:
				return item.getId();
				
			case 1:
                return " " + NumberUtil.formatToCurrency(item.getTotal());
		}

		return null;
	}

	public List<ReportItem> getItems() {
		return items;
	}

	public void setItems(List<ReportItem> items) {
		this.items = items;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public String getGrandTotalAsString() {
		return currencySymbol + " " + NumberUtil.formatToCurrency(grandTotal);
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void calculateGrandTotal() {
		grandTotal = 0;
		if(items == null) {
			return;
		}
		
		for (ReportItem item : items) {
			grandTotal += item.getTotal();
		}
	}
}
