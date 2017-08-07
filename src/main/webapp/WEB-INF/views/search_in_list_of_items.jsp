<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>

<body>

<div class="container">
    <H1>Items View</H1>

    <form action="/list_of_items" method="post">
        matchesSting:<input type="text" name="matchesSting" />
        <input type="submit" value="поиск" />
    </form>

    <div id="feedBody">
        <%--<div id="feedTitle">
            <div id="feedTitleContainer">
                <h1 id="feedTitleText" base="${feedmessages.link}">${feedmessages.title}</h1>
            </div>
        </div>--%>

        <div id="feedContent">
            <c:forEach items="${items}" var="item">
                <div class="entry">
                    <h3>
                        <a href="${item.link}">
                            <span>${item.title}</span>
                        </a>
                        <div class="lastUpdated">${item.pubDate}</div>
                    </h3>
                    <div class="feedEntryContent">
                        <p>${item.description}</p>
                        <a href="${item.link}">Читать дальше →</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>

</body>

</html>