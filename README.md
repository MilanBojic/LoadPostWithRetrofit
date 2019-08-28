# Introduction to Retrofit + RxJava

## What is this?

Through one simple example(registration module), i want to shows how to persist data using a ***Room***, ***Storio*** and ***SQLite***.
Our simple application stored only username and password, of course the real registration module is much more complex.

## Requirements

Android 5.0 or later (Minimum SDK level 21)

Android Studio 3.0 (to compile and use)

## Using Retrofit + RxJava
In order to use Retrofit + RxJava, you need to add dependency in your build.gradle

    api 'com.squareup.retrofit2:retrofit:2.4.0'
    api 'com.squareup.retrofit2:converter-gson:2.4.0'
    api 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'
    api 'com.google.code.gson:gson:2.8.2'
    api 'io.reactivex.rxjava2:rxjava:2.2.10'
    api 'io.reactivex.rxjava2:rxandroid:2.1.1'
    


## Example insert operations for each API

        when (index) {
            GlobalConst.SQLITE -> {
                val contentValues = ContentValues()
                contentValues.put(GlobalConst.COL_2, userName)
                contentValues.put(GlobalConst.COL_3, password)
                sqlLiteDataBase.writableDatabase.insert(GlobalConst.USER_TABLE, null, contentValues)
            }
            GlobalConst.STORIO -> {
                val user = User()
                user.userName = userName
                user.password = password
                storioApi.addUser(user)
            }
            GlobalConst.ROOM -> {
                val userRoom = UserRoom()
                userRoom.userName = userName
                userRoom.password = password
                roomApi.insertUserRoom(userRoom)
            }
        }


## What does it look like?

![test image size](https://github.com/MilanBojic/introduction-to-retrofit/blob/master/image1.png)

![test image size](https://github.com/MilanBojic/introduction-to-retrofit/blob/master/image2.png)



**Support**

If you've found an error while using the library, please file an issue. All patches are encouraged, and may be submitted by forking this project and submitting a pull request through GitHub.
