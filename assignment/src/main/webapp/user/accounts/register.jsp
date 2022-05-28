<%@ page import="com.assignment.assignment.entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) request.getAttribute("account");
    if (account == null) {
        account = new Account();
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.assignment.assignment.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("listProduct");
    if (products == null){
        products = new ArrayList<>();
    }
%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body class="goto-here">
<jsp:include page="../includes/navbar.jsp"></jsp:include>
<!-- END nav -->

<div class="hero-wrap hero-bread" style="background-image: url(/user/assets/images/bg_1.jpg);">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Products</span></p>
                <h1 class="mb-0 bread">Products</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">

        <%--        form submit--%>
            <div class="row">
                <div class="col-lg-8 col-md-8">
                    <%
                        if(account.getListErrors().size() > 0) {
                    %>
                    <p class="error_code">
                    <ul>
                        <% for (int i = 0; i < account.getListErrors().size(); i++) { %>
                        <li><%=account.getListErrors().get(i)%></li>
                        <% } %>
                    </ul>
                    </p>
                    <% } %>
                </div>
            </div>

        <form action="/register" method="post" class="billing-form">

            <h3 class="mb-4 billing-heading">Register</h3>
            <div class="row align-items-end">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>First Name <span>*</span></label>
                        <input type="text" class="form-control" value="<%= account.getFirstName() %>" placeholder="" name="firstName" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Last Name <span>*</span></label>
                        <input type="text" class="form-control" value="<%= account.getLastName() %>" placeholder="" name="lastName" required>
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-md-9">
                    <div class="form-group">
                        <label>Username<span>*</span></label>
                        <input type="text" class="form-control" value="<%= account.getUsername() %>" placeholder="" name="username" required>
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Phone <span>*</span></label>
                        <input type="text" class="form-control" value="<%= account.getPhone() %>"  placeholder="" name="phone" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Email <span>*</span></label>
                        <input type="text" class="form-control" value="<%= account.getEmail() %>" placeholder="" name="email" required>
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Password <span>*</span></label>
                        <input type="password" class="form-control" name="password" placeholder="" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Confirm Password</label>
                        <input type="password"  class="form-control" name="rePassword" placeholder="" required>
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="form-group">
                    <button type="submit" value="Register" class="btn btn-primary py-3 px-5">Register</button>
                </div>
            </div>
        </form>

    </div>
</section>

<jsp:include page="../includes/footer.jsp"></jsp:include>


<!-- loader -->
<%--<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>--%>


<jsp:include page="../includes/script.jsp"></jsp:include>

</body>
</html>
