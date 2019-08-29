# Introduction to Retrofit

## What is this?

Through one simple project(introduction to retrofit), i want to shows how to get data(posts) from remote API using Retrofit and RxJava.

I was loading posts from:

https://jsonplaceholder.typicode.com/posts/


## Requirements

Android 5.0 or later (Minimum SDK level 21)

Android Studio 3.0 (to compile and use)

## Define dependency
In order to use Retrofit + RxJava, you need to add dependency in your build.gradle

    api 'com.squareup.retrofit2:retrofit:2.4.0'
    api 'com.squareup.retrofit2:converter-gson:2.4.0'
    api 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'
    api 'com.google.code.gson:gson:2.8.2'
    api 'io.reactivex.rxjava2:rxjava:2.2.10'
    api 'io.reactivex.rxjava2:rxandroid:2.1.1'

## Define Model - POJO

class PostDataItem(

    @SerializedName("userId") @Expose var userId: String,
    
    @SerializedName("id") @Expose var id: String,
    
    @SerializedName("title") var title: String,
    
    @SerializedName("body") @Expose var body: String)
    
  
## Define API interface

interface ApiInterface {
    @GET("/posts")
    fun doGetPosts(): Single<Response<List<PostDataItem>>>}
    
    
## Define Retrofit
class APIClient {

    object SingletonConfig {

        private var retrofit: Retrofit? = null
        private const val URL_BASE = "https://jsonplaceholder.typicode.com/posts/"

        fun getRetrofit(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}



## Very easy to use:
  val apiInterface = APIClient.SingletonConfig.getRetrofit()?.create(ApiInterface::class.java)
  
  singleResponse = apiInterface!!.doGetPosts()      
  
        singleResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<List<PostDataItem>>> {

                override fun onSuccess(response: Response<List<PostDataItem>>) {
                //Do something()
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onError(e: Throwable) {
                //Error handling
                }
            })
            

## What does it look like?

![test image size](https://github.com/MilanBojic/introduction-to-retrofit/blob/master/image1.png)

![test image size](https://github.com/MilanBojic/introduction-to-retrofit/blob/master/image2.png)



**Support**

If you've found an error while using the library, please file an issue. All patches are encouraged, and may be submitted by forking this project and submitting a pull request through GitHub.
