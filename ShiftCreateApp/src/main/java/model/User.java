package model;

import java.io.Serializable;

//ユーザーに関する情報(ユーザー名、パスワード)を持つ JavaBeansモデル

public class User implements Serializable{        //Serializableで直列化を行う
	private int id;  //ユーザーID
	private String name;  //ユーザー名
	private String pass;  //パスワード
	
	public User() {}
	public User(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public int getId() { return id;}
	public String getName() { return name; }
	public String getPass() { return pass; }
}
