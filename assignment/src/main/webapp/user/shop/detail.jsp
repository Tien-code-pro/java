<%@ page import="com.assignment.assignment.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page import="com.assignment.assignment.entity.Color" %>
<%@ page import="com.assignment.assignment.entity.Category" %>
<%@ page import="com.assignment.assignment.entity.Size" %>
<%@ page import="java.util.HashMap" %>

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

<%
    Product product = (Product) request.getAttribute("product");
    List<Color> colors = (List<Color>) request.getAttribute("color");
    List<Category> categories = (List<Category>) request.getAttribute("category");
    if (colors == null){
        colors = new ArrayList<>();
    }
    if (categories == null){
        colors = new ArrayList<>();
    }
%>



<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>


<body class="goto-here">
<jsp:include page="/user/includes/navbar.jsp"></jsp:include>
<!-- END nav -->

<div class="hero-wrap hero-bread" style="background-image: url(assets/images/bg_1.jpg);">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span class="mr-2"><a href="index.html">Product</a></span> <span>Product Single</span></p>
                <h1 class="mb-0 bread">Product Single</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 mb-5 ftco-animate">
                <a href="<%=product.getImage()%>" class="image-popup"><img src="<%=product.getImage()%>" class="img-fluid" alt="Colorlib Template"></a>
            </div>
            <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                <h3><%=product.getName()%></h3>
                <div class="rating d-flex">
                    <p class="text-left mr-4">
                        <a href="#" class="mr-2">5.0</a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                    </p>
                    <p class="text-left mr-4">
                        <a href="#" class="mr-2" style="color: #000;"><%=product.getRate()%> <span style="color: #bbb;">Rating</span></a>
                    </p>
                    <p class="text-left">
                        <a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
                    </p>
                </div>
                <p class="price"><span>$<%=product.getPrice()%></span></p>
                <p><%=product.getContent()%></p>
                <div class="row mt-4">
                    <div class="col-md-6">
                        <div class="form-group d-flex">
                            <div class="select-wrap">
                                <div class="icon"><span class="ion-ios-arrow-down"></span></div>

                                <select name="" id="" class="form-control">

                                    <%for (Size ct : sizes){%>

                                    <option value=""><%=ct.getName()%></option>

                                    <%}%>

                                </select>


                            </div>
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <div class="input-group col-md-6 d-flex mb-3">
	             	<span class="input-group-btn mr-2">
	                	<button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
	                   <i class="ion-ios-remove"></i>
	                	</button>
	            		</span>
                        <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
                        <span class="input-group-btn ml-2">
	                	<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
	                     <i class="ion-ios-add"></i>
	                 </button>
	             	</span>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-md-12">
                        <p style="color: #000;"><%=product.getMass()%> kg available</p>
                    </div>
                </div>
                <p><a href="/cart/add?productId=<%=product.getId()%>&quantity=1" class="btn btn-black py-3 px-5">Add to Cart</a></p>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center mb-3 pb-3">
            <div class="col-md-12 heading-section text-center ftco-animate">
                <span class="subheading">Products</span>
                <h2 class="mb-4">Related Products</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <%for (Product pd : products){%>
            <div class="col-md-6 col-lg-3 ftco-animate">

                <div class="product">
                    <a href="#" class="img-prod"><img class="img-fluid" src="<%=pd.getImage()%>" alt="Colorlib Template">
                        <div class="overlay"></div>
                    </a>
                    <div class="text py-3 pb-4 px-3 text-center">
                        <h3><a href="#"><%=pd.getName()%></a></h3>
                        <div class="d-flex">
                            <div class="pricing">
                                <p class="price"><span><%=pd.getPrice()%></span></p>
                            </div>
                        </div>
                        <div class="bottom-area d-flex px-3">
                            <div class="m-auto d-flex">
                                <a href="product-single.html" class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                    <span><i class="ion-ios-menu"></i></span>
                                </a>
                                <a href="product-single.html" class="buy-now d-flex justify-content-center align-items-center mx-1">
                                    <span><i class="ion-ios-cart"></i></span>
                                </a>
                                <a href="product-single.html" class="heart d-flex justify-content-center align-items-center ">
                                    <span><i class="ion-ios-heart"></i></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
    </div>
</section>

<jsp:include page="/user/includes/footer.jsp"></jsp:include>


<!-- loader -->
<%--<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>--%>


<jsp:include page="../includes/script.jsp"></jsp:include>


</body>
</html>