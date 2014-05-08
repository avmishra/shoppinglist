/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.avmishra.shoppinglist;

import android.database.Cursor;
import android.os.Bundle;

import org.apache.cordova.*;

public class ShoppingList extends CordovaActivity 
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.init();
        
        DBAdapter db = new DBAdapter(this);
        int isUserExist = 0;
        // get user details from web database if exist then get the latest update from server
        // other wise redirect on login page
        db.open();
        Cursor cur = db.getUserDetails();
        if(cur.moveToFirst()){
        	isUserExist = 1;
        }
        cur.close();
        db.close();
        if(isUserExist == 1 ){
        	super.loadUrl(Config.getStartUrl());
		} else {
			super.loadUrl("file:///android_asset/www/login.html");
		}
        //super.loadUrl("file:///android_asset/www/index.html");
    }
}

