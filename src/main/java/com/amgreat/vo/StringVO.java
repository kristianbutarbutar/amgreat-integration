package com.amgreat.vo;

public class StringVO extends StatusVO {
	private String row;
	private String cmdName;
	private StringVO[] rows;
	public String getCmdName() { return cmdName; }
	public void setCmdName(String cmdName) { this.cmdName = cmdName; }
	public String getRow() { return row; }
	public void setRow(String row) { this.row = row; }
	public StringVO[] getRows() { return rows; }
	public void setRows(StringVO[] rows) { this.rows = rows; }
}
