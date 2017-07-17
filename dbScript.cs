using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System.Data;
using System;




public class dbScript : MonoBehaviour {
	public static int kwestionariusz=7;
	public static int mLicznik=0;
	public static string name69="a"; // lub new static
	public static string[] lista = new string[6];
	 public InputField Tobj1; 
	 public Text Tobj2; 
	// Use this for initialization
	void Awake () {
		kwestionariusz=GameManager2.y;
	}
	 void Start () {
		//GameManager2.y = kwestionariusz;
		condb();
		Tobj1.text = name69;
		Tobj2.text = name69;
		Debug.Log("To jest questionariusz: " + kwestionariusz);
//		Tobj1 = GetComponent<Text>();
		//TextMesh txt = GetComponent<TextMesh>();

	}

	public void OdbiorDanych1(string odebraneDane)

	{
		TextMesh txt = GetComponent<TextMesh>();
		txt.text = odebraneDane;
		//int y = System.Int32.Parse(odebraneDane);
		kwestionariusz = System.Int32.Parse(odebraneDane);
		Debug.Log("Dane jako nieint, a string: " + odebraneDane);
	}
	public static string condb ()
	{	kwestionariusz=GameManager2.y;
		Debug.Log("To jest questionariusz1: " + kwestionariusz);
		//string conn = "URI=file:" + Application.dataPath + "/items1.db";  //
		string conn = "URI=file:"+"data/data/com.example.radzi.przewodnikmuzealny/databases/items1.db";  //bardzo wazne
		IDbConnection dbconn = (IDbConnection)new Mono.Data.Sqlite.SqliteConnection(conn);
		dbconn.Open();
		IDbCommand dbcommand = dbconn.CreateCommand();
		if (kwestionariusz >= 5 && kwestionariusz < 9) {
			string sqlQuery = "SELECT opis2 " + "FROM items1";
			dbcommand.CommandText = sqlQuery;
		}
		if (kwestionariusz < 5) {
			string sqlQuery = "SELECT opis1 " + "FROM items1";
			dbcommand.CommandText = sqlQuery;
		}

		if (kwestionariusz >= 9 ) {
			string sqlQuery = "SELECT opis3 " + "FROM items1";
			dbcommand.CommandText = sqlQuery;
		}
		IDataReader reader = dbcommand.ExecuteReader();

		while (reader.Read())
		{
			if (mLicznik < lista.Length) {
				lista [mLicznik] = reader.GetString (0);
				mLicznik++;
			}
			name69 = reader.GetString(0);
			Debug.Log(  "name ="+ name69);
			int li = 0;
			for (int i = 0; i < lista.Length; i++) {
				Debug.Log(  "Tab_name ="+ lista[i]);

			}

			//Debug.Log(  "kwest ="+ kwestionariusz);
		}

		//Debug.Log(  "2name ="+ lista[2]);

		reader.Close();
		reader = null;
		dbcommand.Dispose();
		dbcommand = null;
		dbconn.Close();
		dbconn = null;

		return name69;
	}

	// Update is called once per frame
	 void Update () {
		int licznik = 0;
		//if (licznik == 0) {
			kwestionariusz=GameManager2.y;
			name69=condb ();
		//	licznik++;
		//}
		//Tobj1 = GameObject.Find ("aText").GetComponent<Text> ();
		Tobj1.text = name69;
		Tobj2.text = name69;
		Debug.Log(  "UpdateName ="+ name69);
		//Tobj1.text = Start.lista[2];


	}
}
