<!--
Date: Wed Jun 27 05:43:54 SAST 2012
File: list.gsp
Author: brett chaldecott
-->

    <div class="span9">
      <ul class="thumbnails" id="productThumbnails">
        <%
        params.products.each { products ->
            def product = products[0]
            %>
            <li class="span3" id="productThumbnailEntry${product.getId()}">
                <div class="thumbnail" rel="popover" 
                    data-content="ID: ${product.getId()}<br/>Name: ${product.getName()}<br/>Description: ${product.getDescription()}<br/>Thumbnail: ${product.getThumbnail()}<br/>Icon: ${product.getIcon()}<br/>"
                    data-original-title="${product.getName()}" id="hoveroverimage${product.getId()}">
                    <img src="${params.contextBase}${product.getThumbnail()}" alt="${product.getDescription()}">
                    <div class="caption">
                        <h5><img src="${params.contextBase}${product.getIcon()}" style="height:16px;width:16px;"/> ${product.getName()}</h5>
                        <p>${product.getDescription()}</p>
                        <p><a href="javascript:removeProduct('${product.getId()}');" class="btn btn-primary">Remove</a> <a href="javascript:updateProduct('${product.getId()}');" class="btn">Update</a></p>
                        <form id="existingProductForm${product.getId()}" name="existingProductForm${product.getId()}">
                            <input type="hidden" name="existingProductId${product.getId()}" id="existingProductId${product.getId()}" value="${product.getId()}" />
                            <input type="hidden" name="existingProductName${product.getId()}" id="existingProductName${product.getId()}" value="${product.getName()}" />
                            <input type="hidden" name="existingProductDescription${product.getId()}" id="existingProductDescription${product.getId()}" value="${product.getDescription()}" />
                            <input type="hidden" name="existingProductDataType${product.getId()}" id="existingProductDataType${product.getId()}" value="${product.getDataType()}" />
                            <input type="hidden" name="existingProductCategory${product.getId()}" id="existingProductCategory${product.getId()}" value="${product.getCategory().getId()}" />
                            <input type="hidden" name="existingProductVendor${product.getId()}" id="existingProductVendor${product.getId()}" value="${product.getVendor().getId()}" />
                            <input type="hidden" name="existingProductThumbnail${product.getId()}" id="existingProductThumbnail${product.getId()}" value="${product.getThumbnail()}" />
                            <input type="hidden" name="existingDependency${product.getId()}" id="existingDependency${product.getId()}" value="${product.getDependency()}" />
                            
                        </form>
                    </div>
                </div>
            </li>
            
        
        <% } %>
      </ul><!--/row-->
    </div><!--/span-->
    
<div class="modal hide" id="productModal">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>
    <div id="addProductTitle">
        <h3>Add Product</h3>
    </div>
    <div id="updateProductTitle" style="display:none;">
        <h3>Update Product</h3>
    </div>
  </div>
  <div class="modal-body">
    <div id="modelForm">
        <form class="form-horizontal" id="productForm">
          <fieldset>
            <div class="control-group">
              <label class="control-label" for="productId">Product ID</label>
              <div class="controls">
                <input type="text" class="input-large" id="productId" name="productId">
                <p class="help-block">The id of the new product</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="productName">Product name</label>
              <div class="controls">
                <input type="text" class="input-large" id="productName" name="productName">
                <p class="help-block">The id of the product.</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="productDescription">Product description</label>
              <div class="controls">
                <input type="text" class="input-large" id="productDescription" name="productDescription">
                <p class="help-block">The id of the product.</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="productDataType">Product data type</label>
              <div class="controls">
                <input type="text" class="input-large" id="productDataType" name="productDataType">
                <p class="help-block">The product data type.</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="productCategory">Product category</label>
              <div class="controls">
                <input type="text" class="input-large" id="productCategory" name="productCategory">
                <p class="help-block">The product category.</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="productVendor">Product vendor</label>
              <div class="controls">
                <input type="text" class="input-large" id="productVendor" name="productVendor">
                <p class="help-block">The product vendor.</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="productDependency">Product dependency</label>
              <div class="controls">
                <input type="text" class="input-large" id="productDependency" name="productDependency">
                <p class="help-block">The product dependency.</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="thumbnail">Thumbnail</label>
              <div class="controls">
                <input type="text" class="input-large" id="thumbnail" name="thumbnail">
                <p class="help-block">Thumbnail URL or server path.</p>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="icon">Icon</label>
              <div class="controls">
                <input type="text" class="input-large" id="icon" name="icon">
                <p class="help-block">Icon URL or server path.</p>
              </div>
            </div>
          </fieldset>
        </form>
        <div id="modelDataErrorResult" style="display:none;">
            <div class="alert fade in alert-error">
                <span id="modelDataErrorResultMsg"></span>
            </div>
        </div>
    </div>
    <div id="modelSuccessResult" style="display:none;">
        <div class="alert fade in alert-info">
            <span id="modelSuccessResultMsg"></span>
        </div>
    </div>
    <div id="modelRuntimeErrorResult" style="display:none;">
        <div class="alert fade in alert-error">
            <span id="modelRuntimeErrorResultMsg"></span>
        </div>
    </div>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal" id="productCloseButton">Close</a>
    <a href="#" class="btn btn-primary" id="addProductItem">Add Product</a>
    <a href="#" class="btn btn-primary" id="updateProductItem" style="display:none;">Update Product</a>
  </div>
</div>


<div class="modal hide" id="removeModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Remove Product</h3>
    </div>
    <div class="modal-body">
        <div id="removeModelMsg">
            <p id="removeModelText"></p>
            <form name="removeModalForm" id="removeModalForm">
                <input type="hidden" name="removeModalFormId" id="removeModalFormId"/>
            </form>
        </div>
        <div id="removeModelSuccessMsg">
            <div class="alert fade in alert-info">
                <span id="removeModelSuccessResultMsg"></span>
            </div>
        </div>
        <div id="removeModelErrorMsg">
            <div class="alert fade in alert-info">
                <span id="removeModelErrorResultMsg"></span>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal" id="removeProductCloseButton">Close</a>
        <a href="#" class="btn btn-primary" id="removeProductItem">Remove Product</a>
    </div>
</div>

    
    
