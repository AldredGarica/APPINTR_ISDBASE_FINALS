<!DOCTYPE html>
<html>

<head>
    <title>Contact</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Langar&display=swap');
@import url(https://fonts.googleapis.com/css?family=Roboto:300);
.Title {
    font-family: langar, cursive;
}

.form {
    position: relative;
    z-index: 1;
    background: #FFFFFF;
    max-width: 360px;
    margin: 0 auto 100px;
    padding: 45px;
    text-align: center;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form input {
    font-family: "Roboto", sans-serif;
    outline: 0;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    margin: 0 0 15px;
    padding: 15px;
    box-sizing: border-box;
    font-size: 14px;
}

.form button {
    font-family: "Roboto", sans-serif;
    text-transform: uppercase;
    outline: 0;
    background: #4CAF50;
    width: 100%;
    border: 0;
    padding: 15px;
    color: #FFFFFF;
    font-size: 14px;
    -webkit-transition: all 0.3 ease;
    transition: all 0.3 ease;
    cursor: pointer;
}

.form button:hover,
.form button:active,
.form button:focus {
    background: #43A047;
}

.form .message {
    margin: 15px 0 0;
    color: #b3b3b3;
    font-size: 12px;
}

.form .message a {
    color: #4CAF50;
    text-decoration: none;
}

.form .register-form {
    display: none;
}

.container {
    position: relative;
    z-index: 1;
    max-width: 300px;
    margin: 0 auto;
}

.container:before,
.container:after {
    content: "";
    display: block;
    clear: both;
}

.container .info {
    margin: 50px auto;
    text-align: center;
}

.container .info h1 {
    margin: 0 0 15px;
    padding: 0;
    font-size: 36px;
    font-weight: 300;
    color: #1a1a1a;
}

.container .info span {
    color: #4d4d4d;
    font-size: 12px;
}

.container .info span a {
    color: #000000;
    text-decoration: none;
}

.container .info span .fa {
    color: #EF3B3A;
}

html {
    background-image: url(/images/bg-01.jpg);
    background-size:     auto;
    background-repeat:   no-repeat;
    background-position: center center; 
}
    </style>
</head>

<body>
    <div class="register-page">
        <div class="form">
            <div class="Title">
                <p>Guitar Inquiries</p>
            </div>
            <form method="POST" action="">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="Your name..">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" placeholder="Email">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" placeholder="Title">
                <label for="subject">Message</label>
                <textarea id="subject" name="subject" placeholder="Write something.." style="width: 98%;"></textarea>

                <button type="submit" class="btn" name="send_mail">Send</button>
            </form>
        </div>
</body>

</html>