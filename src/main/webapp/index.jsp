<!DOCTYPE html>
<html>
<head>
    <title>Hidden Field Session Example</title>
</head>
<body>
    <form method="post" action="FirstServlet">
        Name:<input type="text" name="username" /><br/>
        No of Tickets:<input type="number" name="no_of_tickets"/><br/>
        Ticket Type:
        <select name="ticket_type">
            <option value="dress_circle">Dress Circle</option>
            <option value="rear_circle">Rear Circle</option>
            <option value="front_circle">Front Circle</option>
        </select><br/>
        Age: <input type="number" name="age"/><br/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
