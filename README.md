# Sweet Password
[![HitCount](http://hits.dwyl.io/jesusmartinoza/Sweet-Password.svg)](http://hits.dwyl.io/jesusmartinoza/Sweet-Password) [![API VERSION](https://img.shields.io/badge/Android%20API-16-green.svg) ![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/) 

A customizable password component for Android

![](https://raw.githubusercontent.com/jesusmartinoza/sweet-password/master/screenshots/preview.gif)

## Setup
*Gradle*
```
repositories {
    jCenter()
}

dependencies {
    compile 'mx.jesusmartinoza:sweet-password:0.1'
}
```

## Usage
```
<mx.jesusmartinoza.widget.SweetPassword
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

## Available attributes
All attributes are optional
```
<mx.jesusmartinoza.widget.SweetPassword
    android:layout_width="match_parent"
    android:layout_height="wrap_content"

    app:eye_color="#6D214F"
    app:iris_color="#25CCF7"
    app:anim_duration="400"
    app:password_hint="Password" />
```

| Attribute        | Description | Default |
| ------------- |-------------|-------------|
| `eye_color` | Sets color border of the eye  | Theme color accent |
| `iris_color` | Sets iris color  | Theme color accent |
| `anim_duration` | Time to open/close the eye  | 280ms |
| `password_hint` | Hint for edit text | _Password_ |

## Set interpolator and animation duration
By default the interpolator is `DecelerateInterpolator` but you can change by anyone you want

```
SweetPassword sweetPassword = findViewById(R.id.my_sweetpassword);

sweetPassword.setInterpolator(new BounceInterpolator());
sweetPassword.setAnimDuration(700);
```

## License
```
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
