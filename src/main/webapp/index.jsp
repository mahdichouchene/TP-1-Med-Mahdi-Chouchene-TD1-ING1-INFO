<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Web Application</title>
</head>
<body>
<h1>Welcome to My Web Application</h1>
<p>This is a simple web application.</p>
<form action="form-servlet"  method="post">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="fn" placeholder="Your name..">
    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="ln" placeholder="Your last name..">
    <label for="birthday">Birth date</label>
    <input type="date" id="birthday" name="birthday">
    <label >Gender :</label>
    <input type="radio" id="male" name="gender" value="male">
    <label for="male">Male</label>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">Female</label>
    <button type="submit">Submit</button>
    <a href="cookie-servlet">Click Here to see the Cookies</a>
    <a href="ShowSession">Click Here to see the the session</a>
</form>
</body>