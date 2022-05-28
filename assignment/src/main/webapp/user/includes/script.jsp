<script src="/user/assets/js/jquery.min.js"></script>
<script src="/user/assets/js/jquery-migrate-3.0.1.min.js"></script>
<script src="/user/assets/js/popper.min.js"></script>
<script src="/user/assets/js/bootstrap.min.js"></script>
<script src="/user/assets/js/jquery.easing.1.3.js"></script>
<script src="/user/assets/js/jquery.waypoints.min.js"></script>
<script src="/user/assets/js/jquery.stellar.min.js"></script>
<script src="/user/assets/js/owl.carousel.min.js"></script>
<script src="/user/assets/js/jquery.magnific-popup.min.js"></script>
<script src="/user/assets/js/aos.js"></script>
<script src="/user/assets/js/jquery.animateNumber.min.js"></script>
<script src="/user/assets/js/bootstrap-datepicker.js"></script>
<script src="/user/assets/js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="/user/assets/js/google-map.js"></script>
<script src="/user/assets/js/main.js"></script>


<script>
    $(document).ready(function(){

        var quantitiy=0;
        $('.quantity-right-plus').click(function(e){

            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            $('#quantity').val(quantity + 1);


            // Increment

        });

        $('.quantity-left-minus').click(function(e){
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            // Increment
            if(quantity>0){
                $('#quantity').val(quantity - 1);
            }
        });

    });
</script>


<script>

    (function ($) {
    $(window).on('load', function () {
    $(".loader").fadeOut();
    $("#preloder").delay(200).fadeOut("slow");

    /*------------------
    Gallery filter
    --------------------*/
    $('.product-category li').on('click', function () {
    $('.product-category li').removeClass('active');
    $(this).addClass('active');
    });
    if ($('.product').length > 0) {
    var containerEl = document.querySelector('.product');
    var mixer = mixitup(containerEl);
    }
    });
    })(jQuery)
</script>





