<%@ page import="com.assignment.assignment.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.assignment.assignment.entity.Category" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("listProduct");
    List<Category> categories = (List<Category>) request.getAttribute("category");
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
        <div class="row justify-content-center">
            <div class="col-md-10 mb-5 text-center">
                <ul class="product-category"  >
                    <li><a href="/user/shop" class="active">All</a></li>
                    <%for (Category ct : categories){%>
                    <li>
                        <a href="/user/shop/cate?cid=<%=ct.getId()%>">
                            <%=ct.getName()%>
                        </a>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>
        <div class="row">
            <%for (Product pd : products){%>
            <div class="col-md-6 col-lg-3 ftco-animate">

                <div class="product">
                    <a href="/user/detail?id=<%=pd.getId()%>" class="img-prod"><img class="img-fluid" src="<%=pd.getImage()%>" alt="Colorlib Template">
                        <div class="overlay"></div>
                    </a>
                    <div class="text py-3 pb-4 px-3 text-center">
                        <h3><a href="#"><%=pd.getName()%></a></h3>
                        <div class="d-flex">
                            <div class="pricing">
                                <p class="price"><span><%=pd.getPrice()%>$</span></p>
                            </div>
                        </div>
                        <div class="bottom-area d-flex px-3">
                            <div class="m-auto d-flex">
                                <a href="/user/detail?id=<%=pd.getId()%>" class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                    <span><i class="ion-ios-menu"></i></span>
                                </a>
                                <a href="/user/detail?id=<%=pd.getId()%>" class="buy-now d-flex justify-content-center align-items-center mx-1">
                                    <span><i class="ion-ios-cart"></i></span>
                                </a>
                                <a href="/user/detail?id=<%=pd.getId()%>" class="heart d-flex justify-content-center align-items-center ">
                                    <span><i class="ion-ios-heart"></i></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <%}%>
        </div>
        <div class="row mt-5">
            <div class="col text-center">
                <div class="block-27">
                    <ul>
                        <li><a href="#">&lt;</a></li>
                        <li class="active"><span>1</span></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&gt;</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../includes/footer.jsp"></jsp:include>


<!-- loader -->
<%--<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>--%>


<jsp:include page="../includes/script.jsp"></jsp:include>


</body>
</html>