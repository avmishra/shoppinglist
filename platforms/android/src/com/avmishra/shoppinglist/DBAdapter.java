package com.avmishra.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter 
{
    public static final String KEY_ROWID 		= "_id";
    public static final String KEY_USERID 		= "userid";
    public static final String KEY_EMAIL 		= "email";
    public static final String KEY_FIRSTNAME 	= "firstname"; 
    public static final String KEY_LASTNAME 	= "lastname";
    private static final String TAG 			= "DBAdapter";
    
    private static final String DATABASE_NAME 			= "shoppinglist";
    private static final String DATABASE_TABLE_USERS 	= "users";
    private static final int DATABASE_VERSION 			= 1;

    private static final String CREATE_TABLE_USERS =
        "create table users (_id integer primary key autoincrement, "
        + "userid integer not null,"
        + "email text not null, firstname text, "
        + "lastname text);";
        
    private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_USERS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
    }    
    
    //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    //---insert a title into the database---
    public long insertUser(long userid, String email, String firstname, String lastname) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_USERID, userid);
        initialValues.put(KEY_EMAIL, email);
        initialValues.put(KEY_FIRSTNAME, firstname);
        initialValues.put(KEY_LASTNAME, lastname);
        /*
        db.execSQL("INSERT INTO "+
        		DATABASE_TABLE_USERS +"("+KEY_USERID+","+
        		KEY_USERNAME +"," +
        		KEY_EMAIL +"," +
        		KEY_FIRSTNAME +"," +
        		KEY_LASTNAME +"," +
        		KEY_ISHIDDEN +"," +
        		KEY_USERTYPE +"," +
        		KEY_ISADMIN +
        		")"+
        		"VALUES(2,'AVA','test.com','fist','last',1,2,3)");
        		*/
        return db.insert(DATABASE_TABLE_USERS, null, initialValues);
    }


    //---retrieves user details---
    public Cursor getUserDetails(){
        return db.query(DATABASE_TABLE_USERS, new String[] {
				KEY_USERID,KEY_EMAIL,KEY_FIRSTNAME,KEY_LASTNAME
			},null,null,null,null,null
		);
    }


    //---updates a title---
    public boolean updateUser(long userid, String email,String firstname,String lastname){
        ContentValues args = new ContentValues();
        args.put(KEY_EMAIL, email);
        args.put(KEY_FIRSTNAME, firstname);
        args.put(KEY_LASTNAME, lastname);
        return db.update(DATABASE_TABLE_USERS, args, 
                         KEY_USERID + "=" + userid, null) > 0;
    }
}
