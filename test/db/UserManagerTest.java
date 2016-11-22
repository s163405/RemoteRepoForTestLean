﻿package db;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TestDataBase;
import model.User;

public class UserManagerTest {

	@Test
	public void ログイン名とパスワードでレコードを取得_成功() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story01/dbaccess_test.xls");

		// 登録済みのログイン名とパスワードを指定して、データベースからオブジェクトを読み込み
		UserManager um=new UserManager();
		User user=um.getUser("test1","xyz");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(user.getLoginName(),is("test1"));
		assertThat(user.getPassWord(),is("xyz"));
		assertThat(user.getName(),is("Mr.x"));
		assertThat(user.getEmail(),is("mrx@gmail.com"));

	}

	@Test
	public void ログイン名とパスワードでレコードを取得_失敗() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story01/dbaccess_test.xls");

		// 登録されていないログイン名とパスワードを指定して、データベースからオブジェクトを読み込み
		UserManager um=new UserManager();
		User user=um.getUser("test","xyz");

		// 読み込んだオブジェクトがNULLになっていることを確認
		assertThat(user,nullValue());

	}

	@Test
	public void 管理者ログイン名とパスワードでレコードを取得_成功() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/dbaccess_test.xls");

		// 登録済みのログイン名とパスワードを指定して、データベースからオブジェクトを読み込み
		UserManager um=new UserManager();
		User user=um.getUserAdmin("admin","admin");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(user.getLoginName(),is("admin"));
		assertThat(user.getPassWord(),is("admin"));
		assertThat(user.getName(),is("Mr.Admin"));
		assertThat(user.getEmail(),is("admin@gmail.com"));

	}

	@Test
	public void 管理者ログイン名とパスワードでレコードを取得_失敗() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/dbaccess_test.xls");

		// 登録されていないログイン名とパスワードを指定して、データベースからオブジェクトを読み込み
		UserManager um=new UserManager();
		User user=um.getUserAdmin("test1","xyz");

		// 読み込んだオブジェクトがNULLになっていることを確認
		assertThat(user,nullValue());

	}

}
