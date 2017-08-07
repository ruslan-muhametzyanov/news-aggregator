<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<body>

<div class="container">
    <form action="/start" method="post">
        <p>
            <font color="red">${errorMessage}</font>
        </p>
        Name: <input type="text" name="url" />
        matchesSting:<input type="text" name="matchesSting" />
        <input type="submit" value="поиск" />
    </form>
</div>

</body>

</html>