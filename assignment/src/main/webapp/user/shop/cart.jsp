<%@ page import="com.assignment.assignment.entity.shoppingcart.ShoppingCart" %>
<%@ page import="com.assignment.assignment.entity.shoppingcart.CartItem" %>
<%@ page import="java.util.List" %>
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    if(shoppingCart == null){
        shoppingCart = new ShoppingCart();
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




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
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Cart</span></p>
                <h1 class="mb-0 bread">My Cart</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                            <th>Product name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%List<CartItem> items = shoppingCart.getListItems();
                            for (int i = 0; i < items.size(); i++) {%>

                        <tr class="text-center">
                            <td class="product-remove"><a href="/cart/delete?id=<%=items.get(i).getProductId()%>" onclick="return confirm('Are you sure?')"><span class="ion-ios-close"></span></a></td>

                            <td class="image-prod"><div class="img" style="background-image:url(<%=items.get(i).getProductThumbnail()%>);"></div></td>

                            <td class="product-name">
                                <h3><%=items.get(i).getProductName()%></h3>
<%--                                <p><%=items.get(i).ge()%></p>--%>
                            </td>

                            <td class="price">$<%=items.get(i).getUnitPrice()%></td>

                            <td class="quantity">

                                <div class="w-100"></div>
                                <div class="input-group col-md-15 d-flex mb-3">
								<span class="input-group-btn mr-2">
									<button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
								   <i class="ion-ios-remove"></i>
									</button>
									</span>
                                    <input type="text" id="quantity" name="quantity" class="form-control input-number" value="<%=items.get(i).getQuantity()%>" >
                                    <span class="input-group-btn ml-2">
									<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
									 <i class="ion-ios-add"></i>
								 </button>
								</span>
                                </div>
                                <div class="w-100"></div>


                            </td>
                            <td class="total"><%=items.get(i).getUnitPrice() * items.get(i).getQuantity()%></td>
                        </tr><!-- END TR-->
                        <%
                            }
                        %>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row justify-content-end">
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Coupon Code</h3>
                    <p>Enter your coupon code if you have one</p>
                    <form action="#" class="info">
                        <div class="form-group">
                            <label for="">Coupon code</label>
                            <input type="text" class="form-control text-left px-3" placeholder="">
                        </div>
                    </form>
                </div>
                <p><a href="checkout.html" class="btn btn-primary py-3 px-4">Apply Coupon</a></p>
            </div>
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Estimate shipping and tax</h3>
                    <p>Enter your destination to get a shipping estimate</p>
                    <form action="#" class="info">
                        <div class="form-group">
                            <label for="">Country</label>
                            <input type="text" class="form-control text-left px-3" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="country">State/Province</label>
                            <input type="text" class="form-control text-left px-3" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="country">Zip/Postal Code</label>
                            <input type="text" class="form-control text-left px-3" placeholder="">
                        </div>
                    </form>
                </div>
                <p><a href="checkout.html" class="btn btn-primary py-3 px-4">Estimate</a></p>
            </div>
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Cart Totals</h3>
                    <p class="d-flex">
                        <span>Subtotal</span>
                        <span>$20.60</span>
                    </p>
                    <p class="d-flex">
                        <span>Delivery</span>
                        <span>$0.00</span>
                    </p>
                    <p class="d-flex">
                        <span>Discount</span>
                        <span>$3.00</span>
                    </p>
                    <hr>
                    <p class="d-flex total-price">
                        <span>Total</span>
                        <span>$17.60</span>
                    </p>
                </div>
                <p><a href="checkout.html" class="btn btn-primary py-3 px-4">Proceed to Checkout</a></p>
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