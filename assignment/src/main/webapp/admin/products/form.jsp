<%@ page import="com.assignment.assignment.entity.Product" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.assignment.assignment.entity.Color" %>
<%@ page import="java.util.List" %>
<%@ page import="com.assignment.assignment.entity.Category" %>
<%@ page import="com.assignment.assignment.entity.myenum.ProductStatus" %>
<%@ page import="com.assignment.assignment.entity.Size" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Product product = (Product) request.getAttribute("product");
  List<Color> color = (List<Color>) request.getAttribute("color");
  List<Category> categories = (List<Category>) request.getAttribute("categories");
  List<Size> sizes = (List<Size>) request.getAttribute("sizes");
  int action = (int) request.getAttribute("action");
  HashMap<String,String> errors = (HashMap<String, String>) request.getAttribute("errors");
  String url = "/admin/products/create";
  if(action == 2){
    url = "/admin/products/edit";
  }
  if (errors == null){
    errors = new HashMap<>();
  }
  if (color == null){
    errors = new HashMap<>();
  }
  if (categories == null){
    errors = new HashMap<>();
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
        <div class="section-header">
          <h1>Forms</h1>
        </div>

        <div class="section-body">
          <div class="row">
            <div class="col-12 col-md-12">
              <form action="<%=url%>" method="post" name="product-form">
                <div class="card-header">
                  <%if (action == 2){%>
                    <h4>Edit Product</h4>
                  <%}else {%>
                    <h4>Create New Product</h4>
                  <%}%>
                </div>
                <div class="card-body">
                  <div class="form-group">
                    <label for="id">Id</label>
                    <input type="text" class="form-control  col-md-2" id="id" name="id" placeholder="Enter id" value="<%=product.getId()%>" <%=action == 2 ? "readonly":""%>>
                    <%if (errors.containsKey("id")){%>
                    <span class="text-danger">* <%=errors.get("id")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control  col-md-4" id="name" name="name" placeholder="Enter name"  value="<%=product.getName()%>">
                    <%if (errors.containsKey("name")){%>
                    <span class="text-danger">* <%=errors.get("name")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="upload_widget">Image</label>
                    <div class="input-group  col-md-4" style="padding: 0px">
                      <div class="custom-file">
                        <input type="text" class="form-control" id="upload_widget" name="image" placeholder="Choose image"  value="<%=product.getImage()%>">
                      </div>
                      <%if (errors.containsKey("image")){%>
                      <span class="text-danger">* <%=errors.get("image")%></span>
                      <%}%>
                      <div class="input-group-append">
                        <span class="input-group-text">Upload</span>
                      </div>
                    </div>
                    <img id="preview-image" src="<%=product.getImage()%>" style="<%if (action ==2){%>display: block;<%}else {%>display: none;<%}%>" class="img-thumbnail m-md-2" width="200px;">
                  </div>
                  <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number" class="form-control col-md-2" id="price" name="price" placeholder="Enter price" value="<%=product.getPrice()%>">
                    <%if (errors.containsKey("price")){%>
                    <span class="text-danger">* <%=errors.get("price")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="qty">Quantity</label>
                    <input type="number" class="form-control phone-number col-md-2" id="qty" name="qty" placeholder="Enter quantity" value="<%=product.getQty()%>">
                    <%if (errors.containsKey("qty")){%>
                    <span class="text-danger">* <%=errors.get("qty")%></span>
                    <%}%>
                  </div>

                  <div class="form-group">
                    <label for="color_id">Color</label>
                    <select class="form-control col-md-3" id="color_id" name="color_id">
                      <%if (action==1){%><option value="0">Tất cả</option><%}%>
                      <%for (int i = 0; i < color.size(); i++) {%>
                      <%if (product.getColor_id() == color.get(i).getId()){%>
                      <option selected value="<%=color.get(i).getId()%>"><%=color.get(i).getName()%></option>
                      <%}else{%>
                      <option value="<%=color.get(i).getId()%>"><%=color.get(i).getName()%></option>
                      <%}}%>
                    </select>
                    <%if (errors.containsKey("color_id")){%>
                    <span class="text-danger">* <%=errors.get("color_id")%></span>
                    <%}%>
                  </div>

                  <div class="form-group">
                    <label for="size_id">Size</label>
                    <select class="form-control col-md-3" id="size_id" name="size_id">
                      <%if (action==1){%><option value="0">Tất cả</option><%}%>

                      <%for (int i = 0; i < sizes.size(); i++) {%>

                      <%if (product.getSize_id() == sizes.get(i).getId()){%>
                      <option selected value="<%=sizes.get(i).getId()%>"><%=sizes.get(i).getName()%></option>
                      <%}else{%>
                      <option value="<%=sizes.get(i).getId()%>"><%=sizes.get(i).getName()%></option>
                      <%}}%>
                    </select>
                    <%if (errors.containsKey("size_id")){%>
                    <span class="text-danger">* <%=errors.get("size_id")%></span>
                    <%}%>
                  </div>

                  <div class="form-group">
                    <label for="category_id">Category</label>
                    <select class="form-control col-md-3" id="category_id" name="category_id">
                      <%if (action==1){%><option value="0">Tất cả</option><%}%>
                      <%for (int i = 0; i < categories.size(); i++) {%>
                        <%if (product.getCategory_id() == categories.get(i).getId()){%>
                          <option selected value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                        <%}else{%>
                          <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                      <%}}%>
                    </select>
                    <%if (errors.containsKey("category_id")){%>
                    <span class="text-danger">* <%=errors.get("category_id")%></span>
                    <%}%>
                  </div>

                  <div class="form-group col-md-10">
                    <label for="contents">Content</label>
                    <textarea class="summernote" id="contents" name="content"><%=product.getContent()%></textarea>
                    <%if (errors.containsKey("content")){%>
                    <span class="text-danger">* <%=errors.get("content")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label >Rate</label>
                    <input type="text" class="form-control  col-md-4" name="rate" placeholder="Enter rate"  value="<%=product.getRate()%>">
                    <%if (errors.containsKey("rate")){%>
                    <span class="text-danger">* <%=errors.get("rate")%></span>
                    <%}%>
                  </div>

                  <div class="form-group">
                    <label >Mass</label>
                    <input type="text" class="form-control  col-md-4" name="mass" placeholder="Enter mass"  value="<%=product.getMass()%>">
                    <%if (errors.containsKey("mass")){%>
                    <span class="text-danger">* <%=errors.get("mass")%></span>
                    <%}%>
                  </div>


                  <div class="form-group">
                    <label for="status">Status</label>
                    <select class="form-control col-md-2" id="status" name="status">
                      <%for (int i = 0; i < ProductStatus.values().length; i++) {%>
                      <option <%=product.getStatus() == ProductStatus.values()[i] ? "selected" : ""%> value="<%=ProductStatus.values()[i].getValue()%>"><%=ProductStatus.values()[i].name()%></option>
                      <%}%>
                    </select>
                  </div>
                </div>
                <div class="card-footer col-md-12">
                  <button class="btn btn-primary" type="submit">Submit</button>
                  <button class="btn btn-secondary" type="reset">Reset</button>
                </div>
              </form>

            </div>
          </div>
        </div>
      </section>
    </div>
    <jsp:include page="../includes/footer.jsp"></jsp:include>
  </div>
</div>

<jsp:include page="../includes/script.jsp"></jsp:include>
<!-- Cloudinary -->
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
  var myWidget = cloudinary.createUploadWidget({
            cloudName: 'dawqhfo1e',
            uploadPreset: 'new-image'}, (error, result) => {
            if (!error && result && result.event === "success") {
              console.log('Done! Here is the image info: ', result.info.secure_url);
              document.forms['product-form']['image'].value = result.info.secure_url;
              document.getElementById('preview-image').src = result.info.secure_url;
              document.getElementById('preview-image').style.display = 'block';
            }
          }
  )
  document.getElementById("upload_widget").addEventListener("click", function(){
    myWidget.open();
  }, false);
</script>
</body>

</html>