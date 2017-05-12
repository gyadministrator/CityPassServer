package com.citypass.result;

public class Result<T> {
	// 返回数据给客户端,1表示成功,0表示失败
	public static final int STATE_SUCCESS = 1;
	public static final int STATE_FAILURE = 0;
	// 状态
	public int state;
	// 描述
	public String description;
	// 数据
	public T data;
}
