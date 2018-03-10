# Sweet Password
A customizable password component for Android.
![](https://raw.githubusercontent.com/jesusmartinoza/sweet-password/master/screenshots/preview.gif)

### Setup
Pending for JCenter approval

### Usage
```
    <mx.jesusmartinoza.widget.SweetPassword
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

### Available attributes
```
    <mx.jesusmartinoza.widget.SweetPassword
        android:layout_width="match_parent"
        android:layout_height="wrap_content"

        app:iris_color="#25CCF7"
        app:eye_color="#6D214F"
        app:anim_duration="400"
        app:password_hint="Password" />
```

### Set interpolator and animation duration
By default the interpolator is `DecelerateInterpolator` but you can change by anyone you want

```
    SweetPassword sweetPassword = findViewById(R.id.my_sweetpassword);

    sweetPassword.setInterpolator(new BounceInterpolator());
    sweetPassword.setAnimDuration(700);
```

### License
``
    The MIT License (MIT)

    Copyright (c) 2018 Jesús Alberto Martínez Mendoza(@jesusmartinoza)

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
