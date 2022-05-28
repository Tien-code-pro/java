<%@ page import="java.util.List" %>
<%@ page import="com.assignment.assignment.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.assignment.assignment.entity.Color" %>
<%@ page import="com.assignment.assignment.entity.Category" %>
<%@ page import="com.assignment.assignment.entity.Size" %>
<%@ page import="java.util.HashMap" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String,String> errors = (HashMap<String, String>) request.getAttribute("errors");
    List<Size> sizes = (List<Size>) request.getAttribute("size");
    List<Product> products = (List<Product>) request.getAttribute("listProduct");
    if (products == null){
        products = new ArrayList<>();
    }
    if (sizes == null){
        errors = new HashMap<>();
    }
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body>
<div id="app">
    <div class="main-wrapper main-wrapper-1">
        <jsp:include page="../includes/navbar.jsp"></jsp:include>
        <jsp:include page="../includes/sidebar.jsp"></jsp:include>
        <!-- Main Content -->
        <div class="main-content">
            <section class="section">
                <h2 class="section-title"><a href="/admin/products/create">Create New Product</a></h2>
                <div class="section-body">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4>List Product</h4>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped" id="table-1">
                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Price</th>
                                                <th>Size</th>
                                                <th>Quantity</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%for (Product pd : products){%>
                                            <tr>
                                                <th><%=pd.getName()%></th>
                                                <th><img src="<%=pd.getImage()%>" class="img-thumbnail" width="120px"></th>
                                                <th><%=pd.getPrice()%></th>

                                                <%--size--%>
                                                <%for (Size ct : sizes){%>
                                                    <%if(pd.getSize_id() == ct.getId()){%>
                                                        <th><%=ct.getName()%></th>
                                                    <%}%>
                                                <%}%>
                                                <%--qty--%>
                                                <th><%=pd.getQty()%></th>
                                                <th>
                                                    <%if (pd.getQty() > 0){%>
                                                        <div class="badge badge-success">Stocking</div>
                                                    <%}%>
                                                    <%if (pd.getQty() == 0){%>
                                                        <div class="badge badge-danger">Out of stock</div>
                                                    <%}%>
                                                </th>
                                                <th>
                                                    <a href="/admin/products/detail?id=<%=pd.getId()%>"><i class="fas fa-arrow-circle-right"></i></a>
                                                    <a href="/admin/products/edit?id=<%=pd.getId()%>"><i class="fa fa-pencil-alt"></i></a>
                                                    <a href="/admin/products/delete?id=<%=pd.getId()%>" onclick="return confirm('Are you sure?')"><i class="fas fa-trash"></i></a>
                                                </th>
                                            </tr>
                                            <%}%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </div>
</div>

<jsp:include page="../includes/script.jsp"></jsp:include>

</body>

</html>