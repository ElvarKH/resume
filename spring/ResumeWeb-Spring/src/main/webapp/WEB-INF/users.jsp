<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/users.css">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/9bfc143a49.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="assets/js/users.js"></script>
    <title>Users</title>

    <script>
        function setIdForDelete(id) {
            var elem = document.getElementById("idForDelete");
            elem.value = id;
        }
    </script>
</head>
<body>
<sec:authorize access="hasAuthority('USER')">
</sec:authorize>
<div class="user_container">
    <center style="margin-bottom: 170px;">
        <h1 class="display-4">Users</h1>
    </center>
    <div class="col-6" style="margin-bottom: 235px">
        <div style="float: left; margin-top: -172px;">
            <form:form action="users" method="GET" modelAttribute="user">
                <div class="form-group">
                    <label for="name">Name: </label>
                    <form:input path="name" placeolder="Enter name" class="form-control"/>
                    <form:errors path="name" cssClass="error/" cssStyle="color: red"/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname: </label>
                    <form:input path="surname" placeolder="Enter surname" class="form-control"/>
                    <form:errors path="surname" cssClass="error/" cssStyle="color: red"/>
                </div>

                <form:button type="submit" class="btn btn-primary" id="btn_search">
                    Search
                </form:button>
            </form:form>
        </div>
        <div style="float: left;">
            <sec:authorize access="!hasAuthority('ADMIN')">
                <div class="div-2" style="padding-left: 495px; bottom: 16px;">
                    <form action="login" method="GET">
                        <input class="btn btn-info" type="submit" style="width: 105px" value="Sign in"/>
                    </form>
                </div>
            </sec:authorize>
            <sec:authorize access="hasAuthority('ADMIN')">
                <div class="div-2" style="padding-left: 495px; bottom: 16px;">
                    <form action="logout" method="GET">
                        <input class="btn btn-danger" type="submit" style="width: 105px" value="Log out"/>
                    </form>
                </div>
                <div class="div-2" style="bottom: -38px; left: 780px">
                    <form:form action="user-create" method="GET" modelAttribute="user">
                        <form:button class="btn btn-success"
                                type="submit">
                            Create new
                        </form:button>
                    </form:form>
                </div>
            </sec:authorize>
        </div>
    </div>
    <div class="table_user">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Nationality</th>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <th></th>
                    <th></th>
                </sec:authorize>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="u">
                <tr>
                    <td>${u.getName()}</td>
                    <td>${u.getSurname()}</td>
                    <td>${u.getNationalityId().getNationality()}</td>
                    <sec:authorize access="hasAuthority('ADMIN')">
                        <td style="width: 1px">
                            <form:form action="user-details-edit" method="GET">
                                <input type="hidden" name="id" value="${u.getId()}">
                                <button class="btn_table btn_update btn-secondary" type="submit" value="update">
                                    <i class="fas fa-pen-square"></i>
                                </button>
                            </form:form>
                        </td>
                        <td style="width: 1px">
                            <button class="btn_table btn_delete btn-danger" type="button" value="delete"
                                    data-toggle="modal" data-target="#exampleModal"
                                    onclick="setIdForDelete(${u.getId()})">
                                <i class="far fa-trash-alt"></i>
                            </button>
                        </td>
                    </sec:authorize>
                    <td style="width: 1px">
                        <form:form action="user-details" method="GET">
                            <input type="hidden" name="id" value="${u.getId()}">
                            <button class="btn_table btn-info" style="border-radius: 20px; font-size: 20px;"
                                    type="submit" value="info">
                                <i class="fas fa-question-circle"></i>
                            </button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure ?
            </div>
            <div class="modal-footer">
                <form:form action="users" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
