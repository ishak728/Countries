# Countries

I developed this application with kotlin language.<br> 
If you want to save the data, you can use the shared preference. I used this to save time. if time is greater than 10 I will get data from "room database". Otherwise I will get it using api

## Major technologies

- MVVM
- `RxJava`(I pulled data using single class)
- `Room`(I used three annotations to save: Add, delete, Query)
- `Retrofit`(ı used Gson to convert variable)
- `Live data`(I used three live data variables. These are the variable that holds the error, loading and data)
- `Navigation companent`(For a powerful application, it is necessary to use navigation. Single activity, multiple fragments.)
- `Coroutine`(I used it for data operations. to save data to local database)
- `Data binding`(i used databinding to take up less space.This way is very efficent)
- `Shared preference`(If you want to save the data, you can use the shared preference. I used this to save time. if time is greater than 10 I will get data from room         database. Otherwise I will get it using api)
- `Glide`(I used glide to load the images. If the upload is "loading", it will be "circular bar". If "error", the wrong image will be shown.)


## Screenshots


<img src="https://user-images.githubusercontent.com/91196350/220430061-c47764df-55ea-4080-a23c-e72d19ed99c8.jpeg" alt="loading page"  height="400"><br><br>
when you refresh the page, the data starts to load and this "circular bar" is created<br><br>

<img src="https://user-images.githubusercontent.com/91196350/220430068-aab70ee7-daf0-48df-b3bd-68d9a37fac0a.jpeg" alt="feed page"  height="400"><br><br>
Trying to load images by "glide".<br><br>

<img src="https://user-images.githubusercontent.com/91196350/220430069-c3b6a0e7-c52f-4f42-b6d9-8d150de238fd.jpeg" alt="feed page"  height="400"><br><br>
this is feed fragment.all pages loaded<br><br>
<img src="https://user-images.githubusercontent.com/91196350/220430073-e0d7439b-1c6b-45d3-a5f9-4efd68cf35ff.jpeg" alt="feed page"  height="400"><br><br>
this is feed fragment.all pages loaded<br><br>
<img src="https://user-images.githubusercontent.com/91196350/220430076-eb690719-1407-44d8-b56f-f30a272973b9.jpeg" alt="detail page"  height="400"><br><br>
this is detail page.you can see all information about country<br><br><br><br>

## LICENSE



```   

MIT License

Copyright (c) 2023 ishak erdoğan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
## CONTACT
[LinkedIn](https://www.linkedin.com/in/ishak-erdo%C4%9Fan-332b77233/)

[Instagram](https://www.instagram.com/ishakerdogan728/)
