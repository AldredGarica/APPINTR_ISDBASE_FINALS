<!DOCTYPE html>
<html>

<head>
    <title>Contact</title>
    <link rel="stylesheet" href="/css/contact.css">
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