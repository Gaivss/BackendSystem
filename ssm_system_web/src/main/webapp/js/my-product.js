// 删除模态框
function deteleModal(productArray){
    //打开模态框
    ${"#deteleModal"}.modal("show");

    $("#productNameDiv").empty();

    window.productIdArray = [];

    //遍历数组
    for(var i=0; i < productlist.length; i++){
        var product = productArray[i];
        var productName = product.productName;
        $("#productNameDiv").append(productName + "<br/>");
        var productId = product.id;
        window.productIdArray.push(productId)
    }
};
