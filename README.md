# Countries

I developed this application with kotlin language.<br> 
If you want to save the data, you can use the shared preference. I used this to save time. if time is greater than 10 I will get data from "room database". Otherwise I will get it using api

## Major technologies

- MVVM
- RxJava(I pulled data using single class)
- Room(I used three annotations to save: Add, delete, Query)
- Retrofit(ı used Gson to convert variable)
- Live data(I used three live data variables. These are the variable that holds the error, loading and data)
- Navigation companent(For a powerful application, it is necessary to use navigation. Single activity, multiple fragments.)
- Coroutine(I used it for data operations. to save data to local database)
- Data binding(i used databinding to take up less space.This way is very efficent)
- Shared preference(If you want to save the data, you can use the shared preference. I used this to save time. if time is greater than 10 I will get data from room         database. Otherwise I will get it using api)
- Glide(I used glide to load the images. If the upload is "loading", it will be "circular bar". If "error", the wrong image will be shown.)

