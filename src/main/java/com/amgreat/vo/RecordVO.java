package com.amgreat.vo;

public class RecordVO {
	private ResponseVO response;
	private RecordVO next;
	private StatusVO status;
	private StringVO recordsInString;
	private int recNo;
	public StringVO getRecordsInString() { return recordsInString; }
	public void setRecordsInString(StringVO recordsInString) { this.recordsInString = recordsInString; }
	public int getRecNo() { return recNo; }
	public void setRecNo(int recNo) { this.recNo = recNo; }
	public StatusVO getStatus() { return status; }
	public void setStatus(StatusVO status) { this.status = status; }
	public RecordVO getNext() { return next; }
	public void setNext(RecordVO next) { this.next = next; }
	public ResponseVO getResponse() { return response; }
	public void setResponse(ResponseVO response) { this.response = response; }
}
