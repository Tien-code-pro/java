<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
    <h2>Register Succesfully</h2>

    <div class="w3-card-4">
        <div class="w3-container w3-green">
            <h2>Input Form</h2>
        </div>

        <form class="w3-container">
            <p>
                <input class="w3-input" type="text">
                <label><%=request.getAttribute("username")%></label></p>
            <p>
                <input class="w3-input" type="text">
                <label><%=request.getAttribute("email")%></label></p>
            <p>
                <input class="w3-input" type="text">
                <label><%=request.getAttribute("password")%></label></p>
        </form>
    </div>
</div>

</body>
</html>
